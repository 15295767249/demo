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

    public static Integer getStrNum(String string1, String string2) {
        Integer string1Length = string1.length();
        String str = string1.replaceAll(string2, "");
        Integer string2Length = str.length();
        return string1Length - string2Length;
    }

    public static void main(String[] args) {
        String string1 = "ssss.ffff.ggg";
        String string2 = "\\.";
        System.out.println(getStrNum(string1, string2));
    }
}
