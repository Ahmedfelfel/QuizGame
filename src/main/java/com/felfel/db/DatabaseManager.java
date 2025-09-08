package com.felfel.db;

import com.felfel.config.ConfigManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() throws SQLException {
        String url = ConfigManager.get("db.url");
        String user = ConfigManager.get("db.user");
        String password = ConfigManager.get("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}
