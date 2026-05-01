/*
    Basicamente um registro LOG
 */
package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import dao.MovimentacaoDAO;
import static dao.MovimentacaoDAO.minhaLista;

public class Movimentacao {

    private int id;
    private String nomeProduto;
    private int quantidadeMovimentada; //quantidade de itens total
    private String dataMovimentacao;
    private String InOrOut;

    public Movimentacao(int id, String nomeProduto, int quantidadeMovimentada) {

        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.dataMovimentacao = setDataMovimentacao();
        this.InOrOut = In_Or_Out(quantidadeMovimentada);
    }

    public Movimentacao() {
        this(0, "", 0);
        //this(id, nomeProduto, quantidadeMovimentada);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean insertMovimentacaoBD() {
        return MovimentacaoDAO.insertMovimentacao(this);
    }
    
    public boolean updateMovimentacaoBR(){
        MovimentacaoDAO objeto = new MovimentacaoDAO();
        return objeto.updateMovimentacao(this);
    }
    
    public boolean deleteMovimentacaoBD(int id){
        return MovimentacaoDAO.deleteMovimentacao(id);
    }
    
    public Movimentacao readMovimentacaoById(int id){
        MovimentacaoDAO objeto = new MovimentacaoDAO();        
        return objeto.readById(id);
    }
    
    public void readMovimentacao(){
        MovimentacaoDAO objeto = new MovimentacaoDAO();
        objeto.readAllMovimentacao();
    }

}
