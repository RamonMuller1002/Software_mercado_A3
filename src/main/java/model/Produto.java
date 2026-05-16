package model;

import enums.Unidade;
import java.util.ArrayList;
import dao.ProdutoDAO;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private Unidade unidade;
    private int quantidadeEstoque;
    private int quantidadeMin;
    private int quantidadeMax;
    private Categorias categoria;
    private ProdutoDAO dao = new ProdutoDAO();

//Construtores
    public Produto() {
    }

    public Produto(int id, String nome, double preco, Unidade unidade,
            int quantidadeEstoque, int quantidadeMin, int quantidadeMax, Categorias categoria) {

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.categoria = categoria;
    }
   
//Gets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public Categorias getCategoria() {
        return categoria;
    }

//Sets
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public void setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Produto> getMinhaLista() {
        return dao.getMinhaLista();
    }
    
// Cadastra novo produto

    public boolean insertProdutoBD(String nome,double preco,Unidade unidade,int quantidadeEstoque,int quantidadeMin,int quantidadeMax,Categorias categoria) {
        int novoId = this.maiorID() + 1;
        Produto objeto = new Produto(novoId, nome, preco, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoria);
        dao.insertProdutoBD(objeto);
        return true;
    }
    
// Deleta um produto específico pelo seu campo ID

    public boolean deleteProdutoBD(int id) {
        dao.deleteProdutoBD(id);
        return true;
    }
    
// Edita um produto específico pelo seu campo ID

    public boolean updateProdutoBD(String nome, double preco, Unidade unidade, int quantidadeEstoque, int quantidadeMin, int quantidadeMax, Categorias categoria) {
        Produto objeto = new Produto(id, nome, preco, unidade, quantidadeEstoque, quantidadeMin, quantidadeMax, categoria);        
        dao.updateProdutoBD(objeto);
        return true;
    }
    
// Carrega dados de um produto especÍfico pelo seu ID

    public Produto carregaProduto(int id) {
        return dao.carregaProduto(id);
    }
    
// retorna o maior ID da nossa base de dados

    public int maiorID() {
        return dao.maiorID();
    }
}
