package portalPlantei;

import java.util.List;

public class listaPlanta {
        
    private static List<Planta> lista;

    // Métodos para acessarmos a lista e adicionarmos novos itens
    public static List<Planta> listar() {
        return lista;
    }

    public static void adicionar(Planta Planta) {
        lista.add(Planta);
    }

   
    






}