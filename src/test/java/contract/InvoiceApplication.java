package contract;

import filter.FinenterTestCase;
import helper.FileHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static contract.login.loginStr;
import static io.restassured.RestAssured.given;

/**
 * @Classname InvoiceApplication
 * @Description   发票申请
 * @Date 2019/7/22 10:56
 * @Created by:lixiaoming1
 */
public class InvoiceApplication extends FinenterTestCase {
    private static String ReqJson = FileHelper.getBodyJson("/json/invoiceApplication.json");
    public static Response getInvoiceApplication() {

        return given().contentType("application/json;charset=utf-8").header("authorization", loginStr()).body(ReqJson).
                when().post("https://tmallapi.bluemoon.com.cn/ec-oms/mallorder/admin/invoice/saveInvoiceInfo").
                then().extract().response();
    }
    @Test
    public static void f(){
        getInvoiceApplication();
    }
}
