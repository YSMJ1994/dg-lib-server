package digital.service;

import digital.dao.UserDao;
import digital.dto.Result;
import digital.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            result.setData(null);
            result.setMsg("账号或密码错误");
            log.error("登录失败, 账号或密码为空");
            return result;
        }

        User user = userDao.queryByAccountAndPwd(account, password);
        result.setData(user);
        return result;
    }
}
