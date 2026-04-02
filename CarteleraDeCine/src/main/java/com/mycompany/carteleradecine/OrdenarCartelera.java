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
public class OrdenarCartelera {
    
    //metodo para ordenar
    public static void ordenar(Pelicula[] arr, int inicio, int fin, boolean ascend){
        if(inicio<fin){
            int pivote = partir(arr,inicio,fin,ascend);
            ordenar(arr,inicio,pivote-1,ascend);
            ordenar(arr,inicio,pivote+1,ascend);
        }
    }
    
    private static int partir(Pelicula[] arr,int inicio, int fin,boolean ascend){
        String pivote = arr[fin].getTitulo();
        int i = (inicio -1);
        
        for(int j=inicio;j<fin;j++){
            boolean condicion;
            if(ascend){
                condicion = arr[j].getTitulo().compareToIgnoreCase(pivote) <= 0;
            }else{
                condicion = arr[j].getTitulo().compareToIgnoreCase(pivote) >= 0;
            }
            
            if(condicion){
                i++;
                Pelicula temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Pelicula temp = arr[i + 1];
        arr[i+1] = arr[fin];
        arr[fin] = temp;
        
        return i+1;
    }
}
