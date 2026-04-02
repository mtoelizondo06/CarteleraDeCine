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
public class Buscador {
    
    //por nombre
    public static void buscarPorNombre(NodoPelicula nodoActual, String nombreBuscar){
        if(nodoActual == null){
            return;
        }
        Pelicula p = nodoActual.datos;
        if(p.getTitulo().equalsIgnoreCase(nombreBuscar)){
            System.out.println("Pelicula: " +p.getTitulo());
            System.out.println("Director: "+p.getDirector());
            System.out.println("Clasificacion: "+p.getClasificacion());
            System.out.println("Genero: "+p.getGenero());
            p.mostrarHorarios();
        }
        buscarPorNombre(nodoActual.siguiente,nombreBuscar);
    }
    
    public static void buscarPorGenero(NodoPelicula nodoActual, String generoBuscar, boolean encontroAlguna){
        if(nodoActual == null){
            if(!encontroAlguna){
                System.out.println("No se encontro pelicula del genero: "+generoBuscar);
            }
            return;
        }
        
        Pelicula p = nodoActual.datos;
        if(p.getGenero().equalsIgnoreCase(generoBuscar)){
            System.out.println("Titulo: "+p.getTitulo()+" Clasificacion: "+p.getClasificacion());
            p.mostrarHorarios();
            encontroAlguna = true; 
        }
        buscarPorGenero(nodoActual.siguiente,generoBuscar,encontroAlguna);
    }
    
    public static void buscarPorClasificacion(NodoPelicula nodoActual, String clasifBuscar, boolean encontroAlguna){
        if(nodoActual == null){
            if(!encontroAlguna){
                System.out.println("No se encontraron peliculas con clasificacion: "+clasifBuscar);
            }
            return;
        }
        
        Pelicula p = nodoActual.datos;
        if(p.getClasificacion().equalsIgnoreCase(clasifBuscar)){
            System.out.println("Titulo: "+p.getTitulo()+" Genero: "+p.getGenero());
            p.mostrarHorarios();
            encontroAlguna = true;
        }
        buscarPorClasificacion(nodoActual.siguiente,clasifBuscar,encontroAlguna);
    }
}
