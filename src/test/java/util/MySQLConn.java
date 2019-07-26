package util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConn {
    private static Logger logger = LoggerFactory.getLogger(MySQLConn.class);
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn = null;

    public static Connection getConnection(String dbIp, int port, String dbName, String userName, String password) {
        try {

            String url = "jdbc:mysql://" + dbIp + ":" + String.valueOf(port) + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            logger.error("数据库连接异常！" + "数据库ip:" + dbIp + "\t 端口:" + port + "\t 数据库名称:" + dbName + "\t 用户名:" + userName
                    + "\t 密码:" + password);
            throw new RuntimeException(e.getMessage());
        }

        return conn;
    }
    public static Connection getConnection(String DBurl, String userName, String password) {
        try {

            String url = DBurl;
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            logger.error("数据库连接异常！" + "数据库" + DBurl  + userName
                    + "\t 密码:" + password);
            throw new RuntimeException(e.getMessage());
        }

        return conn;
    }
    public static void main(String[] args) {
        getConnection("jdbc:mysql://192.168.240.207:8066/ec_order","OrderBianGeng","Bg!34er");
    }
}
