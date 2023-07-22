package org.example.Service;


import org.example.Entity.Client;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


class ClientServiceTest {
    Connection connection;

    private ClientService clientService;
    @BeforeEach
    public void beforeEach() throws SQLException {
        final String connectionUrl = "jdbc:h2:mem:test6";
        connection = DriverManager.getConnection(connectionUrl);
        new DatabaseInitService().InitData(connectionUrl);
        clientService = new ClientService(connection);
    }

    @Test
    public void testThanClientCreateCorretly() throws SQLException {
        String name  = "Pavell";
        Long id = clientService.create(name);
        String saveClient = clientService.getById(id);
        Assertions.assertEquals(name, saveClient);
    }

    @Test
     public void testUpdate() throws SQLException {
        String name = "Vasil";
        String newName = "Pedro";
        Long id = clientService.create(name);

        clientService.setName(id,newName);

        String update = clientService.getById(id);
        Assertions.assertEquals(newName, update);
    }

    @AfterEach
    public void afterEach() throws SQLException {
        connection.close();
    }
}