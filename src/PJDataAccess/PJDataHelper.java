package PJDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class PJDataHelper {
    private static String PJDBPathConnection = "jdbc:sqlite:DataBase//PJEcuaFauna.sqlite"; 
    private static Connection PJConn = null;

    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(PJConn == null)
                PJConn = DriverManager.getConnection(PJDBPathConnection);
        } catch (SQLException e) {
             throw e;   //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return PJConn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (PJConn != null)
            PJConn.close();
        } catch (Exception e) {
            throw e;    //new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}