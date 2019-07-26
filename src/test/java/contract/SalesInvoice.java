package contract;
import com.alibaba.fastjson.JSON;
import helper.FileHelper;
import javaBean.InvoiceSalesApplication;
import javaBean.SalesInvoiceDetailVO;
import javaBean.SalesInvoiceVO;
import javaBean.SubformInvoiceSalesApplicationVO;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static helper.DataProvider.*;
import static util.JDBCUtil.sqlExecute;
import static util.JsonPathUtil.modifyFile;

/**
 * @Classname SalesInvoice
 * @Description 创建销售发货订单并关联子单
 * @Date 2019/7/3 13:21
 * @Created by:lixiaoming1
 */
public class SalesInvoice {
    private static String ReqJson = FileHelper.getBodyJson("/json/sales_invoice.json");
    private static String SubReqJson = FileHelper.getBodyJson("/json/sales_invoice_detail.json");
    private static SalesInvoiceVO salesInvoiceObject;
    private static SalesInvoiceDetailVO salesInvoiceDetailObject;

    /**
     * 生成销售发货单
     * @throws Exception
     */
    public static void salesInvoiceBeach() throws Exception{
        //获取发货订单编号
        String orderNO=getOrderNO();
        String modjson = getUniqueOrderNO(orderNO);
        salesInvoiceObject = JSON.parseObject(modjson, SalesInvoiceVO.class);
        salesInvoiceSql();

    }
    /**
     * 根据已生成的发货单主表，生成子表信息
     *
     * @throws Exception
     */
    public static void subInvoiceSalesApplication(String orderNO,Boolean switchControl) throws Exception {
        //获取开票申请子表对象,把子表对象放在List集合里面
        salesInvoiceDetailObject = JSON.parseObject(SubReqJson, SalesInvoiceDetailVO.class);
        System.out.println(salesInvoiceDetailObject);
        //获取开票申请子表对象,把子表对象放在List集合里面
        int getApplicationListLength = salesInvoiceDetailObject.getDeliverylist().size();
        StringBuffer str = new StringBuffer();
        //遍历循环获取对象
        for (int i = 0; i < getApplicationListLength; i++) {
            //orderNO，子表关联主表
            salesInvoiceDetailObject.getDeliverylist().get(i).setOrder_no(orderNO);
            //将对象转换成插入子表的内容，有多个则进行拼接
            String conent =  salesInvoiceDetailObject.getDeliverylist().get(i).getSubSalesInvoiceData();
            if (getApplicationListLength > 1 && i < getApplicationListLength - 1) {
                str.append(conent + ",");
            } else {
                str.append(conent + ";");
            }
        }
       // subformInvoicingApplicationSql(str);
        System.out.println(str);
    }
    /**
     * 销售发货订单执行的sql
     */
    private static void salesInvoiceSql() throws SQLException {
        String str = salesInvoiceObject.getSalesData();
        String sql = "insert into writeoff_sales_shipping (order_type,order_no,shipping_date,order_status,data_source)VALUES" + str;
        System.out.println(sql);
        sqlExecute(sql);
    }

    private static String getUniqueOrderNO(String orderNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("$.order_no", orderNo);
        String modjson = modifyFile(map, ReqJson);
        System.out.println(modjson);
        return modjson;
    }
    @Test
    public void test1()throws Exception{
        //salesInvoiceBeach();
        subInvoiceSalesApplication("43434",true);
    }
}
