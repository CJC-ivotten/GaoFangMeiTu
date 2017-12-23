package com.jason.gaofangmeitu.omshiroi.flyu;

import android.os.Environment;

import java.io.File;

/**
 * Created by 陈家程 on 2017/12/23.
 */

public class DemoConstants {
    public static final String SDCARD = getSDPath();
    public static final String APPDIR = SDCARD + "/Omoshiroi/TestFaceU";
    public static final String IMAGE_PATH="image_path";
    public static String getSDPath(){
        File sdDir = null;
        // 判断 SD 卡是否存在
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();
        }
        if (sdDir != null){
            return sdDir.toString();
        }else {
            return "";
        }
    }

}
