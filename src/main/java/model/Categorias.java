package model;

import enums.*;

public class Categorias {

    private String C_nome;
    private Embalagem embalagens;
    private Tamanho tamanho;

    public Categorias() {
    }

    public Categorias(String C_nome, Embalagem embalagens, Tamanho tamanho) {
        this.C_nome = C_nome;
        this.embalagens = embalagens;
        this.tamanho = tamanho;
    }

    public String getC_nome() {
        return C_nome;
    }

    public Embalagem getEmbalagens() {
        return embalagens;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setC_nome(String C_nome) {
        this.C_nome = C_nome;
    }

    public void setEmbalagens(Embalagem embalagens) {
        this.embalagens = embalagens;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

}
