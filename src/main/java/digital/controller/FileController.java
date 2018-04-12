package digital.controller;

import digital.dto.Result;
import digital.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

//import com.wintime.core.page.model.PageInfo;

/**
 * 创建自: Sober 时间: 2017/4/18.
 */
@Controller
@RequestMapping("/File")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 上传
     */
    @SuppressWarnings("Duplicates")
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request){
        String oldName = request.getParameter("oldName");
        Result result = new Result();
        String res = fileService.uploadFile(file, oldName);
        if ("-1".equals(res)) {
            result.setCode(1003);
        }else {
            result.setCode(200);
            result.setData(res);
        }
        return result;
    }

    /**
     * 下载
     */
    @RequestMapping(value = "/download",method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object downLoadVideo(HttpServletRequest request){
        return fileService.downloadFile(request.getParameter("fileName"), request.getParameter("oldName"));
    }
}
