package contract;

import config.CommonConfig;
import filter.FinenterTestCase;
import helper.FileHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static contract.login.loginStr;
import static io.restassured.RestAssured.given;

/**
 * @Classname TwoBsalesOrder
 * @Description TODO
 * @Date 2019/7/20 20:22
 * @Created by:lixiaoming1
 */
public class TwoBsalesOrder extends FinenterTestCase {
    private static String ReqJson = FileHelper.getBodyJson("/json/2B_sales_order.json");
    private static String twoBImportOrderUrl=CommonConfig.oms_host_url+"/admin/importOrder/save";

    /**
     * 提交2B订单
     * @return
     */
    public  static Response SubmitTwoBsalesOrder(){
        return   given().contentType("application/json;charset=utf-8").header("authorization",loginStr()).body(ReqJson).
                when().post(twoBImportOrderUrl).
                then().extract().response();

    }

    /**
     * 获取2B订单单号
     * @return
     */
    public  static String get2BECOrder(){
        return  SubmitTwoBsalesOrder().jsonPath().getString("data[0].orderCode");
    }
    @Test
    public static void f(){
        System.out.println( get2BECOrder());
    }
}
