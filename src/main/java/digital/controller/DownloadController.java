package digital.controller;

import digital.dto.Result;
import digital.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/11.
 */
@RestController
@RequestMapping("/Download")
public class DownloadController {
    @Autowired
    DownloadService downloadService;

    @RequestMapping(value = "/getMyDownload", method = RequestMethod.POST)
    public Result getMyDownload(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        result.setData(downloadService.getMyDownload(map.get("userId")));
        return result;
    }

    @RequestMapping(value = "/setScore", method = RequestMethod.POST)
    public Result setScore(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        result.setData(downloadService.setScore(map.get("id"), map.get("score"), map.get("bookId")));
        return result;
    }
}
