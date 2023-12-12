
package BDplantei;

import java.sql.ResultSet;

public class UsuarioDAO {
    
    public static boolean logar (String login, String senha) {
        
        Conexao conn = new Conexao();
        conn.conectar();
        
        String query = "Select nome from usuario where nome = '" + login + "' and senha = '" + senha + "'";
        
        try {
            ResultSet rs = conn.st.executeQuery(query);
            
            return rs.next();
        } catch (Exception e) {
            System.out.println("Deu erro " + e.getMessage());
            return false;
        } finally {
            conn.desconectar();
        }
    }
    
    public static boolean cadastrar(String nome, String email, String senha, String regiao) {
        
        Conexao conn = new Conexao();
        conn.conectar();
                
        String insert = "INSERT INTO usuario (nome, email, região, senha) " +
            "VALUES ('" + nome  + "', '" + email + "', '"+ regiao + "', '" + senha + "')";
        
        try {
            conn.st.execute(insert);
            
            return true;
        } catch (Exception e) {
            System.out.println("Deu erro " + e.getMessage());
            return false;
        } finally {
            conn.desconectar();
        }       
    }
}
