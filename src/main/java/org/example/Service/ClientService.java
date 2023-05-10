package org.example.Service;

import org.example.Entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readStById;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private PreparedStatement readListSt;
    private PreparedStatement maxIdByClient;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?)"
        );
        maxIdByClient = connection.prepareStatement(
                "SELECT max(id) AS maxId FROM client"
        );
        readStById = connection.prepareStatement(
                "SELECT name FROM client WHERE id = ?"
        );

        updateSt = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?"
        );
        readListSt = connection.prepareStatement(
                "SELECT id, name FROM client"
        );
        deleteSt = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?"
        );
    }


    public Long create(String name) throws SQLException {
        createSt.setString(1, name);
        createSt.executeUpdate();
        long id;
        try (ResultSet resultSet = maxIdByClient.executeQuery()) {
            resultSet.next();
            id = resultSet.getLong("maxId");
        }
        return id;
    }

    public String getById(long id) throws SQLException {

        readStById.setLong(1, id);

        ResultSet resultSet = readStById.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        String name = resultSet.getString("name");
        return name;
    }

    public void setName(long id, String name) throws SQLException {
        updateSt.setString(1, name);
        updateSt.setLong(2, id);
        updateSt.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
        deleteSt.setLong(1, id);
        deleteSt.executeUpdate();
    }

    public List<Client> listAll() throws SQLException {
        try (ResultSet rs = readListSt.executeQuery()) {
            List<Client> clients = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                clients.add(client);
            }
            return clients;
        }
    }
}
