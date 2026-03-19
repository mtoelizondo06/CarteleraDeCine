/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;
import com.mycompany.carteleradecine.Pelicula;
/**
 *
 * @author mchav
 */
public class NodoPelicula {
    public Pelicula datos;
    public NodoPelicula siguiente;
    
    public NodoPelicula(Pelicula datos){
        this.datos = datos;
        this.siguiente = null;
    }
}
