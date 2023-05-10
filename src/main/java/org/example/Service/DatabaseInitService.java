package org.example.Service;

import org.example.Database;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void InitData(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:~/test6",null,null)
                .load();

        flyway.migrate();
    }

}
