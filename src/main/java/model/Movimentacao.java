/*
    Basicamente um registro LOG
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao {

    private String nomeProduto;
    private int quantidadeMovimentada; //quantidade de itens total
    private String dataMovimentacao;
    private String InOrOut;

    public Movimentacao(String nomeProduto, int quantidadeMovimentada) {
        this.nomeProduto = nomeProduto;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.dataMovimentacao = setDataMovimentacao();
        this.InOrOut = In_Or_Out(quantidadeMovimentada);
    }

    public Movimentacao() {
        this("", 0);
        //this(nomeProduto, quantidadeMovimentada);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public final String setDataMovimentacao() {
        LocalDateTime agora = LocalDateTime.now();
        String DataHora = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.dataMovimentacao = DataHora;
        return DataHora;
    }

    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public String getInOrOut() {
        return InOrOut;
    }

    public void setInOrOut() {
        this.InOrOut = In_Or_Out(quantidadeMovimentada);
    }

    /*Metodos de Movimentação? Pagamento? Registrar data?*/
    public static String In_Or_Out(int quantidadeMovimentada) {
        String InOrOut;

        if (quantidadeMovimentada > 0) {
            InOrOut = "Entrada";
        } else if (quantidadeMovimentada == 0) {
            InOrOut = "Opcao invalida";
        } else {
            InOrOut = "Saida";
        }

        return InOrOut;
    }

}
