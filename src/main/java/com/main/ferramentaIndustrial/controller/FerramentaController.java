/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.ferramentaIndustrial.controller;

import ch.qos.logback.core.model.Model;
import com.main.ferramentaIndustrial.model.FerramentaDTO;
import com.main.ferramentaIndustrial.repository.FerramentaRepository;
import com.main.ferramentaIndustrial.service.FerramentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("ferramentas")
public class FerramentaController {
    
    @Autowired
    private FerramentaService service;
    
    @Autowired
    private FerramentaRepository repository;
    
    
    @PostMapping("/cadastrar")
    public String criarFerramenta(FerramentaDTO ferramenta){
    service.criarFerramenta(ferramenta);
    return "redirect:/listar";
    }
    
    @GetMapping("/listar")
    public String listarFerramentas(Model model){
    service.listarFerramentas();
    return "listar";
    }
    
    @DeleteMapping("/deletar")
    public String deleteById(Integer id){
        service.deleteById(id);
        return "redirect:/listar";
    }
    
    @PutMapping("/atualizar")
    public String atualizarFerramenta(FerramentaDTO ferramenta){
        service.atualizarFerramenta(ferramenta);
        return "redirect:/listar";
    }
}
