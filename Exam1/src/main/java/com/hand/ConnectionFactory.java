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
        String url = "jdbc:mysql://" +
                System.getenv("ip") + ":" + System.getenv("port") + "/" + System.getenv("database") +
                "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
        URL = url;
        USER = env.get("user");
        PASSWORD = env.get("password");
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }
}
