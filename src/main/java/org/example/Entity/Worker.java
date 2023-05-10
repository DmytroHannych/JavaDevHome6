package org.example.Entity;

import lombok.Data;

import java.sql.Date;
@Data
public class Worker {
    private String name;
    private Date birthday;
    private String level;
    private Integer salary;

}
