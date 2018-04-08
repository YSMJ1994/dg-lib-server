package digital.service;

import digital.dao.UserDao;
import digital.dto.Result;
import digital.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public Result loginByAccountAndPwd(String account, String password) {
        Result result = new Result();
        result.setCode(200);
        if((null == account || account.equals("")) ||
            (null == password || password.equals(""))) {
            result.setCode(1001);
            result.setData(null);
            result.setMsg("账号或密码错误");
            log.error("登录失败, 账号或密码为空");
            return result;
        }

        User user = userDao.queryByAccountAndPwd(account, password);
        result.setData(user);
        return result;
    }

    public boolean registerUser(Map<String, String> map) {
        String account = map.get("account");
        String password = map.get("password");
        String username = map.get("username");
        //默认权限为游客
        String role = "3";
        boolean b = accountIsAvailable(account);
        if(b) {
            userDao.registerUser(account, password, username, role);
            return true;
        }else {
            return false;
        }
    }

    public boolean accountIsAvailable(String account) {
        User user = userDao.queryByAccount(account);
        return user == null;
    }

    public User getUserInfo(String id) {
        return userDao.getUserById(id);
    }
}
