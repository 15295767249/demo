package cn.com.yhb.service.impl;

import cn.com.yhb.service.FileUploadService;
import cn.com.yhb.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * @Description:
 * @Date: 2019/1/22
 * @Auther:
 */

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file.rar.unRar}")
    private String FILE_RAR_UNRAR;

    @Value("${file.windowsUrl}")
    private String FILE_WINDOWS_URL;

    @Value("${file.LinuxUrl}")
    private String FILE_LINUX_URL;

    @Value("${file.path.windows}")
    private String FILE_PATH_WINDOWS;

    @Value("${file.path.linux}")
    private String FILE_PATH_LINUX;

    @Override
    public String uploadFBX(MultipartFile zipFile)  throws IOException {
        String imgUrl = "";
        if (null == zipFile) {
            return "请上传压缩文件!";
        }
        boolean isZipPack = true;
        String fileName = zipFile.getOriginalFilename();
        String fileContentType = zipFile.getContentType();
        //将压缩包保存在指定路径
        String filePath = "";
        if (OSinfo.isWindows()) {
            //Windows
            filePath = FILE_PATH_WINDOWS + "fabric" + File.separator + DateUtil.dateFormat.format(new Date()) + File.separator + "model" + File.separator;
        } else {
            //Linux
            filePath = FILE_PATH_LINUX + "fabric" + File.separator + DateUtil.dateFormat.format(new Date()) + File.separator + "model" + File.separator;
        }
        String packFilePath = filePath;
        if (FileTypeEnum.FILE_TYPE_ZIP.type.equals(fileContentType)) {
            //zip解压缩处理
            packFilePath += fileName;
        } else if (FileTypeEnum.FILE_TYPE_RAR.type.equals(fileContentType)) {
            //rar解压缩处理
            packFilePath += fileName;
            isZipPack = false;
        } else {
            return "上传的压缩包格式不正确,仅支持rar和zip压缩文件!";
        }
        File f = new File(packFilePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        File file = new File(packFilePath);
        try {
            zipFile.transferTo(file);
        } catch (IOException e) {
            log.error("zip file save to " + filePath + " error", e.getMessage(), e);
            return "保存压缩文件到:" + filePath + " 失败!";
        }
        boolean bool = false;
        if (isZipPack) {
            //zip压缩包
            bool = UnPackeUtil.unPackZip(file, "", filePath);
        } else {
            //rar压缩包
            bool = RealExtract.realExtract(file, filePath, FILE_RAR_UNRAR);
        }
        fileName = fileName.substring(0, fileName.indexOf("."));
        if (bool) {
            //压缩图片
            String baseUrl = filePath + File.separator + fileName + File.separator ;
            imgUrl =  filePath.substring(filePath.indexOf( File.separator + "file")) + fileName + File.separator + fileName + ".fbx";
            if (OSinfo.isWindows()) {
                //Windows
                imgUrl =  FILE_WINDOWS_URL + imgUrl;
            } else {
                //Linux
                imgUrl =  FILE_LINUX_URL + imgUrl;
            }
            UnPackeUtil.thumbnails(UnPackeUtil.getFiles(baseUrl), baseUrl);
        }
        return imgUrl;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String imgUrl = "";
        if (null == multipartFile) {
            return "请上传文件!";
        }
        String fileName = multipartFile.getOriginalFilename();
        //将文件保存在指定路径
        String filePath = "";
        if (OSinfo.isWindows()) {
            //Windows
            filePath = FILE_PATH_WINDOWS + "fabric" + File.separator + DateUtil.dateFormat.format(new Date()) + File.separator;
        } else {
            //Linux
            filePath = FILE_PATH_LINUX + "fabric" + File.separator + DateUtil.dateFormat.format(new Date()) + File.separator;
        }
        String packFilePath = filePath + fileName;
        File f = new File(packFilePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        File file = new File(packFilePath);
        try {
            multipartFile.transferTo(file);
            imgUrl =  filePath.substring(filePath.indexOf( File.separator + "file")) + fileName;
            if (OSinfo.isWindows()) {
                //Windows
                imgUrl =  FILE_WINDOWS_URL + imgUrl;
            } else {
                //Linux
                imgUrl =  FILE_LINUX_URL + imgUrl;
            }
        } catch (IOException e) {
            log.error("file save to " + filePath + " error", e.getMessage(), e);
            return "保存文件到:" + filePath + " 失败!";
        }
        return imgUrl;
    }

}
