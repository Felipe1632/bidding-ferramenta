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
    public Long id;
    public String nome;
    public int horas_uso;
    public int vidaUtilMaxima;
    public Double percentualDesgaste;
    
    public FerramentaDTO() {
    }

    public FerramentaDTO(Long id, String nome, int horas_uso, int vidaUtilMaxima) {
        this.id = id;
        this.nome = nome;
        this.horas_uso = horas_uso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras_uso() {
        return horas_uso;
    }

    public void setHoras_uso(int horas_uso) {
        this.horas_uso = horas_uso;
    }

    public int getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(int vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }
    
    public double getPercentualDesgaste(){
        return horas_uso / vidaUtilMaxima * 100;
    }
}
