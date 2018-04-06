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
}
