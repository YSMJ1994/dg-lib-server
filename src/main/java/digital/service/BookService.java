package digital.service;

import digital.dao.BookDao;
import digital.dao.BookTypeDao;
import digital.dto.Book;
import digital.dto.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/7.
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookTypeDao bookTypeDao;

    public List<Map<String, Object>> getBookStrap() {
        List<Map<String, Object>> res = new ArrayList<>();
        List<BookType> allBookType = getAllBookType();
        for (BookType bt : allBookType) {
            String type = String.valueOf(bt.getId());
            List<Book> books = getBookByTypeLimit3(type);
            if(null != books && books.size() != 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("typeMsg", bt);
                map.put("books", books);
                res.add(map);
            }
        }
        return res;
    }

    public List<BookType> getAllBookType() {
        return bookDao.getAllBookType();
    }

    public List<Book> getBookByType(String type) {
        return bookDao.getBookByType(type);
    }

    public List<Book> getBookByTypeLimit3(String type) {
        return bookDao.getBookByTypeLimit3(type);
    }

    public List<Map> getAllTypes() {
        return bookTypeDao.getAllTypes();
    }

    public void deleteType(String id) {
        bookTypeDao.deleteType(id);
        bookDao.changeBookType(id);
    }

    public void addType(String name, String remark) {
        bookTypeDao.addType(name, remark);
    }

    public void updateType(String id, String name, String remark) {
        bookTypeDao.updateType(id, name, remark);
    }
}
