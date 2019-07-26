package filter;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by lixiaoming1 on 2018/12/1
 * @author lixiaoming1
 *
 */
public class FinenterTestCase {
    public Logger logger = Logger.getLogger(this.getClass());
    //由于RestAssured在没有给baseURI赋值之前配置requestSpecification会导致请求出错，所以这里不用beforeClass
    @BeforeMethod
    public void baseTestCaseBeforeMethod() {
        //可以通过requestSpecification 全局配置请求参数或者请求头等
        //默认为每个请求带上requestKey参数
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addFilter(new RequestLoggingFilter()).  //添加请求过滤器 打印出请求日志
                addFilter(new ResponseLoggingFilter()).   //添加响应过滤器 打印出响应日志
               // addFilter(new ExtentXLogFilter()).   //在报告中添加请求和响应数据
                addFilter(new FinenterFilter()).
                build();

    }

    @AfterMethod
    public void baseTestCaseAfterMethod() {
        //为了让不继承该类的类不受配置影响,需重置
        RestAssured.requestSpecification = null;
    }


}
