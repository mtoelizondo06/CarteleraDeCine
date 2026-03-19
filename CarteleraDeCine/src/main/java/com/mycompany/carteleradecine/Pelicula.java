/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;

/**
 *
 * @author mchav
 */
public class Pelicula {
    private static final int maxHorarios = 10;
    
    private String titulo;
    private String director;
    private String productor;
    private String clasificacion;
    private int duracionMin;
    private String genero;
    private ListaHorarios horarios;
    
    public Pelicula(String titulo, String director,String productor, String clasificacion, int duracionMin, String genero){
        this.titulo = titulo;
        this.director = director;
        this.productor = productor;
        this.clasificacion = clasificacion;
        this.duracionMin = duracionMin;
        this.genero = genero;
        this.horarios = new ListaHorarios();
    }
    
    /*public boolean agregarHorario(Horario nuevoHorario){
        for(int i=0; i<horarios.tamanio();i++){
            Horario existente = horarios.get(i);
        }
    }*/
}
