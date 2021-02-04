package cn.com.yhb.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URISyntaxException;

public class RealExtract {
    /**
     * 采用命令行方式解压文件
     * @param zipFile 压缩文件
     * @param destDir 解压结果路径
     * @param unRar 解压rar文件的unrar路径
     * @return
     */
    public static boolean realExtract(File zipFile, String destDir, String unRar) {
        // 解决路径中存在/..格式的路径问题
        destDir = new File(destDir).getAbsoluteFile().getAbsolutePath();
        while(destDir.contains("..")) {
            String[] sepList = destDir.split("\\\\");
            destDir = "";
            for (int i = 0; i < sepList.length; i++) {
                if(!"..".equals(sepList[i]) && i < sepList.length -1 && "..".equals(sepList[i+1])) {
                    i++;
                } else {
                    destDir += sepList[i] + File.separator;
                }
            }
        }

        // 获取WinRAR.exe的路径，放在java web工程下的WebRoot路径下
        String classPath = "";
        try {
            classPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
            System.out.println(classPath);
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        // 兼容main方法执行和javaweb下执行
        String winrarPath = "";
        if (StringUtils.isEmpty(classPath)) {
            winrarPath = unRar;
        } else {
            winrarPath = (classPath.indexOf("classes") > -1 ? classPath.substring(0, classPath.indexOf("classes")) :
                    classPath.substring(0, classPath.indexOf("classes"))) + "classes/WinRAR/WinRAR.exe";
            winrarPath = new File(winrarPath).getAbsoluteFile().getAbsolutePath();
        }
        System.out.println(winrarPath);

        boolean bool = false;
        if (!zipFile.exists()) {
            return false;
        }

        // 开始调用命令行解压，参数-o+是表示覆盖的意思
        String cmd = winrarPath + " X -o+ " + zipFile + " " + destDir;
        System.out.println(cmd);
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            if (proc.waitFor() != 0) {
                if (proc.exitValue() == 0) {
                    bool = false;
                }
            } else {
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("解压" + (bool ? "成功" : "失败"));
        return bool;
    }
}
