package util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import helper.FileHelper;

import java.util.HashMap;
import java.util.Map;
/**
 * json工具类，取值，修改json字符串值
 * @author Administrator
 *
 */
public class JsonPathUtil {

    public JsonPathUtil() {
    }

    /**
     * 获取jsonpath指定字段值，作为String返回
     *
     * @param jsonStr  json字符串
     * @param jsonPath 指定json路径
     * @return
     */
    public static String getValueAsString(String jsonStr, String jsonPath) {
        Object obj = getObject(jsonStr, jsonPath);
        return obj != null ? String.valueOf(obj) : null;
    }

    /**
     * 获取jsonpath指定字段值,作为String返回
     *
     * @param jsonStr
     * @param jsonPath
     * @return
     */
    public static String getString(String jsonStr, String jsonPath) {
        Object obj = getObject(jsonStr, jsonPath);
        return obj instanceof String ? String.valueOf(obj) : null;
    }

    /**
     * 获取jsonpath指定字段值,作为int返回
     *
     * @param jsonStr
     * @param jsonPath
     * @return
     */
    public static Integer getInteger(String jsonStr, String jsonPath) {
        Object obj = getObject(jsonStr, jsonPath);
        return obj instanceof Integer ? Integer.valueOf(obj.toString()) : null;
    }

    /**
     * 获取jsonpath指定字段值,作为float返回
     *
     * @param jsonStr
     * @param jsonPath
     * @return
     */
    public static Float getFloat(String jsonStr, String jsonPath) {
        Object obj = getObject(jsonStr, jsonPath);
        return obj instanceof Float ? Float.valueOf(obj.toString()) : null;
    }

    // json 文件修改
    public static String modifyFile(Map<String, Object> map, String strJsonFile) {
        String result = strJsonFile;
        // Map<String, Object> map  String为路径，Object为值
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            result = JsonPathUtil.modifyByJsonPath(result, entry.getKey(), entry.getValue()); // key: jsonPath value :value
        }
        return result;
    }
    /**
     * 底层调用alibaba.fastjson
     *
     * @param jsonStr
     * @param jsonPath
     * @return
     */
    public static Object getObject(String jsonStr, String jsonPath) {
        try {
            return JSONPath.eval(JSONObject.parse(jsonStr), jsonPath);
        } catch (NullPointerException var3) {
            return null;
        }
    }

    /**
     * 修改json字符串
     *
     * @param jsonStr  json字符串主体
     * @param jsonPath
     * @param value    修改字符串值
     * @return
     */
    public static String modifyByJsonPath(String jsonStr, String jsonPath, Object value) {
        DocumentContext ext = JsonPath.parse(jsonStr);
        JsonPath p = JsonPath.compile(jsonPath, new Predicate[0]);
        ext.set(p, value);
        return ext.jsonString();
    }

    /**
     * 通过map的key修改json主体
     *
     * @param jsonStr
     * @param keys
     * @param values
     * @return
     */
    public static String modifyByJsonPathToMap(String jsonStr, String keys, Object values) {
        Map <String, Object> value = (Map) JSON.parseObject(jsonStr, Map.class);
        value.put(keys, values);
        return JSON.toJSONString(value);
    }

    public static void main(String[] args) {
        String jsonCoent=  FileHelper.getBodyJson("/json/invoice_sales_application.json");
        /*System.out.println(jsonCoent);
        String application= getValueAsString(jsonCoent,"application_no");
        System.out.println(application);*/
        Map<String, Object> map = new HashMap<>();
        map.put("$.application_no","LXM05");
        map.put("$.ec_order_no", "EC09JN");

      String  json = modifyFile(map,jsonCoent);
        System.out.println(json);
    }
}