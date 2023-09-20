package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class UrlMainReport {

    private long id;

    private String name;

    private Timestamp lastCheck;

    private Integer statusCode;
}
