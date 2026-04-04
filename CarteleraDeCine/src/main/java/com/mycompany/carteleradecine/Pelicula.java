/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;
import java.time.LocalTime;
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
    
    
    
    public void mostrarHorarios(){
        System.out.println("--Horarios--");
        if(this.horarios.tamanio()==0){
            System.out.println("No existen horarios para esta pelicula");
            return;
        }
        for(int i=0; i<this.horarios.tamanio();i++){
            Horario h = this.horarios.get(i);
            System.out.println("Sala: "+h.getSala()+" Fecha: "+h.getFecha()+" Hora: "+h.getHoraInicio()+" Duracion: "+h.getDuracion());
        }
        System.out.println("------------------");
    }
    
    public boolean agregarHorario(Horario nuevoHorario){
        for(int i=0; i<horarios.tamanio();i++){
            Horario existente = horarios.get(i);
            
            if(existente.getSala().equals(nuevoHorario.getSala())&&
               existente.getFecha().equals(nuevoHorario.getFecha())){
                
                
                LocalTime inicioExistente = existente.getHoraInicio();
                LocalTime finExistente = existente.getHoraFin().plusMinutes(30);
                LocalTime nuevoInicio = nuevoHorario.getHoraInicio();
                LocalTime nuevoFin = nuevoHorario.getHoraFin().plusMinutes(30);
                
                if(nuevoInicio.isBefore(finExistente) && nuevoFin.isAfter(inicioExistente)){
                    System.out.println("Error: Emplame en sala "+existente.getSala());
                    return false;
                }
            }
        }
        if(horarios.tamanio() >= 10){
            System.out.println("Error: maximo 10 horarios permitidos por pelicula");
            return false;
        }
        
        horarios.add(nuevoHorario);
        System.out.println("Horario agregado");
        return true;
    }
    
    public boolean eliminarHorario(int id){
        ListaHorarios nuevo = new ListaHorarios();
        boolean encontrado = false;
        for(int i=0; i<horarios.tamanio();i++){
            Horario h = horarios.get(i);
            if(h.getId()==id){
                encontrado = true;
            }else{
                nuevo.add(h);
            }
        }
        if(encontrado){
            horarios = nuevo;
        }
        return encontrado;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getDirector(){
        return director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public String getProductor(){
        return productor;
    }
    
    public void setProductor(String productor){
        this.productor = productor;
    }
    
    public String getClasificacion(){
        return clasificacion;
    }
    
    public void setClasificacion(String clasificacion){
        this.clasificacion = clasificacion;
    }
    
    public int getDuracionMin(){
        return duracionMin;
    }
    
    public void setDuracionMin(int duracionMin){
        this.duracionMin = duracionMin;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
}
