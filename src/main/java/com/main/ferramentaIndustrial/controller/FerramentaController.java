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
import org.springframework.web.bind.annotation.ModelAttribute;
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
       
    @GetMapping("/listar")
    public String listarFerramentas(Model model){
    List<FerramentaDTO> ferramentas = service.listarFerramentas();
    model.addAttribute("ferramentas", ferramentas);
    model.addAttribute("ferramenta", new FerramentaDTO());
    model.addAttribute("ferramentaAtualizar", new FerramentaDTO());
    model.addAttribute("modoAtualizar", false);
    return "listar";
}

    @PostMapping("/cadastrar")
    public String criarFerramenta(@ModelAttribute FerramentaDTO ferramenta){
    service.criarFerramenta(ferramenta);
    return "redirect:/ferramentas/listar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirFerramenta(@PathVariable int id){
    service.deleteById(id);
    return "redirect:/ferramentas/listar";
}   
    //ERRO
    @GetMapping("/atualizar/{id}")
    public String abrirAtualizacao(@PathVariable int id, Model model){

    FerramentaDTO ferramenta = service.atualizarFerramenta(id);

    model.addAttribute("ferramentaAtualizar", ferramenta);
    model.addAttribute("modoAtualizar", true);

    return "listar";
}
    
    @PutMapping("/atualizar/{id}")
    public String atualizarFerramenta(FerramentaDTO ferramenta){
        service.atualizarFerramenta(ferramenta);
        return "redirect:/listar";
    }
}
