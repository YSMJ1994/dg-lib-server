package digital.service;

import digital.dao.DownloadDao;
import digital.dto.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/11.
 */
@Service
public class DownloadService {
    @Autowired
    private DownloadDao downloadDao;
    @Autowired
    private BookService bookService;

    public List<Map<String, String>> getMyDownload(String userId) {
        return downloadDao.getMyDownload(userId);
    }

    public String addDownload(String userId, String bookId) {
        int iUserId;
        int iBookId;
        try {
            iUserId = Integer.parseInt(userId);
            iBookId = Integer.parseInt(bookId);
        }catch (Exception e) {
            return "failed";
        }
        downloadDao.addDownload(iUserId, iBookId);
        return "success";
    }

    public String setScore(String id, String score, String bookId) {
        int dId;
        int dScore;
        int dBookId;
        try {
            dId = Integer.parseInt(id);
            dScore = Integer.parseInt(score);
            dBookId = Integer.parseInt(bookId);
        }catch (Exception e) {
            return "failed";
        }
        downloadDao.setScore(dId, dScore);
        setBookAverageScore(dBookId);
        return "success";
    }

    public void setBookAverageScore(int bookId) {
        List<Download> downloads = downloadDao.getDownloadByBookId(bookId);
        int averageScore = 0;
        int total = 0;
        for (Download d: downloads) {
            total += d.getScore();
        }
        averageScore = total / downloads.size();
        bookService.updateBookScore(bookId, averageScore);
    }

    public void deleteByBookId(String id) {
        downloadDao.deleteByBookId(id);
    }
}
