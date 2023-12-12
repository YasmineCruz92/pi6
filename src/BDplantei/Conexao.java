/**
 *
 * @author Yasmine
 */
package BDplantei;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/plantei"; //Nome da base de dados
    private final String user = "root"; //nome do usuário do MySQL
    private final String password = "75459123"; //senha do MySQL
    Statement st;
    
    
    public Statement conectar(){
        
        try {
                        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
            
            st = conn.createStatement();
            
            return st;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco" +" "+ ex.getMessage());
            return null;
        }
    }
    
    public void desconectar(){
        try {
            conn.close();
            System.out.println("Conexão fechada");
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexão." +" "+ ex.getMessage());
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}