package helper;



import util.FileUtil;

import java.io.IOException;


public class FileHelper extends FileUtil {

    /**
     *
     * @param jsonPath
     * @return
     */
    public static String getBodyJson(String jsonPath){
        String jsonFile = FileHelper.getResourceFilePath(jsonPath);
        String json = "";
        try {
            json = FileHelper.getJsonFileContent(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
