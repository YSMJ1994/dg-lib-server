package digital.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {

    private Object data;

    private int code;

    private String msg;

}
