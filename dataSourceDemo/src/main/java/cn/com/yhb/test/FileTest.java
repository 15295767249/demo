package cn.com.yhb.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SCPOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) {
        uploadFile();
    }

    public static void uploadFile() {
        // 获取文件名
//        String fileName = multipartfile.getOriginalFilename();
        Connection conn = new Connection("101.133.235.77", 22);
        System.out.println("连接开始");
        SCPOutputStream os = null;
        FileInputStream fis = null;
        try {
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword("root","Tilltex135789.");
            if(!isAuthenticated){
                System.out.println("连接建立失败");
            }
            SCPClient scpClient = conn.createSCPClient();
            String linuxPath = "" + "test";
            File file = new File("");
//            byte[] za = multipartfile.getBytes();
//            os = scpClient.put(file.getName(),za.length,linuxPath,null);
//            os.write(za, 0, za.length);
//            os.flush();
            System.out.println("upload ok");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(os != null){
                    os.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
