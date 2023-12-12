/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDplantei;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import portalPlantei.MinhaPlantaVO;

/**
 *
 * @author User
 */
public class MinhaPlantaDAO extends Conexao {
    
    public List<MinhaPlantaVO> listar() {
        
       super.conectar();
       
       String query = "Select * from minha_planta";
       
       try{
            ResultSet rs = super.st.executeQuery(query);
            List<MinhaPlantaVO> lista = new ArrayList<>();
                        
            while (rs.next()) {
         
                MinhaPlantaVO  planta = new MinhaPlantaVO();
                
                planta.setId(rs.getInt("id"));
                planta.setApelido(rs.getString("apelido"));
                planta.setDataPlantio(rs.getString("data_plantio"));
                planta.setLugar(rs.getString("lugar"));
                planta.setId(rs.getInt("id"));
                lista.add(planta);
            }
            
            return lista;
           
       }catch(SQLException e) {
            System.out.println("Deu erro " + e.getMessage());
            return null;
        } finally {
            super.desconectar();
        }
    }
    
    public static boolean cadastrar(int catalogo_id, String apelido, String data_plantio, String lugar) {
        
        Conexao conexao = new Conexao();
        conexao.conectar();
        
        String query = 
            "INSERT INTO minha_planta (catalogo_id, apelido, data_plantio, lugar) VALUES (?, ?, ?, ?)";
        
        try {
            
            PreparedStatement preparedStmt = conexao.conn.prepareStatement(query);
            preparedStmt.setInt(1, catalogo_id);
            preparedStmt.setString(2, apelido);
            preparedStmt.setString(3, data_plantio);
            preparedStmt.setString(4, lugar);

            preparedStmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Deu erro " + e.getMessage());
            return false;
        } finally {
            conexao.desconectar();
        }       
    }
}
