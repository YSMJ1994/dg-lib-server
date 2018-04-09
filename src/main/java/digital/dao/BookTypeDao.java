package digital.dao;

import digital.dto.BookType;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/7.
 */
@Repository
public class BookTypeDao {

    public List<Map> getAllTypes() {
        return new Eql().select("getAllTypes").returnType(Map.class).execute();
    }

    public void deleteType(String id) {
        new Eql().delete("deleteType").params(id).execute();
    }

    public void addType(String name, String remark) {
        BookType bt = new Eql().insert("addType").params(name, remark).returnType(BookType.class).execute();
        System.out.println(bt != null ? bt.getId() : "xxx");
    }
}
