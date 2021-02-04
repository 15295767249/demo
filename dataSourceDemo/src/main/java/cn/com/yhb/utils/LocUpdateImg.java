package cn.com.yhb.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class LocUpdateImg {

    public static String ImageuploadLOC(MultipartFile multipartFile) {
        String imgUrl = "";
        String filePath = File.separator + "var" + File.separator + "ftp" + File.separator + "pub" + File.separator + "fabric" + File.separator + "2020-12-7" + File.separator;
        try {
            String fileName = multipartFile.getOriginalFilename();
            // 上传文件流。
            System.out.println("待上传的图片："  + filePath + fileName);
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            File f = getFile(multipartFile);
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            bos.flush();
            bos.close();
            imgUrl = filePath + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("上传失败");
        }
        return imgUrl;
    }

    /**
     * 将MultipartFile转成File
     * @param multipartFile
     * @return
     */
    public static File getFile(MultipartFile multipartFile) {
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码
        try {
            File file = File.createTempFile(fileName, prefix);
            multipartFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
