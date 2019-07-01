package testCase;
import com.alibaba.fastjson.JSON;
import enumPackage.getStatus;
import helper.FileHelper;
import javaBean.InvoiceSalesApplication;
import javaBean.SubformInvoiceSalesApplication;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static helper.DataProvider.getInvoiceApplicationNumber;
import static util.JDBCUtil.sqlExecute;
import static util.JsonPathUtil.modifyFile;

public class InvoiceSalesApplicationTest {
 private static String ReqJson = FileHelper.getBodyJson("/json/invoice_sales_application.json");
 private static String SubReqJson = FileHelper.getBodyJson("/json/invoice_sales_application_detail.json");
 private static InvoiceSalesApplication SalesApplication;
 private static SubformInvoiceSalesApplication subformSalesApplication;

	@Test(description = "开票申请主表",invocationCount =2, priority = 0)
	public void invoiceSalesApplication() throws Exception {
		 String application_no= getInvoiceApplicationNumber();//获取订单申请编号
		Map<String, Object> map = new HashMap<>();
		map.put("$.application_no",application_no);
		map.put("$.ec_order_no", "395145635906798035");
		map.put("$.status", getStatus.Processed.getValue());//通过枚举值的方式默认订单状态为已处理订单
		String  modjson = modifyFile(map,ReqJson);
		System.out.println(modjson);
		SalesApplication= JSON.parseObject(modjson,InvoiceSalesApplication.class);
		String sql="insert into invoice_sales_application (status,application_no,invoice_type,invoice_category,ec_order_no) values("+SalesApplication.getStatus()+",'"+SalesApplication.getApplication_no()+"',"+SalesApplication.getInvoice_type()+","+SalesApplication.getInvoice_category()+",'"+SalesApplication.getEc_order_no()+"'"+");";
		sqlExecute(sql);
	}

	@Test(description = "开票申请子表",invocationCount =3,priority =2)
	public void subformInvoiceApplication() throws Exception {
		Map<String, Object> subformMap = new HashMap<>();
		//subformMap.put("$.application_no",application_no);
		subformMap.put("$.ec_order_no", "395145635906798035");
		String  subformmodjson = modifyFile(subformMap,SubReqJson);
		System.out.println("子单字段:"+subformmodjson);
		subformSalesApplication=JSON.parseObject(subformmodjson,SubformInvoiceSalesApplication.class);
		String sql1="insert into invoice_sales_application_detail (application_no,shop_order_id,ec_order_no,order_type,del_flag)VALUES("+"'"+subformSalesApplication.getApplication_no()+"','"+subformSalesApplication.getEc_order_no()+"','"+subformSalesApplication.getShop_order_id()+"',"+subformSalesApplication.getOrder_type()+","+subformSalesApplication.getDel_flag()+""+");";
		System.out.println("----"+sql1);
		sqlExecute(sql1);
	}


	}