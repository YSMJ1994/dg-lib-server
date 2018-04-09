package digital.controller;

import digital.dto.Result;
import digital.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/9.
 */
@RestController
@RequestMapping("/BookType")
public class BookTypeController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getAllTypes", method = RequestMethod.POST)
    public Result getAllTypes(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        result.setData(bookService.getAllTypes());
        return result;
    }

    @RequestMapping(value = "/deleteType", method = RequestMethod.POST)
    public Result deleteType(@RequestBody Map<String, String> map) {
        Result result = new Result();
        bookService.deleteType(map.get("id"));
        result.setCode(200);
        return result;
    }

    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public Result addType(@RequestBody Map<String, String> map) {
        Result result = new Result();
        bookService.addType(map.get("name"), map.get("remark"));
        result.setCode(200);
        return result;
    }
    @RequestMapping(value = "/updateType", method = RequestMethod.POST)
    public Result updateType(@RequestBody Map<String, String> map) {
        Result result = new Result();
        bookService.updateType(map.get("id"), map.get("name"), map.get("remark"));
        result.setCode(200);
        return result;
    }
}
