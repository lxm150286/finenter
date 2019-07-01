package util;
import config.CommonConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接
 */
public class DBConnUtil {
    private static String url= CommonConfig.finenter_jdbc_url;
    private static String user=CommonConfig.finenter_jdbc_user;
    private static String password=CommonConfig.finenter_jdbc_password;
    static{
        Properties properties= new Properties();
        try {
            //解析资源文件
            properties.load(DBConnUtil.class.getResourceAsStream("/properties/api-test-config-test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //注册一个驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      }
/**
 * 获取连接
 */
public static Connection getConnection(){
    Connection conn=null;
    try {
        conn=DriverManager.getConnection(url,user,password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
   return conn;
}

    public static void main(String[] args) {
        getConnection();
        System.out.println("数据库链接地址:"+url+"\t账号:"+user+"\t密码:"+password);
    }
}
