package testCase;

import com.alibaba.fastjson.JSON;
import enumPackage.getStatus;
import helper.FileHelper;
import javaBean.InvoiceSalesApplication;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static helper.DataProvider.getInvoiceApplicationNumber;
import static util.JDBCUtil.sqlExecute;
import static util.JDBCUtil.sqlQuery;
import static util.JsonPathUtil.modifyFile;

public class JDBCTest {
    static String ReqJson = FileHelper.getBodyJson("/json/invoice_sales_application.json");
    static  InvoiceSalesApplication SalesApplication;
    public static void main(String[] args) throws SQLException {
        System.out.println(ReqJson);
        Map<String, Object> map = new HashMap<>();
        map.put("$.application_no",getInvoiceApplicationNumber());
        map.put("$.ec_order_no", "EC09JN");
        map.put("$.status", getStatus.Processed.getValue());

        String  modjson = modifyFile(map,ReqJson);
        System.out.println(modjson);
        SalesApplication= JSON.parseObject(modjson,InvoiceSalesApplication.class);
        System.out.println(SalesApplication.getShop_code());
        insert();
        }
    public static void insert() throws SQLException {
       // String sql="insert into member (RegName,Pwd,MobilePhone,Type) values (?,?,?,?);";
       //String sql="insert into invoice_sales_application.json (status,application_no,invoice_type,invoice_category,ec_order_no) values(?,?,?,?,?);";
      // String sql="insert into invoice_sales_application (status,application_no,invoice_type,invoice_category,ec_order_no) values('1','ss21','0','23',\"EC09089\")\n";

     String sql="insert into invoice_sales_application (status,application_no,invoice_type,invoice_category,ec_order_no) values("+SalesApplication.getStatus()+",'"+SalesApplication.getApplication_no()+"',"+SalesApplication.getInvoice_type()+","+SalesApplication.getInvoice_category()+",'"+SalesApplication.getEc_order_no()+"'"+");";
       sqlExecute(sql);
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
