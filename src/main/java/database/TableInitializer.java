
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableInitializer {
    public static void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()){
            
            // Categoria
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS categoria (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    tamanho ENUM('Pequeno','Medio','Grande') NOT NULL,
                    embalagem ENUM('Lata','Vidro','Plastico') NOT NULL
                )
            """);
            
            // Produto
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS produto (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    preco_unitario DECIMAL(10,2) NOT NULL,
                    unidade VARCHAR(20) NOT NULL,
                    quantidade_estoque INT NOT NULL,
                    quantidade_minima INT NOT NULL,
                    quantidade_maxima INT NOT NULL,
                    categoria_id INT NOT NULL,
                    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
                )
            """);
            
            // MOVIMENTACAO
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS movimentacao (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    produto_id INT NOT NULL,
                    data_movimentacao DATETIME NOT NULL,
                    quantidade INT NOT NULL,
                    tipo ENUM('Entrada','Saida') NOT NULL,
                    FOREIGN KEY (produto_id) REFERENCES produto(id)
                )
            """);
            
            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException e){
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}
