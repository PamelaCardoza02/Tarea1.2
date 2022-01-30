package conexiondb;
//Paquetes para la conexion
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private Connection connection;
    private Statement statement;

    //Constructor
    public Conexion(String url, String user, String passWord)
    {
        //LLamar la clase de la conexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url, user, passWord);
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    //Método para las instrucciones del insert, update y delate
    public void ejecutar (String sql) throws SQLException
    {
        connection.createStatement().execute(sql);
    }

    //Método para select

    public ResultSet query (String sqlQuery) throws SQLException
    {
        Statement statement =connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }
}
