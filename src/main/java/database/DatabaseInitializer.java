
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "628387";
    
    public static void createDatabase() throws SQLException{
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS estoquemercado");
            System.out.println("Banco de dados criado com sucesso!");
        } catch (SQLException e){
            System.out.println("Erro ao criar banco de dados: " + e.getMessage());
        }
    
    
        
        
    }
}
