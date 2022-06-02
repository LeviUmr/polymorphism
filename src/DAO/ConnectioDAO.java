package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectioDAO {
    public Connection getConnection() throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/dbPolimorphism";
            String username = "admin";
            String password = "123";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println("Not Connected"+e);
            return null;
        }
    }
}
