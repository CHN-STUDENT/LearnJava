package JDBC;

import java.sql.*;

/**
 * @param
 */

public class ConnectToDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Student?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static final String Check_URL="jdbc:mysql://localhost:3306/INFORMATION_SCHEMA?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String USER = "root";
    private String PASS = "iFTJw2E";
    public static Connection conn = null;
    //public Statement stmt = null; //网上说为了提升效能不再使用这种方法
    public ConnectToDatabase () {
        super();
        init(Check_URL);
        checkDatabase();
        init(DB_URL);
    }
    public void checkDatabase() {
        //see here:https://stackoverflow.com/questions/838978/how-to-check-if-mysql-database-exists
        String sql="SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = \'student\'";
            try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(); //本方法适用与查询语句
            if(!rs.next()){
                //无法自动建库，请手动建库。
                System.out.println("数据库不存在，请手动建库");
                close();
                System.exit(-1);
//                String create="CREATE DATABASE Student;\n" +
//                        "USE Student;\n" +
//                        "CREATE TABLE `Student` (\n" +
//                        "    `id` varchar(20) DEFAULT '' NOT NULL, \n" +
//                        "    `name` char(20) NOT NULL DEFAULT '' COMMENT 'name',\n" +
//                        "    `grade` float NOT NULL DEFAULT 0.0 COMMENT 'grade',\n" +
//                        "    PRIMARY KEY (`id`)\n" +
//                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
//                preparedStatement = conn.prepareStatement(create);
//                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void init(final String database_URL) {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connect to mysql server...");
            conn = DriverManager.getConnection(database_URL, USER, PASS);
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
