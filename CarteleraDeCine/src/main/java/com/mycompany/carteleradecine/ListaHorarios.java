/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;
import com.mycompany.carteleradecine.Horario;
/**
 *
 * @author mchav
 */
public class ListaHorarios {
    private NodoHorario cabeza;
    private int tamanio;
    
    public ListaHorarios(){
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public void add(Horario datos){
        NodoHorario nuevo = new NodoHorario(datos);
        if(cabeza == null){
            cabeza = nuevo;
        }else{
            NodoHorario actual = cabeza;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
        }
        tamanio++;
    }
    
    public Horario get(int indice){
        if(indice<0 || indice >= tamanio){
            return null;
        }
        NodoHorario actual = cabeza;
        for(int i = 0; i < indice; i++){
            actual = actual.siguiente;
        }
        return actual.datos;
    }
    
    public int tamanio(){
        return tamanio;
    }
}
