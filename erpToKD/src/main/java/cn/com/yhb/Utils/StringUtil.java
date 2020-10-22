package cn.com.yhb.Utils;

import org.springframework.util.StringUtils;

public class StringUtil {

    public static String strToNum(String string) {
        if (StringUtils.isEmpty(string) || string == "null") {
            string = "0";
        }
        return string;
    }

    public static String getStr(String string) {
        if (StringUtils.isEmpty(string) || string == "null") {
            string = "";
        }
        return string;
    }
}
