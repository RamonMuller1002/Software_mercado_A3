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

    // INSERE PRODUTO
    public boolean insertProdutoBD(Produto objeto) {

        String sql = "INSERT INTO produto (id, nome, preco_unitario, unidade, "
                + "quantidade_estoque, quantidade_minima, quantidade_maxima, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setDouble(3, objeto.getPreco());
            stmt.setString(4, objeto.getUnidade().name());
            stmt.setInt(5, objeto.getQuantidadeEstoque());
            stmt.setInt(6, objeto.getQuantidadeMin());
            stmt.setInt(7, objeto.getQuantidadeMax());
            stmt.setString(8, objeto.getCategoria().getC_nome());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);

        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    // RETORNA MAIOR ID
    public int maiorID() {

        int maiorID = 0;

        try {

            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM produto");
            res.next();

            maiorID = res.getInt("id");
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
        }
        return maiorID;
    }

    // DELETA PRODUTO
    public boolean deleteProdutoBD(int id) {

        try {

            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM produto WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
        return true;
    }

    // ATUALIZA PRODUTO
    public boolean updateProdutoBD(Produto objeto) {

        String sql = "UPDATE produto SET nome = ?, preco_unitario = ?, unidade = ?, "
                + "quantidade_estoque = ?, quantidade_minima = ?, quantidade_maxima = ?, categoria = ? WHERE id = ?";

        try {

            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setDouble(2, objeto.getPreco());
            stmt.setString(3, objeto.getUnidade().name());
            stmt.setInt(4, objeto.getQuantidadeEstoque());
            stmt.setInt(5, objeto.getQuantidadeMin());
            stmt.setInt(6, objeto.getQuantidadeMax());
            stmt.setString(7, objeto.getCategoria().getC_nome());
            stmt.setInt(8, objeto.getId());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }
}