package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public FileUtil() {
    }

    public static String getResourceFilePath(String resourceFilePath) {
        if (!resourceFilePath.startsWith("/")) {
            resourceFilePath = "/" + resourceFilePath;
        }

        URL fileUrl = FileUtil.class.getResource(resourceFilePath);
        if (null == fileUrl) {
            logger.error("Cannot find resource file with path: {}", resourceFilePath);
            return null;
        } else {
            return fileUrl.getPath();
        }
    }

    public static String getJsonFileContent(String jsonFilePath) throws IOException {
        return readFile(jsonFilePath);
    }

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        try {
            InputStream is = new FileInputStream(filePath);
            Throwable var4 = null;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                Throwable var6 = null;

                try {
                    for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                        buffer.append(line);
                        buffer.append("\n");
                    }
                } catch (Throwable var31) {
                    var6 = var31;
                    throw var31;
                } finally {
                    if (reader != null) {
                        if (var6 != null) {
                            try {
                                reader.close();
                            } catch (Throwable var30) {
                                var6.addSuppressed(var30);
                            }
                        } else {
                            reader.close();
                        }
                    }

                }
            } catch (Throwable var33) {
                var4 = var33;
                throw var33;
            } finally {
                if (is != null) {
                    if (var4 != null) {
                        try {
                            is.close();
                        } catch (Throwable var29) {
                            var4.addSuppressed(var29);
                        }
                    } else {
                        is.close();
                    }
                }

            }

        } catch (IOException var35) {
            throw var35;
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        readToBuffer(sb, filePath);
        return sb.toString();
    }

    public static void writeFile(String fileName, String content) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.flush();
        } catch (IOException var12) {
            logger.error("覆盖写入文件 {} 失败", fileName, var12);
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException var11) {
                    logger.error("文件对象关闭失败", var11);
                }
            }

        }

    }

    public static void contentToTxt(String filePath, String content) {
        String str = "";
        String s1 = "";
        File f = new File(filePath);

        try {
            BufferedReader input = new BufferedReader(new FileReader(f));
            Throwable var6 = null;

            try {
                BufferedWriter output = new BufferedWriter(new FileWriter(f));
                Throwable var8 = null;

                try {
                    if (!f.exists()) {
                        FileUtils.touch(f);
                    }

                    while((str = input.readLine()) != null) {
                        s1 = s1 + str + "\n";
                    }

                    input.close();
                    s1 = s1 + content;
                    output.write(s1);
                    output.close();
                } catch (Throwable var33) {
                    var8 = var33;
                    throw var33;
                } finally {
                    if (output != null) {
                        if (var8 != null) {
                            try {
                                output.close();
                            } catch (Throwable var32) {
                                var8.addSuppressed(var32);
                            }
                        } else {
                            output.close();
                        }
                    }

                }
            } catch (Throwable var35) {
                var6 = var35;
                throw var35;
            } finally {
                if (input != null) {
                    if (var6 != null) {
                        try {
                            input.close();
                        } catch (Throwable var31) {
                            var6.addSuppressed(var31);
                        }
                    } else {
                        input.close();
                    }
                }

            }
        } catch (IOException var37) {
            logger.error("文件 {} 写入失败", filePath, var37);
        }

    }

    public static void createFile(String filePath, Boolean cover) {
        try {
            File f = new File(filePath);
            if (f.getParentFile().exists() && cover) {
                FileUtils.forceDelete(f);
                FileUtils.touch(f);
            } else {
                FileUtils.forceMkdirParent(f);
                FileUtils.touch(f);
            }
        } catch (IOException var3) {
            logger.error("创建文件 {} 失败", filePath, var3);
        }

    }
}