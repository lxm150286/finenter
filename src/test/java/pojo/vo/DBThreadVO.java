package pojo.vo;

/**
 * @ClassName DBThreadVO
 * @Description    数据库字段值的存储与传递
 * @Author lixiaoming1
 * @Date 2019.7.12.17:10
 * @Version 1.0
 */
public class DBThreadVO {
    /**
     * 数据库语句
     */
    private String sql;
    /**
     * 查询结果，map指定的key
     */
    private String key;
    /**
     * 数据库类型
     */
    private String DBstyle;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDBstyle() {
        return DBstyle;
    }

    public void setDBstyle(String DBstyle) {
        this.DBstyle = DBstyle;
    }

    public DBThreadVO(String sql, String key, String DBstyle) {
        this.sql = sql;
        this.key = key;
        this.DBstyle = DBstyle;
    }
    public DBThreadVO(){
    }
    @Override
    public String toString() {
        return "DBThreadVO{" +
                "sql='" + sql + '\'' +
                ", key='" + key + '\'' +
                ", DBstyle='" + DBstyle + '\'' +
                '}';
    }
}
