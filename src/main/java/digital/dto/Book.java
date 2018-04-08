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
public class Book {

    private int id;

    private String name;

    private String type;

    private String byteSize;

    private String author;

    private String translator;

    private String version;

    private String language;

    private String coverUrl;

    private String averageScore;

}
