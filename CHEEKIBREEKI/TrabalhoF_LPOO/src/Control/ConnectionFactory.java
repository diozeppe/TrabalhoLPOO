/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giuseppe
 */
public class ConnectionFactory {

    public Connection getConnection() {
        Connection connection = null;
        try {
            String serverName = "localhost";
            String mydatabase = "lpoo_contatos";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url  
            String username = "root";
            String password = "";
            return connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
