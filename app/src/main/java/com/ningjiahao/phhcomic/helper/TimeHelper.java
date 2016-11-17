package com.ningjiahao.phhcomic.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP on 2016/11/17.
 */

public class TimeHelper {

    //将147......转换为时间的格式

    public static String formatData(String dataFormat, long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        timeStamp = timeStamp * 1000;
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }
}
