package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //Connection manager con patron singletone
    private static volatile ConnectionManager instance;
    private final String URL_DATABASE = "jdbc:h2:C:\\Users\\A21GonzaloCM\\Desktop\\library";
    private final String USER_DATABASE = "";
    private final String PASS_DATABASE = "";

    private Connection con;

    private void ConnectionManager() {
    }

    public Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL_DATABASE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }
}

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//public class Main {
//    public static void main(String[] args) {
//
//        ConnectionManager connectionManager = ConnectionManager.getInstance();
//        Connection con = connectionManager.getConnection();
//
//        if (con != null) {
//            System.out.println("Conexion establecida");
//        } else {
//            System.out.println("Conexion no establecida");
//        }
//
//
//        try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
//
//            ResultSet rs = st.executeQuery("SELECT * from BOOK");
//            while (rs.next()) {
//                System.out.println(rs.getString("title"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}