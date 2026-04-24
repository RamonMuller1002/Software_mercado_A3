package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Movimentacao;

public class MovimentacaoDAO {

    public static void insertRegistro(String nome, String dataMovimentacao, Connection conn) throws SQLException {

        Movimentacao teste = new Movimentacao("nome", 12);
        System.out.println(teste);

        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO movimentacao VALUES [ 02, " + teste.getDataMovimentacao() + ", " + teste.getQuantidadeMovimentada() + ", 'Entrada' ];");
        } catch (SQLException e) {
            System.out.println("Erro ao executar");
        }

    }
}
