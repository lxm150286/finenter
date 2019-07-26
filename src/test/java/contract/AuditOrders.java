package contract;
import filter.FinenterTestCase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static contract.TwoBsalesOrder.get2BECOrder;
import static contract.login.loginStr;
import static io.restassured.RestAssured.given;

/**
 * @Classname AuditOrders
 * @Description 审核通过的2B订单
 * @Date 2019/7/20 21:39
 * @Created by:lixiaoming1
 */
public class AuditOrders extends FinenterTestCase {
    public static String ecOrder = "{\"orderCodes\":[{\"orderCode\":\"" + get2BECOrder() + "\"}]}";
    public static Response getAuditOrdersResult() {
        return given().contentType("application/json;charset=utf-8").header("authorization", loginStr()).body(ecOrder).
                when().post("https://tmallapi.bluemoon.com.cn/ec-oms/mallorder/admin/orderMsg/verifyOrder").
                then().extract().response();
    }
    @Test
    public static void f(){
        getAuditOrdersResult();
    }
}