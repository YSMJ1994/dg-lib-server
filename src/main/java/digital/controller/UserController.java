package digital.controller;

import digital.dto.Result;
import digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, String> map) {

        return userService.loginByAccountAndPwd(map.get("account"), map.get("password"));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        result.setData(userService.registerUser(map));
        return result;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result getUserInfo(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        result.setData(userService.getUserInfo(map.get("id")));
        return result;
    }

    @RequestMapping(value = "/accountIsAvailable", method = RequestMethod.POST)
    public Result accountIsAvailable(@RequestBody Map<String, String> map) {
        Result result = new Result();
        result.setCode(200);
        try {
            result.setData(userService.accountIsAvailable(map.get("account")));
        }catch (Exception e) {
            result.setCode(1001);
            result.setMsg("检查用户名异常");
        }
        return result;
    }
}
