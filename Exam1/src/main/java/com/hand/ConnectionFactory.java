package com.hand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;


public class ConnectionFactory {
    public static final String DRIVER;
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;

    static {
        Map<String, String> env = System.getenv();
        DRIVER = env.get("driver");
        String builder = "jdbc:mysql://" +
                System.getenv("ip") +
                ":" +
                System.getenv("port") +
                "/" +
                System.getenv("database") +
                "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
        URL = builder;
        USER = env.get("user");
        PASSWORD = env.get("password");
    }

//    "jdbc:mysql://192.168.99.100:3306/sakila?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false"
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
