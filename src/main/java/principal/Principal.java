package principal;

import connection.ConnectionFactory;
import database.DatabaseInitializer;
import database.TableInitializer;
import java.sql.Connection;
import java.sql.SQLException;
import dao.MovimentacaoDAO;

public class Principal {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        // Criar banco
        DatabaseInitializer.createDatabase();
        
        // Conectar ao banco
        Connection conn = new ConnectionFactory().getConnection();
        
        // Criar tabelas
        TableInitializer.createTables(conn);
        
        // Fechar conexão
        ConnectionFactory.closeConnection(conn);
        
        
    }
}
