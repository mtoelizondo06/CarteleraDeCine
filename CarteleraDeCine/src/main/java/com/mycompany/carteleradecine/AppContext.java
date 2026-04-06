/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carteleradecine;

/**
 *
 * @author mchav
 */
public class AppContext {
    
    public static final String ADMIN_EMAIL = "admin@cine.com";
    public static final String ADMIN_PASS  = "admin123";
 
    public static final String CLIENT_EMAIL = "cliente@cine.com";
    public static final String CLIENT_PASS  = "cliente123";
    
    public static String rolActual    = "";   
    public static String emailActual  = "";
    
    public static String idEstado     = "";   // J11, N11, E11, C11, S11
    public static String idMunicipio  = "";   // A..J (según tabla)
    public static String nombreEstado = "";
    public static String nombreMunicipio = "";
    
    public static ListaPeliculas listaPeliculas = new ListaPeliculas();
    public static PilaDeshacer   pilaDeshacer   = new PilaDeshacer();
 
    private AppContext() {}
    
}
