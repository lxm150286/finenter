package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.DBConnUtil.getConnection;

public class JDBCUtil {
    /**
     * 增删改
     */
    public static void sqlExecute(String sql,Object... params) throws SQLException {

        Connection conn =null;
        PreparedStatement pstmt=null;
        try {
            //连接数据库
            conn=getConnection();
            //预编译
            pstmt=conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
               pstmt.setObject(i+1,params[i]);
               }
               //执行sql
            boolean result =pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 查询
     */
public static List<Map<String,Object>>sqlQuery(String sql,Object... params){
  List<Map<String,Object>> allRecoedList=  new ArrayList<Map<String,Object>>();
    Connection conn= getConnection();
    PreparedStatement pstmt=null;
    ResultSet resultset=null;

    try {
        //陈述对象
      pstmt=conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
           pstmt.setObject(i+1,params[i]);//使用给定对象设置指定参数的值
           }
        //执行sql,得到结果集
         resultset=pstmt.executeQuery();
        //获得结果集元数据
        ResultSetMetaData metaData=resultset.getMetaData();
        //获取列数
       int count= metaData.getColumnCount();
       //循环结果集的每一条记录(每一行作为一个结果集的一行)
       while (resultset.next()){
           //结果集的每一行保存在map中
           Map<String,Object> oneRecord=new HashMap<String,Object>();
           for (int i = 0; i <count; i++) {
           String columnName=  metaData.getColumnName(i+1);
           Object columnValue=resultset.getObject(i+1);
           oneRecord.put(columnName,columnValue);
           }
           allRecoedList.add(oneRecord);
       }
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            resultset.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    return  allRecoedList;
}
}
