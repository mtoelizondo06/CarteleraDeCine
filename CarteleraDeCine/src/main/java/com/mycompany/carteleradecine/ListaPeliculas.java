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
public class ListaPeliculas {
    private NodoPelicula cabeza;
    private int tamanio;
    
    public ListaPeliculas(){
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public void add(Pelicula datos){
        NodoPelicula nuevo = new NodoPelicula(datos);
        if(cabeza == null){
            cabeza = nuevo;
        }else{
            NodoPelicula actual = cabeza;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }
    
    public Pelicula get(int indice){
        if(indice < 0 || indice >= tamanio){
            return null;
        }
        NodoPelicula actual = cabeza;
        for(int i=0; i<indice; i++){
            actual = actual.siguiente;
        }
        return actual.datos;
    }
    
    public int tamanio(){
        return tamanio;
    }
}
