package contract;

import filter.FinenterTestCase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static contract.TwoBsalesOrder.get2BECOrder;
import static contract.login.loginStr;
import static io.restassured.RestAssured.given;

/**
 * @Classname FinancialAuditOrders
 * @Description 财务审单
 * @Date 2019/7/20 20:47
 * @Created by:lixiaoming1
 */
public class FinancialAuditOrders extends FinenterTestCase {
    public static String ecOrder="{\"orders\":[{\"orderCode\":\""+get2BECOrder()+"\"}]}";

    /**
     * 财务审核
     * @return
     */
    public  static Response getFinancialAuditOrdersResult(){
        return   given().contentType("application/json;charset=utf-8").header("authorization",loginStr()).body(ecOrder).
                when().post("https://tmallapi.bluemoon.com.cn/ec-oms/mallorder/admin/importOrder/orderCheckPass").
                then().extract().response();
    }
    @Test
    public static void f(){
        getFinancialAuditOrdersResult();
    }
}
