package digital.controller;

import digital.dto.Result;
import digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dglib/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result hello(@RequestBody Map<String, String> map) {

        return userService.loginByAccountAndPwd(map.get("account"), map.get("password"));
    }
}
