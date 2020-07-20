package kg.megacom.apiadminservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SessionInfo {


    private String token;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date end_date;

}
