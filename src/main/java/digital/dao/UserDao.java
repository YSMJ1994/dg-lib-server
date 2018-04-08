package digital.dao;

import digital.dto.User;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

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
}
