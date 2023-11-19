package org.example.util;

import org.example.configuration.DataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName(DataBaseConfig.DRIVER);
        return DriverManager.getConnection(DataBaseConfig.URL, DataBaseConfig.USER, DataBaseConfig.PASSWORD);
    }

}
