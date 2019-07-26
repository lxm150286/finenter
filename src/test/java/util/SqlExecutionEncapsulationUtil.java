package util;

import config.CommonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SqlExecutionEncapsulationUtil
 * @Description TODO
 * @Author lixiaoming1
 * @Date 2019.7.19
 * @Version 1.0
 */
public class SqlExecutionEncapsulationUtil {
    private static Connection connection;
    private static Logger logger = LoggerFactory.getLogger(SqlExecutionEncapsulationUtil.class);

    public static void getConnection(String DBType) {

        if (DBType == "finenter") {
            connection = MySQLConn.getConnection(CommonConfig.finenter_jdbc_url, CommonConfig.finenter_jdbc_user, CommonConfig.finenter_jdbc_password);
        } else if (DBType == "oms") {
            connection = MySQLConn.getConnection(CommonConfig.oms_jdbc_url, CommonConfig.omsr_jdbc_user, CommonConfig.oms_jdbc_password);
        } else {
            logger.error("没有定义的数据库类型:" + DBType);
        }
    }

    public static Map<String, Object> queryData(String sql) {

        try {
            return BaseDao.singlSearchByParams(connection, sql);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Map<String, Object>> queryListData(String sql) {

        return BaseDao.searchListByParams(connection, sql, null);
    }

    public static void updateData(String sql) {

        BaseDao.execute(connection, sql);

    }
    @Test
    public void f1(){
        getConnection("eam");
        queryData("select ORDER_STATUS from TB_AT_ORDER_XJD WHERE ORDER_ID='WHFQ20181219053041485';");
    }
}
