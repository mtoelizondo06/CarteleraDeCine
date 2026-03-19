/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author mchav
 */
public class Horario {
    private int id;
    private LocalDate fechapeli;
    private LocalTime horaInicio;
    private String sala;
    private int duracion;
    
    
    public Horario(int id, LocalDate fechapeli, LocalTime horaInicio, String sala, int duracion){
        this.id = id;
        this.fechapeli = fechapeli;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.duracion = duracion;
    }
    
    public Horario(int id,LocalTime horaInicio, String sala, int duracion){
        this.id = id;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.duracion = duracion;
    }
    
    public LocalTime getHoraFin(){
        return horaInicio.plusMinutes(duracion);
    }
    
    public LocalDate getFecha(){
        return fechapeli;
    }
    
    public String getSala(){
        return sala;
    }
    
    public LocalTime getHoraInicio(){
        return horaInicio;
    }
    
    public int getDuracion(){
        return duracion;
    }
}
