package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String uri = "jdbc:mysql://127.0.0.1:3306/prueba?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String driverName ="com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(uri, user, password);
            System.out.println("Success connection!");
        }catch(SQLException e){
            System.out.println("Failed to create the data base connection ");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("Driver not found ");
        }
        return connection;
    }
}
