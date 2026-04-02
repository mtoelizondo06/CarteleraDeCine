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
public class NodoCola {
    public Pelicula datos;
    public NodoCola siguiente;
    
    public NodoCola(Pelicula datos){
        this.datos = datos;
        this.siguiente = null;
    }
}

class ColaImpresion{
    private NodoCola frente;
    private NodoCola atras;
    
    public ColaImpresion(){
        this.frente = null;
        this.atras = null;
    }
    
    public void enqueue(Pelicula p){
        NodoCola nuevo = new NodoCola(p);
        if(atras == null){
            frente = nuevo;
            atras = nuevo;
            return;
        }
        atras.siguiente = nuevo;
        atras = nuevo;
    }
    
    public Pelicula dequeue(){
        if(estaVacia()){
            return null;
        }
        Pelicula p = frente.datos;
        frente = frente.siguiente;
        
        if(frente == null){
            atras = null;
        }
        return p;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
}