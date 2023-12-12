
package BDplantei;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import portalPlantei.Planta;

public class CatalogoDAO {
    
    
    public static List<Planta> catalogoDados(){
    
       Conexao conexao = new Conexao();
       conexao.conectar();
       
       String nomePlanta = "Select * from catalogo";
       
       try{
            ResultSet rs = conexao.st.executeQuery(nomePlanta);
            List<Planta> lista = new ArrayList<>();
                        
            while (rs.next()) {
         
                Planta planta = new Planta();
                planta.setId(rs.getInt("id"));
                planta.setNomePlanta(rs.getString("nome_planta"));
                planta.setDescricao(rs.getString("descricao"));
                planta.setTempoSol(rs.getString("tempoSol"));
                planta.setRega(rs.getString("tempoAgua"));
                planta.setTempoAdubo(rs.getString("tempoAdubo"));

                lista.add(planta);
            }
            
            return lista;
           
       } catch(Exception e) {
            System.out.println("Deu erro " + e.getMessage());
            return null;
        } finally {
            conexao.desconectar();
        }
    }    
    
    
    
    
    
    
}
