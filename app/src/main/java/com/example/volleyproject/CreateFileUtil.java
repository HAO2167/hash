package com.example.volleyproject;

import org.json.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreateFileUtil {


    public CreateFileUtil(JSONArray jArray) {
        /**
         * 生成.json格式檔案
         */


        // 拼接檔案完整路徑
        String fullPath = "/AndroidStudioProjects/volleymain/asset/test.json";
        // 生成json格式檔案
        try {
            // 保證建立一個新檔案
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) {
                // 如果父目錄不存在，建立父目錄
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,刪除舊檔案
                file.delete();
            }
            file.createNewFile();
            // 將格式化後的字串寫入檔案
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(String.valueOf(jArray));
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


