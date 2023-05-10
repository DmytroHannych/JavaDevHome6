package org.example.Entity;

import lombok.Data;

import java.sql.Date;
@Data
public class Project {
    private Integer client_id;
    private Date start_day;
    private Date finish_day;

}
