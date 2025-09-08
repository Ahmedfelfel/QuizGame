package com.felfel.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DbTest {

        public static void main(String[] args) {
            try (Connection conn = DatabaseManager.getConnection()) {
                System.out.println("✅ Connection successful!");
            } catch (SQLException e) {
                System.err.println("❌ Connection failed: " + e.getMessage());
            }
        }
    }

