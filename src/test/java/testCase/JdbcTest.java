package testCase;

import com.alibaba.fastjson.JSON;
import enumPackage.getStatus;
import helper.FileHelper;
import javaBean.InvoiceSalesApplication;
import javaBean.SubformInvoiceSalesApplication;
import javaBean.SubformInvoiceSalesApplicationVO;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static helper.DataProvider.getInvoiceApplicationNumber;
import static util.JDBCUtil.sqlExecute;
import static util.JsonPathUtil.modifyFile;

public class JdbcTest {
    private static String ReqJson = FileHelper.getBodyJson("/json/invoice_sales_application.json");
    private static String SubReqJson = FileHelper.getBodyJson("/json/invoice_sales_application_detailList.json");
    private static InvoiceSalesApplication SalesApplication;
    private static SubformInvoiceSalesApplicationVO subSalesApplicationVO;

    @Test(description = "开票申请主表",invocationCount =1, priority = 0)
    public void invoiceSalesApplication() throws Exception {
        String application_no= getInvoiceApplicationNumber();
        Map<String, Object> map = new HashMap<>();

        map.put("$.application_no",application_no);
        map.put("$.ec_order_no", "395145635906798035");
        map.put("$.status", getStatus.Processed.getValue());//通过枚举值的方式默认订单状态为已处理订单
        String  modjson = modifyFile(map,ReqJson);
        System.out.println(modjson);
        SalesApplication= JSON.parseObject(modjson,InvoiceSalesApplication.class);
       /* String sql="insert into invoice_sales_application (status,application_no,invoice_type,invoice_category,ec_order_no) values("+SalesApplication.getStatus()+",'"+SalesApplication.getApplication_no()+"',"+SalesApplication.getInvoice_type()+","+SalesApplication.getInvoice_category()+",'"+SalesApplication.getEc_order_no()+"'"+");";
        sqlExecute(sql);*/
        //数据库插入子单
        /*Map<String, Object> subformMap = new HashMap<>();
        subformMap.put("$.application_no",application_no);
        subformMap.put("$.ec_order_no", "395145635906798035");
        String  subformmodjson = modifyFile(subformMap,SubReqJson);
*/
        subSalesApplicationVO=JSON.parseObject(SubReqJson,SubformInvoiceSalesApplicationVO.class);
        for (int i = 0; i <subSalesApplicationVO.getApplication().size(); i++) {
            System.out.println( subSalesApplicationVO.getApplication().get(i));
            String conent=subSalesApplicationVO.getApplication().get(i).getEc_order_no()+","+subSalesApplicationVO.getApplication().get(i).getOrder_type()+","+
                    subSalesApplicationVO.getApplication().get(i).getShop_order_id()+subSalesApplicationVO.getApplication().get(i).getDel_flag()+subSalesApplicationVO.getApplication().get(i).getApplication_no();
            System.out.println(conent);
        }
      /*  String sql1="insert into invoice_sales_application_detail (application_no,shop_order_id,ec_order_no,order_type,del_flag)VALUES("+"'"+subSalesApplication.getApplication_no()+"','"+subSalesApplication.getEc_order_no()+"','"+subSalesApplication.getShop_order_id()+"',"+subSalesApplication.getOrder_type()+","+subSalesApplication.getDel_flag()+""+");";
        sqlExecute(sql1);*/
    }
}
