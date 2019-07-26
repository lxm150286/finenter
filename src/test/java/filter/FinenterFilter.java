package filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

/**
 * Created by lixiaoming1 on 2018/12/1
 * @author lixiaoming1
 *
 */

public class FinenterFilter implements Filter {

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec, FilterContext ctx) {
        String url = requestSpec.getURI();
        String method = requestSpec.getMethod();
        if (url!=null&&url.contains("https")){
            /**
             * 在给定的SSLContext协议中使用宽松的HTTP验证。这意味着无论SSL证书是否无效，您都将信任所有主机
             */
            requestSpec.relaxedHTTPSValidation();
        }
        Response resp = ctx.next(requestSpec, responseSpec);
        return  resp;
    }
}
