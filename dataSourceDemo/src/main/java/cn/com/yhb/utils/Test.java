package cn.com.yhb.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\压缩\\qingjingfang_nuan\\YZ-20015_chuanglifaxian.jpg";
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            System.out.println(file.length());
        }
        Thumbnails.of(filePath)
                .scale(1f)
                .outputQuality(0.2f)
                .toFile("D:\\压缩\\qingjingfang_nuan1\\YZ-20015_chuanglifaxian.jpg");

    }
}
