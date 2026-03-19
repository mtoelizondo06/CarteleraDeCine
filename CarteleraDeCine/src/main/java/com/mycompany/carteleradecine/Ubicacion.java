/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;


public class Ubicacion {
    private int idEstado;
    private int idMunicipio;
    private String estado;
    private String municipio;
    
    public Ubicacion(int idEstado, int idMunicipio, String estado, String municipio){
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.estado = estado;
        this.municipio = municipio;
    }
    
    
    public int getIdEstado(){
        return idEstado;
    }
    
    public String getMunicipio(){
        return municipio;
    }
    
    public int getIdMunicipio(){
        return idMunicipio;
    }
    
    public String getEstado(){
        return estado;
    }
    
    
    @Override
    public String toString(){
        return estado + " - " + municipio;
    }
}
