
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/nomeDoBancoDeDados";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection() throws ClassNotFoundException{
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro na conexão: " + ex);
        }
    }
    
    public static void closeConnection(Connection conn){
        if (conn != null) {
        try {
            conn.close();
        } catch (SQLException ex){
            System.getLogger(ConnectionFactory.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
  }
}
