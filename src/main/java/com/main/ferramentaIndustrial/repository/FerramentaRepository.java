/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.ferramentaIndustrial.repository;

import com.main.ferramentaIndustrial.model.FerramentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class FerramentaRepository {
    
    public String criarFerramenta(FerramentaDTO ferramenta){
        try{
           Connection conn = Conexao.conectar();
           PreparedStatement stmt = null;
           stmt = conn.prepareStatement("insert into tb_ferramenta (nome, horas_uso, vidaUtilMaxima) values (?, ?, ?)");
           stmt.setString(1, ferramenta.getNome());
           stmt.setInt(2, ferramenta.getHoras_uso());
           stmt.setInt(3, ferramenta.getVidaUtilMaxima());
           
           int linhasAfetadas = stmt.executeUpdate();
           if (linhasAfetadas == 0){
               throw new SQLException("Falha na atualização, nenhuma linha foi afetada.");
           }
                    
        } catch(SQLException e){
            e.printStackTrace();
        }
        return "Ferramenta Cadastrada";
    }
    
    public List<FerramentaDTO> listarFerramentas(){
     List<FerramentaDTO> list = new ArrayList();
     
     try{
         Connection conn = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conn.prepareStatement("select * from tb_ferramenta");
         rs = stmt.executeQuery();
         
         while(rs.next()){
             FerramentaDTO ferramenta = new FerramentaDTO();
             ferramenta.setId(rs.getLong("id"));
             ferramenta.setNome(rs.getString("nome"));
             ferramenta.setHoras_uso(rs.getInt("horas_uso"));
             ferramenta.setVidaUtilMaxima(rs.getInt("vidaUtilMaxima"));
             list.add(ferramenta);
         }
         
     } catch(SQLException e){
         e.printStackTrace();
       }
     return list;
    }
    
    public String deleteById(Integer id){
        int linhas = 0;
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
                        
            stmt = conn.prepareStatement("delete from tb_ferramenta where id = ?");            
            stmt.setLong(1, id);
            
           int linhasAfetadas = stmt.executeUpdate();
           if (linhasAfetadas == 0){
               throw new SQLException("Falha na atualização, nenhuma linha foi afetada.");
           }
           
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Deletado com sucesso!";
    }
    
    public String AtualizarFerramenta(FerramentaDTO ferramenta){
        try{
           Connection conn = Conexao.conectar();
           PreparedStatement stmt = null;
           
           stmt = conn.prepareStatement("update tb_ferramenta set nome = ?, horas_uso = ?, vidaUtilMaxima = ? where id = ?");
           stmt.setString(1, ferramenta.getNome());
           stmt.setInt(2, ferramenta.getHoras_uso());
           stmt.setInt(3, ferramenta.getVidaUtilMaxima());
           
           int linhasAfetadas = stmt.executeUpdate();
           if (linhasAfetadas == 0){
               throw new SQLException("Falha na atualização, nenhuma linha foi afetada.");
           }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Ferramenta atualizada!";
    }
}
