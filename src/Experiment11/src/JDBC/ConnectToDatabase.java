package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Student?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String USER = "root";
    private String PASS = "iFTJw2E";
    public static Connection conn = null;
    //public Statement stmt = null; //网上说为了提升效能不再使用这种方法

    public ConnectToDatabase () {
        super();
        init();
    }

    public void init() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connect to mysql server...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Create the statement object...");

        } catch (SQLException se) {
            dealWithError(se);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void close() {
//        try {
//            if (stmt != null)
//                stmt.close();
//        } catch (SQLException se2) {
//            dealWithError(se2);
//        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            dealWithError(se);
        }
    }

    public void dealWithError(SQLException se) {
        se.printStackTrace();
        System.exit(-1);
    }
}
