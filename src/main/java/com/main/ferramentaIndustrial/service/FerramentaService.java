/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.ferramentaIndustrial.service;

import com.main.ferramentaIndustrial.model.FerramentaDTO;
import com.main.ferramentaIndustrial.repository.FerramentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class FerramentaService {
    
    @Autowired
    private FerramentaRepository repository;
    
    public String criarFerramenta(FerramentaDTO ferramenta){
        return repository.criarFerramenta(ferramenta);
    }
    
    public List<FerramentaDTO> listarFerramentas() {
        return repository.listarFerramentas();
    }
   
    public String deleteById(Integer id){
        return repository.deleteById(id);
    }
    
    public void atualizarFerramenta(FerramentaDTO ferramenta){
        repository.AtualizarFerramenta(ferramenta);
    }
}
