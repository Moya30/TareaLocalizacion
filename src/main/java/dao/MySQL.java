package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {

    Connection connection = null;
    static MySQL instance = null;

    public MySQL() throws Exception {
        String url = "jdbc:mysql://localhost:3306/distribuido";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "");
    }

    public static MySQL getInstance() throws Exception {
        if (instance == null) {
            instance = new MySQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!connection.isClosed()) {
            connection.close();
            connection = null;
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
