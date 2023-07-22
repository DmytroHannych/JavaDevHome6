package org.example;

import org.example.Service.ClientService;
import org.example.Service.DatabaseInitService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       Connection connection = DriverManager.getConnection("jdbc:h2:~/test6");
//        DatabaseInitService databaseInitService = new DatabaseInitService();
//        databaseInitService.InitData();
//        ClientService clientService = new ClientService(connection);
//        clientService.create("Igor");
//        clientService.getById(2);
//        clientService.setName(3,"Leonid");
//        System.out.println("clientService.listAll() = " + clientService.listAll());
//        clientService.deleteById(1);
        connection.close();
    }
}