package digital.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 创建自: Sober 时间: 2018/4/7.
 */
@Setter
@Getter
@ToString
public class Download {

    private int id;

    private int userId;

    private int bookId;

    private int score;

    private int total;

}
