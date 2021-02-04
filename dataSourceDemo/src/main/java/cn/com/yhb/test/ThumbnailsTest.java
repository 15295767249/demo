package cn.com.yhb.test;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThumbnailsTest {

//    public static void main(String[] args) throws IOException {
//        String filePath = "D:\\压缩\\qingjingfang_nuan\\YZ-20015_chuanglifaxian.jpg";
//        File file = new File(filePath);
//        if (file.exists() && file.isFile()) {
//            System.out.println(file.length());
//        }
//        Thumbnails.of(filePath)
//                .scale(1f)
//                .outputQuality(0.2f)
//                .toFile("D:\\压缩\\qingjingfang_nuan1\\YZ-20015_chuanglifaxian.jpg");
//
//    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\压缩\\qingjingfang_nuan3";
        thumbnails(getFiles(path));
    }

    public static void thumbnails(List<String> list) throws IOException {
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
                        .toFile("D:\\压缩\\qingjingfang_nuan3\\" + fileNameNow);
            } else {
                FileInputStream fileInputStream=new FileInputStream(file);
                File dir = new File("D:\\压缩\\qingjingfang_nuan3");
                File file1 = new File(dir, fileNameNow);
                FileOutputStream out = new FileOutputStream(file1);
                Streams.copy(fileInputStream, out, true);
            }
        }
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
                if (tempList[i].isFile()) {
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
}
