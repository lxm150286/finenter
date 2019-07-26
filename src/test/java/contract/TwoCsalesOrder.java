package contract;

import config.CommonConfig;
import filter.FinenterTestCase;
import helper.FileHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static contract.login.loginStr;
import static io.restassured.RestAssured.given;
import static util.JsonPathUtil.modifyFile;

/**
 * @Classname TwoBsalesOrder
 * @Description TODO
 * @Date 2019/7/20 20:22
 * @Created by:lixiaoming1
 */
public class TwoCsalesOrder extends FinenterTestCase {
    private static String ReqJson = FileHelper.getBodyJson("/json/2C_sales_order.json");
    private static String twoCImportOrderUrl=CommonConfig.oms_host_url+"/admin/importOrder/save";

    /**
     * 提交2C订单
     * @return
     */
    public  static Response SubmitTwoCsalesOrder(){
        Map<String,Object> map=new HashMap<>();
        map.put("shopOrderId","1009343");
        String modjson = modifyFile(map, ReqJson);
        return   given().contentType("application/json;charset=utf-8").header("authorization",loginStr()).body(modjson).
                when().post(twoCImportOrderUrl).
                then().extract().response();
    }

    /**
     * 获取2B订单单号
     * @return
     */
    public  static String get2CECOrder(){
        return  SubmitTwoCsalesOrder().jsonPath().getString("data[0].orderCode");
    }
    @Test
    public static void f(){
        System.out.println( get2CECOrder());
    }
}
