package contract;
import config.CommonConfig;
import filter.FinenterTestCase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
/**
 * @Classname login
 * @Description TODO
 * @Date 2019/7/14 10:54
 * @Created by:lixiaoming1
 */
public class login extends FinenterTestCase {
    private  static String oms_host= CommonConfig.oms_host_url;
    public  static Response login(){
        String bodyStr="{\"userName\":\"admin\",\"password\":\"admin\"}";
        return   given().contentType("application/json;charset=utf-8").body(bodyStr).
                when().post(oms_host+"/admin/auth/token").
                then().extract().response();

    }
    public  static Response login(String userName,String password){
        String bodyStr="{\"userName\":\""+userName+"\",\""+password+"\":\"admin\"}";
        return   given().contentType("application/json;charset=utf-8").body(bodyStr).
                when().post(oms_host+"/admin/auth/token").
                then().extract().response();

    }
    public  static String loginStr(){
        return  login().jsonPath().get("data");
    }
    public  static String loginStr(String userName,String password){
        return  login(userName,password).jsonPath().get("data");
    }
    @Test
    public static void f(){
        System.out.println((String)login().jsonPath().get("data"));
    }
}
