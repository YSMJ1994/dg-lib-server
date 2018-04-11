package digital.dao;

import digital.dto.Book;
import digital.dto.BookType;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
        if(null != name && !"".equals(name.trim())) {
            name = "%" + name + "%";
        }
        if(null != author && !"".equals(author.trim())) {
            author = "%" + author + "%";
        }
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("name", name);
        map.put("author", author);
        return new Eql().select("getBookByType").params(map).returnType(Map.class).execute();
    }
    public List<Book> getBookByTypeLimit3(String type) {
        return new Eql().select("getBookByTypeLimit3").params(type).returnType(Book.class).execute();
    }


    public void changeBookType(String id) {
        new Eql().update("changeBookType").params(id).execute();
    }

    public List<Map> getDownloadTopFive() {
        return new Eql().select("getDownloadTopFive").returnType(Map.class).execute();
    }

    public List<Map> getScoreTopFive() {
        return new Eql().select("getScoreTopFive").returnType(Map.class).execute();
    }

    public List<Map> getRecommendTop() {
        return new Eql().select("getRecommendTop").returnType(Map.class).execute();
    }

    public void deleteBook(String id) {
        new Eql().delete("deleteBook").params(id).execute();
    }

    public void uploadBook(Map<String, String> map) {
        new Eql().insert("addBook").params(map).execute();
    }

    public void updateBook(Map<String, String> map) {
        new Eql().update("updateBook").params(map).execute();
    }

    public void updateBookScore(int bookId, int score) {
        new Eql().update("updateBookScore").params(bookId, score).execute();
    }

    public List<Map> getBookDetailsById(String id) {
        return new Eql().select("getBookDetailsById").params(id).returnType(Map.class).execute();
    }

    public List<Map> getTopFiveByType(String type) {
        return new Eql().select("getTopFiveByType").params(type).returnType(Map.class).execute();
    }
}
