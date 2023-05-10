package org.example;

import org.example.Service.ClientService;
import org.example.Service.DatabaseInitService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       Connection connection = DriverManager.getConnection("jdbc:h2:~/test6",null,null);
        DatabaseInitService databaseInitService = new DatabaseInitService();
        databaseInitService.InitData();
        ClientService clientService = new ClientService(connection);
        clientService.create("Petro");
//        System.out.println("clientService.getById(2) = " + clientService.getById(2));
//        clientService.setName(3,"Leonid");
//        clientService.listAll();
//        clientService.deleteById(1);
    }
}