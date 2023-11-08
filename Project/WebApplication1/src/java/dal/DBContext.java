package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    public DBContext() {
        connection = DBContext();
    }
    protected Connection connection;

    public Connection DBContext() {
        final String url = "jdbc:mysql://localhost:3306/swp_prj";
        final String user = "trungnq";
        final String pass = "1234";

//        final String url = "jdbc:mysql://localhost:3306/swp_ite2?zeroDateTimeBehavior=CONVERT_TO_NULL";
//        final String user = "root";
//        final String pass = "123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            return connection;
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e);
        }
        return connection;

    }

}
