package digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 创建自: Sober 时间: 2017/4/18.
 */
@Service
public class FileService {
    private static final String FOLDER_PATH = "d://uploadFolder";

    @Autowired
    HttpServletResponse response;

    @Value("${upload-file-path}")
    String uploadPath;

    /**
     * 上传文件
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file, String oldName) {
        String targetFilePath = "";
        if(!file.isEmpty()){
            try {
                String fileName = file.getOriginalFilename();
                //String jarPath = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
                //jarPath = jarPath.substring(jarPath.indexOf("file:") + 5);
                System.out.println("uploadFileName--------------------" + fileName);
                //targetFilePath = jarPath + "uploadFolder/" + fileName;
                File dir = new File(uploadPath);
                if(!dir.exists()) {
                    dir.mkdir();
                }
                targetFilePath = uploadPath + "/" + fileName;
                new File(targetFilePath).delete();
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(targetFilePath)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return "/File/download?fileName=" + fileName;
            } catch (IOException e) {
                e.printStackTrace();
                return "-1";
            }
        }else {
            return "-1";
        }
    }

    /**
     * 下载文件
     * @param fileName
     * @return
     */
    public Object downloadFile(String fileName, String oldName) {
        try {
            if(fileName == null) {
                return "-1";
            }
            //String jarPath = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
            //jarPath = jarPath.substring(jarPath.indexOf("file:") + 5);
            //String path = jarPath + "uploadFolder/" + fileName;
            String path = uploadPath + "/" + fileName;;
            //File file = new File(path);
            //String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            in.close();
            //String resName;
            //if(oldName != null && !"".equals(oldName.trim()) && !"null".equals(oldName)) {
            //    resName = oldName;
            //}else {
            //    resName = fileName;
            //}
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            response.addHeader("Content-Length", "" + bytes.length);
            response.setContentType("application/octet-stream");
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
        return "1";
    }
}
