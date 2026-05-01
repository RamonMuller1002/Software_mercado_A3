package dao;

import java.util.ArrayList;
import model.Movimentacao;

public class MovimentacaoDAO {

    private static int nextId = 1;
    public static ArrayList<Movimentacao> minhaLista = new ArrayList<>();

    public static ArrayList<Movimentacao> getMinhaLista() {
        return minhaLista;
    }

    public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorID) {
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;
    }

    public static boolean insertMovimentacao(Movimentacao movimentacao) {
        if (movimentacao != null) {
            // Se o ID for 0, atribui um novo ID automático
            if (movimentacao.getId() == 0) {
                movimentacao.setId(nextId++);
            }
            minhaLista.add(movimentacao);
            return true;
        }
        return false;
    }

    public Movimentacao findById(int id) {
        for (Movimentacao mov : minhaLista) {
            if (mov.getId() == id) {
                return mov;
            }
        }
        return null;
    }
    
    public static boolean deleteMovimentacao(int id){
        return minhaLista.removeIf(mov -> mov.getId() == id);
    }
}
