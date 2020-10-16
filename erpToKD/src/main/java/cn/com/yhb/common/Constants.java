package cn.com.yhb.common;

/**
 * 静态常量
 * @author yhb
 *
 */

public class Constants {

	public static final String EMPTY = "";
	
    public static final String UMP_WS_HEADER =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ejb=\"http://ejb.com/\">\n"
                    + "   <soapenv:Header/>\n"
                    + "   <soapenv:Body>\n";

    public static final String UMP_WS_END = "</soapenv:Body>\n" + "</soapenv:Envelope>";

    public static final String UMP_WS_GET_USER_INFO =
            "<ejb:getUserInfosV5><empIds>{0}</empIds></ejb:getUserInfosV5>\n";
}
