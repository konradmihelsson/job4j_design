package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties config = new Properties();
        try (InputStream in = ConnectionDemo.class.getClassLoader().getResourceAsStream("tracker.properties")) {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class.forName(config.getProperty("driver-class-name"));
            try (Connection connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"))) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        }
    }
