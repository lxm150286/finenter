package util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static util.JDBCUtil.sqlExecute;
import static util.JDBCUtil.sqlQuery;

public class SqlExecute {
    public static void insert() throws SQLException {
        // String sql="insert into member (RegName,Pwd,MobilePhone,Type) values (?,?,?,?);";
        //String sql="insert into invoice_sales_application.json (status,application_no,invoice_type,invoice_category,ec_order_no) values(?,?,?,?,?);";
        // String sql="insert into invoice_sales_application (status,application_no,invoice_type,invoice_category,ec_order_no) values('1','ss21','0','23',\"EC09089\")\n";


    }
    public static void delete() throws SQLException {
        String sql="delete  from member where id=80;";
        sqlExecute(sql);
    }
    public static void update() throws SQLException {
        String sql ="update member set RegName='lisi' where id='81';";
        sqlExecute(sql);
    }
    public static void querry(){
        String sql="select * from member where id=83;";
        List<Map<String, Object>> resultList = sqlQuery(sql);
        for (Map <String, Object> map : resultList) {
            Set<String> key=map.keySet();
            for (String s : key) {
                System.out.print(map.get(s)+"\t");
            }
        }
    }
}
