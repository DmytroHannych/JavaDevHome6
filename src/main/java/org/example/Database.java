package org.example;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
private final static String DATABASE_URL = "jdbc:h2:~/test6";
private  Connection conn;
private final static Database DATABASE = new Database();

private Database(){
    try {
        conn = DriverManager.getConnection(DATABASE_URL);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static Database getInstance(){
    return DATABASE;
}

public  Connection getConnection(){
    return conn;
}

public int executeUpdate(String sql){
    try {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
         return preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
}
}
