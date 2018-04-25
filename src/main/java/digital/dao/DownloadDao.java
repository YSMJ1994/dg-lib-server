package digital.dao;

import digital.dto.Download;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2018/4/7.
 */
@Repository
public class DownloadDao {
    public List<Map<String,String>> getMyDownload(String userId) {
        return new Eql().select("getMyDownload").params(userId).returnType(Map.class).execute();
    }

    public void setScore(int dId, int dScore) {
        new Eql().update("setScore").params(dId, dScore).execute();
    }

    public void addDownload(int userId, int bookId) {
        new Eql().insert("addDownload").params(userId, bookId).execute();
    }

    public List<Download> getDownloadByBookId(int bookId) {
        return new Eql().select("getDownloadByBookId").params(bookId).returnType(Download.class).execute();
    }

    public void deleteByBookId(String id) {
        int iId = 0;
        if(id != null && !"".equals(id.trim())) {
            try {
                iId = Integer.parseInt(id);
            }catch (NumberFormatException e) {
                e.printStackTrace();
                return;
            }
        }
        new Eql().delete("deleteByBookId").params(iId).execute();
    }

    public int getCountByUserId(int userId) {
        return new Eql().selectFirst("getCountByUserId").params(userId).returnType(Integer.class).execute();
    }
}
