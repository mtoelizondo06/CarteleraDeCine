/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;

/**
 *
 * @author mchav
 */
public class FloydCines {
    final static int INF = 9999999;
    
    private int [][] mtrizDistancias;
    private int numNodos;
    
    public FloydCines(int[][] grafoOrig){
        this.numNodos = grafoOrig.length;
        this.mtrizDistancias = new int[numNodos][numNodos];
        
        for(int i=0; i<numNodos;i++){
            for(int j=0;j<numNodos;j++){
                mtrizDistancias[i][j] = grafoOrig[i][j];
            }
        }
    }
    
    public void calcularRuta(){
        for(int k=0; k<numNodos;k++){
            for(int i=0; i<numNodos;i++){
                for(int j=0; j<numNodos;j++){
                    if(mtrizDistancias[i][k] + mtrizDistancias[k][j] < mtrizDistancias[i][j]){
                        mtrizDistancias[i][j] = mtrizDistancias[i][k] + mtrizDistancias[k][j];
                    }
                }
            }
        }
    }
    
    public void calcularDistancia(int origen, int destino, String[] nombreMunicipios){
        if(mtrizDistancias[origen][destino] == INF){
            System.out.println("No hay rutas disponibles entre "+nombreMunicipios[origen]+" y "+nombreMunicipios[destino]);
        }else{
            System.out.println("La distancia minima de "+nombreMunicipios[origen]+" a "+nombreMunicipios[destino]+" es de "+mtrizDistancias[origen][destino]+" km.");
        }
    }
    
    public int getDistancia(int origen, int destino) {
        return mtrizDistancias[origen][destino];
    }
}
