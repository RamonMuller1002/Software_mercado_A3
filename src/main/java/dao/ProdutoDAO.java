package dao;

import connection.ConnectionFactory;
import model.Categorias;
import model.Produto;
import enums.Unidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    public ArrayList<Produto> minhaLista = new ArrayList<>();

    public Connection getConexao() throws SQLException, ClassNotFoundException {
        return new ConnectionFactory().getConnection();
    }

    public ArrayList<Produto> getMinhaLista() {

        minhaLista.clear();
        try {

            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM produto");

            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                double preco = res.getDouble("preco_unitario");
                Unidade unidade = Unidade.valueOf(res.getString("unidade"));
                int quantidadeEstoque = res.getInt("quantidade_estoque");
                int quantidadeMin = res.getInt("quantidade_minima");
                int quantidadeMax = res.getInt("quantidade_maxima");

                Categorias categoria = new Categorias();
                categoria.setC_nome(res.getString("categoria"));

                Produto objeto = new Produto(id, nome, preco, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoria);
                minhaLista.add(objeto);
            }
            res.close();
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
        }
        return minhaLista;
    }

    // CARREGA PRODUTO PELO ID
    public Produto carregaProduto(int id) {

        Produto objeto = new Produto();
        objeto.setId(id);

        try {

            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM produto WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setPreco(res.getDouble("preco_unitario"));
            objeto.setUnidade(Unidade.valueOf(res.getString("unidade")));
            objeto.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
            objeto.setQuantidadeMin(res.getInt("quantidade_minima"));
            objeto.setQuantidadeMax(res.getInt("quantidade_maxima"));

            Categorias categoria = new Categorias();
            categoria.setC_nome(res.getString("categoria"));
            objeto.setCategoria(categoria);

            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
        }
        return objeto;
    }
}