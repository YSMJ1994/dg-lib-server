package digital.dao;

import digital.dto.Book;
import digital.dto.BookType;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/7.
 */
@Repository
public class BookDao {

    public List<BookType> getAllBookType() {
        return new Eql().select("getAllBookType").returnType(BookType.class).execute();
    }

    public List<Book> getBookByType(String type, String name, String author) {
        name = "%" + name + "%";
        author = "%" + author + "%";
        return new Eql().select("getBookByType").params(type, name, author).returnType(Map.class).execute();
    }
    public List<Book> getBookByTypeLimit3(String type) {
        return new Eql().select("getBookByTypeLimit3").params(type).returnType(Book.class).execute();
    }

    public void changeBookType(String id) {
        new Eql().update("changeBookType").params(id).execute();
    }
}
