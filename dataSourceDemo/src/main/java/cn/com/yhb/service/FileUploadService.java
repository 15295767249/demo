package cn.com.yhb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileUploadService {

    /**
     * fbx模型压缩文件上传、解压
     * @param zipFile
     * @return
     */
    String uploadFBX(MultipartFile zipFile)  throws IOException;

    /**
     * 文件上传
     * @param zipFile
     * @return
     */
    String uploadFile(MultipartFile zipFile);
}
