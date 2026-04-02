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
public class NodoPila {
    public Pelicula datos;
    public NodoPila siguiente;
    
    public NodoPila(Pelicula datos){
        this.datos = datos;
        this.siguiente = null;
    }
}

class PilaDeshacer{
    private NodoPila tope;
    
    public PilaDeshacer(){
        this.tope = null;
    }
    
    public void push(Pelicula p){
        NodoPila nuevo = new NodoPila(p);
        nuevo.siguiente = tope;
        tope = nuevo;
    }
    
    public Pelicula pop(){
        if(estaVacia()){
            return null;
        }
        Pelicula p = tope.datos;
        tope = tope.siguiente;
        return p;        
    }
    
    public boolean estaVacia(){
        return tope == null;
    }
}
