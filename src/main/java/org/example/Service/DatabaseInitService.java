package org.example.Service;


import org.flywaydb.core.Flyway;

public class DatabaseInitService {
//    public void InitData(){
//        Flyway flyway = Flyway
//                .configure()
//                .dataSource("jdbc:h2:~/test6",null,null)
//                .load();
//
//        flyway.migrate();
//    }
    public void InitData(String connectionUrl){
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl,null,null)
                .load();

        flyway.migrate();
    }

}
