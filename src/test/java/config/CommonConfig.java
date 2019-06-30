package config;


import util.ConfigUtil;

/**
 * @ClassName   读取环境的配置信息
 * @Description TODO
 * @Author lixiaoming1
 * @Date 2019.6.30.14:54
 * @Version 1.0
 */
public class CommonConfig {
    // 此项目配置文件的路径
    public static String propertiesFolder = "/properties/";

   //财务中台数据库链接信息
   public static String finenter_jdbc_url;
    public static String finenter_jdbc_user;
    public static String finenter_jdbc_password;


    //初始化配置值
    static {
        String defaultEnvironment ="test"; // 环境配置sit 集成环境
        ConfigUtil.loadProperties(ConfigUtil.getPropertyFile(propertiesFolder, defaultEnvironment), CommonConfig.class);
    }




}
