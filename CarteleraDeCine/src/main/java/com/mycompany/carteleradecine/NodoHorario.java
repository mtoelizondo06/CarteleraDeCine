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
public class NodoHorario {
    public Horario datos;
    public NodoHorario siguiente;
    
    public NodoHorario(Horario datos){
        this.datos = datos;
        this.siguiente = null;
    }
}
