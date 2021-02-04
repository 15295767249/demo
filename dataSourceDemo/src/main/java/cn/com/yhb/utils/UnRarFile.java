package cn.com.yhb.utils;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnRarFile {
    /**
     * 根据原始rar路径，解压到指定文件夹下.
     * 说明：RAR 5.0及以下的版本可以解压，RAR 5.0以上的版本不能解压报如下异常，
     * exception in archive constructor maybe file is encrypted or currupt
     * com.github.junrar.exception.RarException: badRarArchive
     *
     * @param rarFile rar文件
     * @param dstDir  解压到的文件夹路径
     */
    public static void unRarFile(File rarFile, String dstDir) {
        File dstDiretory = new File(dstDir);
        if (!dstDiretory.exists()) {
            dstDiretory.mkdirs();
        }
        try {
            Archive archive = new Archive(new FileInputStream(rarFile));
            if (archive != null) {
                archive.getMainHeader().print(); // 打印文件信息.
                FileHeader fh = archive.nextFileHeader();
                while (fh != null) {
                    if (fh.isDirectory()) {
                        File fol = new File(dstDir + File.separator + fh.getFileNameString());
                        fol.mkdirs();
                    } else {
                        File out = new File(dstDir + File.separator + fh.getFileNameString().trim());
                        try {
                            if (!out.exists()) {
                                if (!out.getParentFile().exists()) {
                                    out.getParentFile().mkdirs();
                                }
                                out.createNewFile();
                            }
                            FileOutputStream os = new FileOutputStream(out);
                            archive.extractFile(fh, os);
                            os.close();
                        } catch (Exception ex) {
                            throw ex;
                        }
                    }
                    fh = archive.nextFileHeader();
                }
                archive.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
