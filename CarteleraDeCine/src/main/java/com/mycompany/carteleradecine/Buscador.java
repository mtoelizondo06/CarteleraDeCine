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
    public static void buscarPorNombre(NodoPelicula nodoActual, String nombreBuscar, StringBuilder sb, boolean[] encontrada){
        if(nodoActual == null){
            if(!encontrada[0]){
                sb.append("No se encontro: ").append(nombreBuscar).append("\n");
            }
            return;
        }
        
        Pelicula p = nodoActual.datos;
        if(p.getTitulo().equalsIgnoreCase(nombreBuscar)){
            sb.append("Pelicula: ").append(p.getTitulo()).append("\n");
            sb.append("Director: ").append(p.getDirector()).append("\n");
            sb.append("Clasificacion: ").append(p.getClasificacion()).append("\n");
            sb.append("Genero: ").append(p.getGenero()).append("\n");
            anexarHorarios(p, sb);
            encontrada[0] = true;
        }
        buscarPorNombre(nodoActual.siguiente, nombreBuscar, sb, encontrada);
    }
    
    public static void buscarPorGenero(NodoPelicula nodoActual, String generoBuscar, boolean encontroAlguna, StringBuilder sb){
        if(nodoActual == null){
            if(!encontroAlguna){
                sb.append("No se encontro pelicula del genero: ").append(generoBuscar).append("\n");
            }
            return;
        }
        
        Pelicula p = nodoActual.datos;
        if(p.getGenero().equalsIgnoreCase(generoBuscar)){
            sb.append("Titulo: ").append(p.getTitulo()).append(" | Clasificacion: ").append(p.getClasificacion()).append("\n");
            anexarHorarios(p, sb);
            encontroAlguna = true; 
        }
        buscarPorGenero(nodoActual.siguiente, generoBuscar, encontroAlguna, sb);
    }
    
    // Buscar por clasificación
    public static void buscarPorClasificacion(NodoPelicula nodoActual, String clasifBuscar, boolean encontroAlguna, StringBuilder sb){
        if(nodoActual == null){
            if(!encontroAlguna){
                sb.append("No se encontraron peliculas con clasificacion: ").append(clasifBuscar).append("\n");
            }
            return;
        }
        
        Pelicula p = nodoActual.datos;
        if(p.getClasificacion().equalsIgnoreCase(clasifBuscar)){
            sb.append("Titulo: ").append(p.getTitulo()).append(" | Genero: ").append(p.getGenero()).append("\n");
            anexarHorarios(p, sb);
            encontroAlguna = true;
        }
        buscarPorClasificacion(nodoActual.siguiente, clasifBuscar, encontroAlguna, sb);
    }
    
    private static void anexarHorarios(Pelicula p, StringBuilder sb) {
        if (p.getHorarios() == null || p.getHorarios().tamanio() == 0) {
            sb.append("   [Sin horarios]\n\n");
            return;
        }
        for (int i = 0; i < p.getHorarios().tamanio(); i++) {
            Horario h = p.getHorarios().get(i);
            sb.append("   ▶ Sala: ").append(h.getSala())
              .append(" | ").append(h.getFecha())
              .append(" | ").append(h.getHoraInicio()).append("\n");
        }
        sb.append("\n");
    }
}
