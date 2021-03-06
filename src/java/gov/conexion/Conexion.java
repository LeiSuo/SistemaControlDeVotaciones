package gov.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Nombre de la clase: Diputado
 * Version: 1.1
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tse?user=root&password=Bb414116");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tse?user=root&password=");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void desconectar() throws Exception{
        try{
            if(con!=null) {
                if (con.isClosed()==false) {
                    con.close();
                }
            }
        }catch(Exception e){
            throw e;
        }
    }
}
