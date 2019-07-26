package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @Classname BaseDao
 * @Description TODO
 * @Date 2019/7/21 22:45
 * @Created by:lixiaoming1
 */
public class BaseDao {
    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);
    protected static PreparedStatement pstmt = null;

    public BaseDao() {
    }

    public static void closeAll(Statement stmt, ResultSet rs) {
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(stmt);
    }

    public static int executeSelect(Connection conn, String sql, Object... params) {
        boolean var3 = false;

        int count;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for(int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            count = pstmt.executeUpdate();
        } catch (SQLException var8) {
            logger.error("查询出错", var8);
            throw new SqlExecuteException(var8.getMessage());
        } finally {
            closeAll(pstmt, (ResultSet)null);
        }

        return count;
    }

    public static int executeInsert(Connection conn, String sql, Object... params) {
        boolean var3 = false;

        int count;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for(int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            count = pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException var8) {
            logger.error("插入数据库失败", var8);
            throw new SqlExecuteException(var8.getMessage());
        } finally {
            closeAll(pstmt, (ResultSet)null);
        }

        return count;
    }

    public static int executeUpdate(Connection conn, String sql, Object... params) {
        boolean var3 = false;

        int count;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for(int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            count = pstmt.executeUpdate();
        } catch (SQLException var8) {
            logger.error("修改数据库失败", var8);
            throw new SqlExecuteException(var8.getMessage());
        } finally {
            closeAll(pstmt, (ResultSet)null);
        }

        return count;
    }

    public static void execute(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException var3) {
            logger.error("数据库语句 {} 执行失败", sql, var3);
            throw new SqlExecuteException(var3.getMessage());
        }
    }

    public static Map<String, Object> singlSearchByParams(Connection conn, String sql, Object... params) {
        new HashMap();
        ResultSet rs = null;

        Map map;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for(int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            List<Map<String, Object>> result = getResultMap(rs);
            if (result == null || result.size() <= 0) {
                Object var6 = null;
                return (Map)var6;
            }

            map = (Map)result.get(0);
        } catch (SQLException var10) {
            logger.error("通过数据库语句 {} 查询单条记录失败", pstmt.toString(), var10);
            throw new SqlExecuteException(var10.getMessage());
        } finally {
            closeAll(pstmt, rs);
        }

        return map;
    }

    public static List<Map<String, Object>> searchListByParams(Connection conn, String sql, Object... params) {
        new ArrayList();
        ResultSet rs = null;

        List list;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for(int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            list = getResultMap(rs);
        } catch (SQLException var9) {
            logger.error("通过数据库语句 {} 查询单条记录失败", sql, var9);
            throw new SqlExecuteException(var9.getMessage());
        } finally {
            closeAll(pstmt, rs);
        }

        return list;
    }

    private static List<Map<String, Object>> getResultMap(ResultSet rs) throws SQLException {
        List<Map<String, Object>> list = new ArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();

        while(rs.next()) {
            Map<String, Object> map = new HashMap();

            for(int i = 1; i <= count; ++i) {
                String key = rsmd.getColumnLabel(i);
                Object value = rs.getObject(i);
                map.put(key, value);
            }

            list.add(map);
        }

        return list;
    }

    public static List<Map<String, Object>> searchList(Connection conn, String sql) {
        new ArrayList();
        ResultSet rs = null;

        List list;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            list = getResultMap(rs);
        } catch (SQLException var8) {
            logger.error("使用 {} 进行多条记录查询失败", sql, var8.getMessage());
            throw new SqlExecuteException(var8.getMessage());
        } finally {
            closeAll(pstmt, rs);
        }

        return list;
    }

    public static String searchStringForRowCol(Connection conn, String sql, int row, int col) {
        ResultSet rs = null;

        String var5;
        try {
            if (row <= 0) {
                row = 1;
            }

            if (col <= 0) {
                col = 1;
            }

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            do {
                if (!rs.next()) {
                    return null;
                }

                --row;
            } while(row != 0);

            var5 = rs.getString(col);
        } catch (SQLException var9) {
            logger.error("查询失败。sql {}, 行 {}，列 {}", new Object[]{sql, row, col, var9});
            throw new SqlExecuteException(var9.getMessage());
        } finally {
            closeAll(pstmt, rs);
        }

        return var5;
    }
}