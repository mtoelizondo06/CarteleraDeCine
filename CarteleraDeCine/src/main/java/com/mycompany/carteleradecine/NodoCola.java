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
    public String nombre;
    public NodoCola siguiente;
    
    public NodoCola(String nombre){
        this.nombre = nombre;
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
    
    public void enqueue(String nombre){
        NodoCola nuevo = new NodoCola(nombre);
        if(atras == null){
            frente = nuevo;
            atras = nuevo;
            return;
        }
        atras.siguiente = nuevo;
        atras = nuevo;
    }
    
    public String dequeue(){
        if(estaVacia()){
            return null;
        }
        String nombre = frente.nombre;
        frente = frente.siguiente;
        
        if(frente == null){
            atras = null;
        }
        return nombre;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public String verFila() {
        if (estaVacia()) return "La fila está vacía.";
        StringBuilder sb = new StringBuilder("══ FILA DE ESPERA ══\n");
        NodoCola actual = frente;
        int i = 1;
        while (actual != null) {
            sb.append(i++).append(". ").append(actual.nombre).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}