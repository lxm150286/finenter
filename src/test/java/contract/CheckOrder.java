package contract;
import filter.FinenterTestCase;
import helper.FileHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static contract.TwoBsalesOrder.get2BECOrder;
import static contract.login.loginStr;
import static io.restassured.RestAssured.given;
import static util.JsonPathUtil.modifyFile;

/**
 * @Classname CheckOrder
 * @Description TODO
 * @Date 2019/7/20 21:48
 * @Created by:lixiaoming1
 */
public class CheckOrder extends FinenterTestCase {
    private static String ReqJson = FileHelper.getBodyJson("/json/check_order_application.json");
    public static Response getCheckOrder(String ECorder) {
        Map<String,Object> map =new HashMap<>();
        map.put("firConText",ECorder);
        map.put("sql2","a.order_code = '"+ECorder+"'");
        return getCheckOrder(map);
    }
    public static Response getCheckOrder(Map<String,Object> map) {
        String modjson = modifyFile(map, ReqJson);
        return given().contentType("application/json;charset=utf-8").header("authorization", loginStr()).body(ReqJson).
                when().post("https://tmallapi.bluemoon.com.cn/ec-oms/mallorder/admin/orderSelect/getOrderSelectListByParams").
                then().extract().response();
    }
    @Test
    public static void f(){
        getCheckOrder("10190720203447246946667");
    }
}
