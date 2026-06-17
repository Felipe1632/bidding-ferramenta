/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.ferramentaIndustrial.controller;

import com.main.ferramentaIndustrial.model.FerramentaDTO;
import com.main.ferramentaIndustrial.repository.FerramentaRepository;
import com.main.ferramentaIndustrial.service.FerramentaService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Aluno
 */
@Controller
@RequestMapping("ferramentas")
public class FerramentaController {
    
    @Autowired
    private FerramentaService service;
    
    @Autowired
    private FerramentaRepository repository;
       
    @PostMapping("/cadastrar")
    public String criarFerramenta(@RequestBody FerramentaDTO ferramenta){
        service.criarFerramenta(ferramenta);
        return "listar";
    }
    
    @GetMapping("/listar")
    public String listarFerramentas(Model model){
    List<FerramentaDTO> ferramentas = service.listarFerramentas();
    model.addAttribute("ferramentas", ferramentas );
    return "listar";
    }
    
    @DeleteMapping("/deletar/{id}")
    public String deleteById(@PathVariable int id){
        service.deleteById(id);
        return "listar";
    }
    
    @PutMapping("/atualizar")
    public String atualizarFerramenta(FerramentaDTO ferramenta){
        service.atualizarFerramenta(ferramenta);
        return "redirect:/listar";
    }
}
