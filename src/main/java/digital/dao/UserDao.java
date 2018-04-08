package digital.dao;

import digital.dto.User;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    public User queryByAccountAndPwd(String account, String password) {
        return new Eql().selectFirst("queryUser")
                .params(account, password).returnType(User.class).execute();
    }

    public User queryByAccount(String account) {
        return new Eql().selectFirst("queryUserByAccount")
                .params(account).returnType(User.class).execute();
    }

    public void registerUser(String account, String password, String username, String role) {
        new Eql().insert("insertUser").params(account, password, username, role).execute();
    }

    public User getUserById(String id) {
        return new Eql().selectFirst("queryUserById").params(id).returnType(User.class).execute();
    }

    public List<Map> getUserList(String username, String account) {
        username = "%" + username + "%";
        account = "%" + account + "%";
        return new Eql().select("getUserList").params(username, account).returnType(Map.class).execute();
    }

    public void setHighRole(String id) {
        new Eql().update("setHighRole").params(id).execute();
    }

    public void deleteUser(String id) {
        new Eql().delete("deleteUser").params(id).execute();
    }
}
