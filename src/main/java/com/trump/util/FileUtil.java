package com.trump.util;

import java.io.File;

/**
 * Created by Administrator on 2017/4/5.
 */
public class FileUtil {


    public static void createIfNotExist(File file) {
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {

            }
        }
    }

}
