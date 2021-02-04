package cn.com.yhb.utils;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.lingala.zip4j.core.ZipFile;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 解压rar/zip工具类
 * @Date: 2019/1/22
 * @Auther:
 */
@Slf4j
public class UnPackeUtil {

    /**
     * zip文件解压
     * @param destPath 解压文件路径
     * @param zipFile  压缩文件
     * @param password 解压密码(如果有)
     */

    public static boolean unPackZip(File zipFile, String password, String destPath) {
        boolean bool = false;
        try {
            ZipFile zip = new ZipFile(zipFile);
            /*zip4j默认用GBK编码去解压,这里设置编码为GBK的*/
            zip.setFileNameCharset("GBK");
            log.info("begin unpack zip file....");
            zip.extractAll(destPath);
            // 如果解压需要密码
            if (zip.isEncrypted()) {
                zip.setPassword(password);
            }
            bool = true;
        } catch (Exception e) {
            log.error("unPack zip file to " + destPath + " fail ....", e.getMessage(), e);
        }
        return bool;
    }

    /**
     * @Author：yhb
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        if (tempList != null) {
            for (int i = 0; i < tempList.length; i++) {
                // 获取文件后缀
                String prefix = tempList[i].toString().substring(tempList[i].toString().lastIndexOf("."));
                if (tempList[i].isFile() && (prefix.equals(".jpg") || prefix.equals(".jpeg") || prefix.equals(".png"))) {
                    files.add(tempList[i].toString());
                    //文件名，不包含路径
                    //String fileName = tempList[i].getName();
                }
                if (tempList[i].isDirectory()) {
                    //这里就不递归了，
                }
            }
        }
        return files;
    }

    /**
     * 压缩文件夹中的图片
     * @param list
     * @param saveDir
     * @throws IOException
     */
    public static void thumbnails(List<String> list, String saveDir) throws IOException {
        for (String filePath : list) {
            String fileNameNow = filePath.substring(filePath.lastIndexOf("\\")+1);
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                System.out.println(file.length());
            }
            String prefix = fileNameNow.substring(fileNameNow.lastIndexOf("."));
            if (prefix.equals(".jpg") || prefix.equals(".jpeg") || prefix.equals(".png")) {
                Thumbnails.of(filePath)
                        .scale(1f)
                        .outputQuality(0.2f)
                        .toFile(saveDir + fileNameNow);
            } else {
                FileInputStream fileInputStream=new FileInputStream(file);
                File dir = new File(saveDir);
                File file1 = new File(dir, fileNameNow);
                FileOutputStream out = new FileOutputStream(file1);
                Streams.copy(fileInputStream, out, true);
            }
        }
    }

}
