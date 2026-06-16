/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.ferramentaIndustrial.model;

/**
 *
 * @author Aluno
 */
public class FerramentaDTO {
    public Integer id;
    public String nome;
    public Integer horas_uso;
    public Integer vidaUtilMaxima;
    public Double percentualDesgaste;
    
    public FerramentaDTO() {
    }

    public FerramentaDTO(Integer id, String nome, Integer horas_uso, Integer vidaUtilMaxima) {
        this.id = id;
        this.nome = nome;
        this.horas_uso = horas_uso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHoras_uso() {
        return horas_uso;
    }

    public void setHoras_uso(Integer horas_uso) {
        this.horas_uso = horas_uso;
    }

    public Integer getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(Integer vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }
    
    public double getPercentualDesgaste(){
        return horas_uso / vidaUtilMaxima * 100;
    }
}
