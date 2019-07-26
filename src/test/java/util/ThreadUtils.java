package util;
import org.testng.annotations.Test;
import pojo.vo.DBThreadVO;
import java.util.Map;
import java.util.concurrent.Callable;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static util.SqlExecutionEncapsulationUtil.getConnection;
import static util.SqlExecutionEncapsulationUtil.queryData;


/**
 * 智能等待工具类
 */
public class ThreadUtils {
    private static DBThreadVO dbVO;

    static {
        dbVO = new DBThreadVO();
    }

    /**
     * 线程休眠
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
           System.out.println("等待超时");

        }
    }

    public static void awaiUtil(String sql, String key, String DBstyle,String expectResult) {
        awaiUtil(sql,key,DBstyle,expectResult,6);
    }

    public static void awaiUtil(String sql, String key, String DBstyle,String expectResult,long seconds) {
        dbVO.setSql(sql);
        dbVO.setKey(key);
        dbVO.setDBstyle(DBstyle);
        // 检查数据记录状态，智能等待MQ消费完成。此处指定超时时间, 如果在这时间段内,条件依然不满足,将抛出ConditionTimeoutException
        await().atMost(seconds, SECONDS).until(waitForDBResult(dbVO, expectResult));
    }
   /*
     * 检查数据库是否有生成对应订单的记录，以供智能等待使用
     * @param expectResult
     * @return Callable<Boolean>，返回一个判断结果true或者false
     * */


    private static Callable<Boolean> waitForDBResult(DBThreadVO dbVO, String expectResult) {
        getConnection(dbVO.getDBstyle());
        return () -> {
            Map<String, Object> getOrderInfoMap = queryData(dbVO.getSql());
            if(getOrderInfoMap==null || getOrderInfoMap.get(dbVO.getKey()) == null){
                return false;
            }
            String actualResult = getOrderInfoMap.get(dbVO.getKey()).toString();
               if (expectResult.equals(actualResult)) {
                   System.out.println("实际结果和预期结果一致，预期结果expectResult = " + expectResult);
                   return true;
               } else {
                   System.out.println("实际结果和预期结果不一致，预期结果unexpectResult = " + expectResult+"实际结果actualResult:"+actualResult);
                   return false;
               }

        };

    }

    @Test
    public void f1() {
        try {
            awaiUtil("select * from ec_oms_order_status where order_code='10190710223756203304633';", "order_status", "oms", "5",500);
        } catch (Exception e) {
            System.out.println("----nihao");
        }
    }


}
