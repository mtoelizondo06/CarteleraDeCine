/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;
import com.mycompany.carteleradecine.FloydCines;
/**
 *
 * @author mchav
 */
public class Rutas {
    public static final String[] JALISCO ={"Guadalajara", "Zapopan", "Tlaquepaque", "Tonalá", "Zapotlanejo","Tlajomulco","Ayotlan","Tequila","Ocotlan","Puerto Vallarta"};
    public static final String[] NUEVO_LEON = {"Guadalupe", "Abasolo", "Apodaca", "Ciénega de Flores", "General Zaragoza","Iturbide","Juarez","Monterrey","Salinas Victoria","General Zuazua"};
    public static final String[] EDOMEX = {"Cuautitlán Izcalli", "Chalco", "Aculco", "Atizapán", "Chapultepec","Ecatepec de Morelos","Naucalpan de Juarez","Morelos","Texcoco","Toluca"};
    public static final String[] CHIHUAHUA = {"Ignacio Zaragoza", "Allende", "Valle de Zaragoza", "Rosario", "Nonoava","Matamoros","Guadalupe y Calvo","Coronado","Delicias","Galeana"};
    public static final String[] SINALOA = {"Guasave", "Navolato", "Cosalá", "Angostura", "Mocorito"};
    
    public static final int INF = 9999999;
    
    public static final int[][] distJalisco = {
        {  0,  12,  15,  20,  35,  25, INF,  55, INF, 300}, // Guadalajara
        { 12,   0,  18, INF,  40,  22, INF,  45, INF, 280}, // Zapopan
        { 15,  18,   0,  10, INF,  15, INF, INF,  80, INF}, // Tlaquepaque
        { 20, INF,  10,   0,  25, INF,  90, INF,  75, INF}, // Tonalá
        { 35,  40, INF,  25,   0, INF,  60, INF,  50, INF}, // Zapotlanejo
        { 25,  22,  15, INF, INF,   0, INF,  70, INF, 310}, // Tlajomulco
        {INF, INF, INF,  90,  60, INF,   0, INF,  40, INF}, // Ayotlán
        { 55,  45, INF, INF, INF,  70, INF,   0, INF, 250}, // Tequila
        {INF, INF,  80,  75,  50, INF,  40, INF,   0, INF}, // Ocotlán
        {300, 280, INF, INF, INF, 310, INF, 250, INF,   0}  // Puerto Vallarta
    };
    
    public static int[][] distNuevoLeon = {
        {  0,  35,  15, INF, INF, INF,  10,  12, INF, INF}, // Guadalupe
        { 35,   0,  40,  20, 250, INF, INF,  45, INF, INF}, // Abasolo
        { 15,  40,   0,  25, INF, INF,  20,  22,  30,  18}, // Apodaca
        {INF,  20,  25,   0, INF, INF, INF,  40,  15,  12}, // Ciénega de Flores
        {INF, 250, INF, INF,   0,  60, INF, 300, INF, INF}, // General Zaragoza
        {INF, INF, INF, INF,  60,   0, INF, 220, INF, INF}, // Iturbide
        { 10, INF,  20, INF, INF, INF,   0,  25, INF, INF}, // Juárez
        { 12,  45,  22,  40, 300, 220,  25,   0,  35,  40}, // Monterrey
        {INF, INF,  30,  15, INF, INF, INF,  35,   0,  20}, // Salinas Victoria
        {INF, INF,  18,  12, INF, INF, INF,  40,  20,   0}  // General Zuazua
    };
    
    public static int[][] distEdomex = {
        {  0, INF,  90,  15, INF,  25,  20, INF, INF,  70}, // Cuautitlán Izcalli
        {INF,   0, INF, INF,  40,  45, INF, INF,  30,  85}, // Chalco
        { 90, INF,   0,  80, INF, INF, INF,  60, INF, 110}, // Aculco
        { 15, INF,  80,   0, INF,  30,  12, INF, INF,  60}, // Atizapán
        {INF,  40, INF, INF,   0, INF, INF, INF, INF,  25}, // Chapultepec
        { 25,  45, INF,  30, INF,   0,  35, INF,  25,  80}, // Ecatepec de Morelos
        { 20, INF, INF,  12, INF,  35,   0, INF, INF,  55}, // Naucalpan de Juárez
        {INF, INF,  60, INF, INF, INF, INF,   0, INF,  90}, // Morelos
        {INF,  30, INF, INF, INF,  25, INF, INF,   0,  95}, // Texcoco
        { 70,  85, 110,  60,  25,  80,  55,  90,  95,   0}  // Toluca
    };
    
    public static int[][] distChihuahua = {
        {  0, INF, INF, INF, INF, INF, INF, INF, INF, 120}, // Ignacio Zaragoza
        {INF,   0,  60, 150, INF,  30, INF,  40,  90, INF}, // Allende
        {INF,  60,   0,  90, 110, INF, INF, INF,  70, INF}, // Valle de Zaragoza
        {INF, 150,  90,   0, INF, INF, INF, INF, INF, INF}, // Rosario
        {INF, INF, 110, INF,   0, INF, 200, INF, INF, INF}, // Nonoava
        {INF,  30, INF, INF, INF,   0, INF,  25, 120, INF}, // Matamoros
        {INF, INF, INF, INF, 200, INF,   0, INF, INF, INF}, // Guadalupe y Calvo
        {INF,  40, INF, INF, INF,  25, INF,   0, 140, INF}, // Coronado
        {INF,  90,  70, INF, INF, 120, INF, 140,   0, INF}, // Delicias
        {120, INF, INF, INF, INF, INF, INF, INF, INF,   0}  // Galeana  
    };
    
    public static int[][] distSinaloa = {
        {  0, 130, INF,  45, INF}, // Guasave
        {130,   0, 140, INF, 110}, // Navolato
        {INF, 140,   0, INF, INF}, // Cosalá
        { 45, INF, INF,   0,  25}, // Angostura
        {INF, 110, INF,  25,   0}  // Mocorito  
    };
}
