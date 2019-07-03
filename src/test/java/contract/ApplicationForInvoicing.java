package contract;

import com.alibaba.fastjson.JSON;
import helper.FileHelper;
import javaBean.InvoiceSalesApplication;
import javaBean.SubformInvoiceSalesApplicationVO;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static helper.DataProvider.getECOrderNumber;
import static helper.DataProvider.getInvoiceApplicationNumber;
import static util.JDBCUtil.sqlExecute;
import static util.JsonPathUtil.modifyFile;

/**
 * @Classname
 * @Description  根据各种场景,封装创建开票申请单，关联子表
 * @Date 2019/7/2 11:04
 * @Created by:lixiaoming1
 */

public class ApplicationForInvoicing {
    private static String ReqJson = FileHelper.getBodyJson("/json/invoice_sales_application.json");
    private static String SubReqJson = FileHelper.getBodyJson("/json/invoice_sales_application_detailList.json");
    private static InvoiceSalesApplication SalesApplication;
    private static SubformInvoiceSalesApplicationVO subSalesApplicationVO;


    /**
     * 传入开票申请单号，开票主表生成一条开票记录，同时创建关联的子表
     * @param application_no  申请单号
     * @throws Exception
     */
    public static void invoiceSalesApplication(String application_no) throws Exception{
        String modjson = getUniqueApplicationNumber(application_no);
        SalesApplication= JSON.parseObject(modjson,InvoiceSalesApplication.class);
        invoiceApplicationSql();
         subInvoiceSalesApplication(application_no);
    }
    public static void invoiceSalesApplication(String application_no,Boolean con) throws Exception{
        String modjson = getUniqueApplicationNumber(application_no);
        SalesApplication= JSON.parseObject(modjson,InvoiceSalesApplication.class);
        invoiceApplicationSql();
        subInvoiceSalesApplication(application_no,false);
    }
    /**
     * 根据已生成的开票申请主表，生成子表信息
     *
     * @throws Exception
     */
    public static void subInvoiceSalesApplication(String application_no,Boolean switchControl) throws Exception {
        //获取开票申请子表对象,把子表对象放在List集合里面
        subSalesApplicationVO = JSON.parseObject(SubReqJson, SubformInvoiceSalesApplicationVO.class);
        //获取开票申请子表对象,把子表对象放在List集合里面
        int getApplicationListLength = subSalesApplicationVO.getApplication().size();
        StringBuffer str = new StringBuffer();
        //遍历循环获取对象
        for (int i = 0; i < getApplicationListLength; i++) {
           //通过一个application_no，子表关联主表
            subSalesApplicationVO.getApplication().get(i).setApplication_no(application_no);
            //开关控制,修改EC订单编号
          if(switchControl){
              //一张开票只能关联一张EC订单
              subSalesApplicationVO.getApplication().get(i).setEc_order_no(getECOrderNumber());
          }

            //将对象转换成插入子表的内容，有多个则进行拼接
            String conent = subSalesApplicationVO.getApplication().get(i).getSubformData();
            if (getApplicationListLength > 1 && i < getApplicationListLength - 1) {
                str.append(conent + ",");
            } else {
                str.append(conent + ";");
            }
        }
        subformInvoicingApplicationSql(str);
    }

    /**
     * 重载生成子票信息
     * @param application_no
     * @throws Exception
     */
    public static void subInvoiceSalesApplication(String application_no)throws Exception {
        subInvoiceSalesApplication(application_no,true);
    }
    /**
     * 批量造单，创建开票申请主表，关联创建子表
     * @throws Exception
     */
    public static void invoiceSalesApplicationBatch() throws Exception {
        //获取开票申请单号
        String application_no=getInvoiceApplicationNumber();
        String modjson = getUniqueApplicationNumber(application_no);
        SalesApplication = JSON.parseObject(modjson, InvoiceSalesApplication.class);
        invoiceApplicationSql();
        subInvoiceSalesApplication(application_no);
    }

    /**
     * 批量造单，重载的方法
     * @param modifyMap
     * @throws Exception
     */
    public void invoiceSalesApplicationBatch(Map modifyMap) throws Exception {
        String application_no=getInvoiceApplicationNumber();
        String modjson = modifyFile(modifyMap, ReqJson);
        System.out.println(modjson);
        SalesApplication = JSON.parseObject(modjson, InvoiceSalesApplication.class);
        invoiceApplicationSql();
        subInvoiceSalesApplication(application_no);
    }
    /**
     * 开票申请单号唯一
     * @param application_no
     * @return
     */
    private static String getUniqueApplicationNumber(String application_no) {
        Map<String, Object> map = new HashMap<>();
        map.put("$.application_no", application_no);
        String modjson = modifyFile(map, ReqJson);
        System.out.println(modjson);
        return modjson;
    }
    /**
     * 主表开票申请执行的sql
     * @throws SQLException
     */
    private static void invoiceApplicationSql() throws SQLException {
        String str = SalesApplication.getData();
        String sql = "insert into invoice_sales_application (status,customer_service_note,application_no,invoice_type,invoice_category,shop_code,shop_order_id,ec_order_no,order_status,del_flag) values" + str;
        System.out.println(sql);
        sqlExecute(sql);
    }

    /**
     * 子表开票执行的sql
     * @param str
     * @throws SQLException
     */
    private static void subformInvoicingApplicationSql(StringBuffer str) throws SQLException {
        //执行sql
        String subsql = "insert into invoice_sales_application_detail (application_no,shop_order_id,ec_order_no,order_status,del_flag)VALUES" + str;
        sqlExecute(subsql);
        System.out.println(subsql);
    }

    @Test
    public  void test() throws Exception {
       // invoiceSalesApplicationmain("KP222908762");
       // subInvoiceSalesApplication("KP222908762099");
        invoiceSalesApplicationBatch();
    }
}