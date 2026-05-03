package dao;

import model.Categorias;
import java.util.*;

public class CategoriaDAO {

    private static ArrayList<Categorias> listaCategoria = new ArrayList<>();

    public static ArrayList<Categorias> getListaCategoria() {
        return listaCategoria;
    }

    public static void setListaCategoria(ArrayList<Categorias> listaCategoria) {
        CategoriaDAO.listaCategoria = listaCategoria;
    }

}
