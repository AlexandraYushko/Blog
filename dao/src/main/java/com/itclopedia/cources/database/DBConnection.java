package com.itclopedia.cources.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String PROPERTIES_FILE = "application.properties";
    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USER = "jdbc.user";
    private static final String JDBC_PASSWORD = "jdbc.password";
    private static final DBConnection instance = new DBConnection();

    private DBConnection() {
        loadProperties();
    }

    public static DBConnection getInstance() {
        return instance;
    }

    public Connection getConnection() throws  SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
                return;
            }
            properties.load(input);
            properties.getProperty(JDBC_URL);
            properties.getProperty(JDBC_USER);
            properties.getProperty(JDBC_PASSWORD);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
