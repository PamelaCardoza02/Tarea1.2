import java.sql.SQLException;

import singleton.ConexionSingleton;

public class Main{
    public static void main(String args[])
    {
        try {
        //Creando los objetos de Singleton
        ConexionSingleton conexionSingleton= ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ine", 
            "ine_user", 
            "1234");

            //Crear usuario
            conexionSingleton.getConexion().query("select * from cuidadano");
            //conexionSingleton.getConexion().ejecutar("insert into cuidadano values('Alejandro Cardoza')");

            //Para actualizar
            //conexionSingleton.getConexion().ejecutar("update cuidadano set nombre='Pedro picapiedra' where nombre = 'Luis Antonio';");

            //Eliminar
            //conexionSingleton.getConexion().ejecutar("delete from cuidadano where nombre='Alejandro Cardoza';");
            
            //Tabla de cuidad
            conexionSingleton.getConexion().ejecutar("create table Cuidad (ID int primary key, nombre varchar(20), continente varchar(20));");
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
   
}