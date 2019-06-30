package util;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConfigUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    public ConfigUtil() {
    }

    public static String getPropertyFile(String propertiesFolder, String defaultEnvironment) {
        if (!propertiesFolder.endsWith("/")) {
            propertiesFolder = propertiesFolder + "/";
        }

        String env;
        if (!StringUtils.isEmpty(System.getProperty("env"))) {
            env = System.getProperty("env").toLowerCase();
        } else {
            env = defaultEnvironment;
        }

        return propertiesFolder + "api-test-config-{}.properties".replace("{}", env);
    }

    public static void loadProperties(String propertiesPath, Class configClass) {
        loadProperties(propertiesPath, configClass, false);
    }

    public static void loadProperties(String propertiesPath, Class configClass, Boolean isDebug) {
        Properties prop = new Properties();
        InputStream in = ConfigUtil.class.getResourceAsStream(propertiesPath);
        String className;
        if (in == null) {
            className = "File " + FileUtil.getResourceFilePath(propertiesPath) + " not exist!";
            logger.error(className);
            throw new RuntimeException(className);
        } else {
            try {
                prop.load(in);
            } catch (IOException var16) {
                logger.error("文件 {} 读取错误", propertiesPath, var16);
                throw new RuntimeException(var16.getMessage());
            }

            className = configClass.getName();
            Field[] fields = configClass.getDeclaredFields();
            Field[] var7 = fields;
            int var8 = fields.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Field field = var7[var9];

                try {
                    String propertyName = field.toString().substring(field.toString().lastIndexOf(className), field.toString().length()).replace(className + ".", "");
                    field.setAccessible(true);
                    String propertyValue = prop.getProperty(propertyName);
                    if (System.getProperty(propertyName) != null) {
                        propertyValue = System.getProperty(propertyName);
                    }

                    if (propertyValue != null) {
                        try {
                            field.set((Object)null, ConvertUtils.convert(propertyValue, field.getType()));
                            if (isDebug) {
                                logger.info(FrameworkMarker.frameworkMarker, "Loaded property " + propertyName + " with value " + ConvertUtils.convert(propertyValue, field.getType()));
                            }
                        } catch (IllegalAccessException | NullPointerException var14) {
                            logger.warn(FrameworkMarker.frameworkMarker, "Cannot set property " + propertyName + " with value " + ConvertUtils.convert(propertyValue, field.getType()) + " because it is not static");
                        }
                    } else if (!"propertiesPath".equals(propertyName)) {
                        logger.warn(FrameworkMarker.frameworkMarker, "Did not find property " + propertyName + " in " + propertiesPath);
                    }
                } catch (NullPointerException var15) {
                    logger.error(FrameworkMarker.frameworkMarker, "Error occurs while setting properties: " + var15.getMessage());
                }
            }

        }
    }
}
