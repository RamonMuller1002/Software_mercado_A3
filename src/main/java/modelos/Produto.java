package modelos;

import enums.*;

public class Produto {

    private String nome;
    private double preco;
    private Unidade unidade;
    private double quantidadeEstoque;
    private int quantidadeMin;
    private int quantidadeMax;
    private Categorias categoria;

//Construtores
    public Produto() {
    }

    public Produto(String nome, double preco, Unidade unidade,
            double quantidadeEstoque, int quantidadeMin, int quantidadeMax, Categorias categoria) {

        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.categoria = categoria;
    }

//Gets
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public double getQuantidadeEstoque() {
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
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
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

}
