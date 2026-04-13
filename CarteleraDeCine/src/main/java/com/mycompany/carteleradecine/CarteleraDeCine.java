
package com.mycompany.carteleradecine;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CarteleraDeCine {

    public static Scanner sc = new Scanner(System.in);
    public static ListaPeliculas listaPeliculas = new ListaPeliculas();
    public static PilaDeshacer pilaDeshacer = new PilaDeshacer();
    
    
    public static void main(String[] args) {
        datosPrueba();
        
        int opcion =-1;
        do{
            System.out.println("--Cartelera de Cine--");
            System.out.println("1.Administrador");
            System.out.println("2.Cliente");
            System.out.println("3.Salir");
            System.out.println("Elige una opcion:");
            try{
                opcion = Integer.parseInt(sc.nextLine().trim());
            }catch(Exception e){
                opcion = -1;
            }
            
            switch(opcion){
                case 1:menuAdministrador();
                    break;
                case 2:menuCliente();
                    break;
                case 3:
                    System.out.println("Saliendo del Sistema");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            
        }while(opcion != 3);
    }
    
    public static void menuAdministrador(){
        int opcion = -1;
        do{
            System.out.println("--Menu Administrador--");
            System.out.println("1. Alta de Pelicula");
            System.out.println("2. Alta de Horario");
            System.out.println("3. Baja de Pelicula");
            System.out.println("4. Baja de Horario");
            System.out.println("5. Modificar Pelicula");
            System.out.println("6. Consultar Pelicula");
            System.out.println("7. Consultar Cartelera");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");
            try{
                opcion = Integer.parseInt(sc.nextLine().trim());
            }catch(Exception e){
                opcion = -1;
            }
            
            switch(opcion){
                case 1:altaPelicula();
                    break;
                case 2:altaHorario();
                    break;
                case 3:bajaPelicula();
                    break;
                case 4:bajaHorario();
                    break;
                case 5:modificarPelicula();
                    break;
                case 6:consultarPeliculaAdmin();
                    break;
                case 7:consultarCartelera();
                    break;
                case 8:
                    System.out.println("Regresando al Menu Principal.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }while(opcion != 8);
    }
    
    public static void menuCliente(){
        int opcion = -1;
        do{
            System.out.println("--Menu Cliente--");
            System.out.println("1. Buscar pelicula por nombre");
            System.out.println("2. Buscar pelicula por clasificacion");
            System.out.println("3. Buscar pelicula por genero");
            System.out.println("4. Ordenar Cartelera (A y D)");
            System.out.println("5. Consultar Pelicula");
            System.out.println("6. Consultar Cartelera");
            System.out.println("7. Ver Cines Cercanos (Rutas)"); 
            System.out.println("8. Salir");                        
            System.out.print("Elige una opcion: ");
            try{
                opcion = Integer.parseInt(sc.nextLine().trim());
            }catch(Exception e){
                opcion = -1;
            }
            
            switch(opcion){
                case 1:buscarPorNombre();
                    break;
                case 2:buscarPorClasificacion();
                    break;
                case 3:buscarPorGenero();
                    break;
                case 4:ordenarCartelera();
                    break;
                case 5:consultarPeliculaAdmin();
                    break;
                case 6:consultarCartelera();
                    break;
                case 7:consultarCineCercano();
                    break;
                case 8:
                    System.out.println("Regresando al Menu principal.");
                    break;
                default:
                    System.out.println("Opcion Invalida.");
            }
        }while(opcion != 8);
    }
    
    //zona administrador
    public static void altaPelicula(){
        String titulo,director,productor,clas,genero;
        System.out.println("--Alta de Pelicula--");
        System.out.println("Titulo: ");
        titulo = sc.nextLine().trim();
        System.out.println("Director: ");
        director = sc.nextLine().trim();
        System.out.println("Productor: ");
        productor = sc.nextLine().trim();
        System.out.println("Clasificacion (AA/A/B/B15/C/D)");
        clas = sc.nextLine().trim();
        
        int duracion = 0;
        System.out.println("Duracion(minutos)");
        try{
            duracion = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        System.out.println("Genero: ");
        genero = sc.nextLine().trim();
        
        Pelicula nueva = new Pelicula(titulo,director,productor,clas,duracion,genero);
        listaPeliculas.add(nueva);
        pilaDeshacer.push(nueva);
        System.out.println("Pelicula Agregada Exitosamente.");
    }
    
    public static void altaHorario(){
        String titulo,strFecha,strHora,sala;
        int id = 0, dur = 0;
        System.out.println("--Alta de Horario--");
        System.out.println("Titulo de la pelicula: ");
        titulo = sc.nextLine().trim();
        Pelicula p = buscaPelicula(titulo);
        if(p == null){
            System.out.println("Pelicula no encontrada.");
            return;
        }
        System.out.println("Id de horario: ");
        try{
            id = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        System.out.println("Fecha (YYYY-MM-DD): ");
        strFecha = sc.nextLine().trim();
        System.out.println("Hora inicio (HH:MM): ");
        strHora = sc.nextLine().trim();
        System.out.println("Sala: ");
        sala = sc.nextLine().trim();
        System.out.println("Duracion (minutos): ");
        try{
            dur = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        
        
        try{
            LocalDate fecha = LocalDate.parse(strFecha);
            LocalTime hora = LocalTime.parse(strHora);
            Horario h = new Horario(id,fecha,hora,sala,dur);
            p.agregarHorario(h);
        }catch(Exception e){
            System.out.println("Formato de Fecha u Hora invalidos.");
        }
    }
    
    public static void bajaPelicula(){
        String titulo;
        System.out.println("--Baja Pelicula--");
        System.out.println("Titulo de la pelicula a eliminar: ");
        titulo = sc.nextLine().trim();
        ListaPeliculas nueva = new ListaPeliculas();
        boolean encontrado = false;
        for(int i=0;i<listaPeliculas.tamanio();i++){
            Pelicula p = listaPeliculas.get(i);
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                encontrado = true;
                System.out.println("Pelicula eliminada: "+p.getTitulo());
            }else{
                nueva.add(p);
            }
        }
        if(!encontrado){
            System.out.println("Pelicula no encontrada.");
        }else{
            listaPeliculas = nueva;
        }
    }
    
    public static void bajaHorario(){
        String titulo;
        int id = -1;
        System.out.println("--Baja Horario--");
        System.out.println("Titulo de la pelicula: ");
        titulo = sc.nextLine().trim();
        Pelicula p = buscaPelicula(titulo);
        if(p == null){
            System.out.println("Pelicula no encontrada.");
            return;
        }
        p.mostrarHorarios();
        System.out.println("Id del horario a eliminar.");
        try{
            id = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        boolean eliminar = p.eliminarHorario(id);
        if(eliminar){
            System.out.println("Horario eliminado.");
        }else{
            System.out.println("No se encontro un horario con ese id.");
        }
    }
    
    public static void modificarPelicula(){
        String titulo;
        String nTitulo,nDirector,nProductor,nClasificacion,nGenero;
        int nDuracion;
        System.out.println("--Modificar Pelicula--");
        System.out.println("Titulo de la pelicula a Modificar: ");
        
        titulo = sc.nextLine().trim();
        Pelicula p = buscaPelicula(titulo);
        if(p == null){
            System.out.println("Pelicula no encontrada.");
            return;
        }
        int opcion = -1;
        do{
            System.out.println("--Que desea Modificar--");
            System.out.println("1. Modificar Titulo ("+ p.getTitulo()+")");
            System.out.println("2. Modificar Director (" + p.getDirector() + ")");
            System.out.println("3. Modificar Productor (" + p.getProductor() + ")");
            System.out.println("4. Modificar Clasificacion (" + p.getClasificacion() + ")");
            System.out.println("5. Modificar Duracion (" + p.getDuracionMin() + " min)");
            System.out.println("6. Modificar Genero (" + p.getGenero() + ")");
            System.out.println("7. Regresar");
            System.out.print("Elige una opcion: ");
            try{
                opcion = Integer.parseInt(sc.nextLine().trim());
            }catch(Exception e){
                opcion = -1;
            }
            switch(opcion){
                case 1:
                    System.out.println("Nuevo titulo: ");
                    nTitulo = sc.nextLine().trim();
                    p.setTitulo(nTitulo);
                    System.out.println("Titulo actualizado.");
                    break;
                case 2:
                    System.out.println("Nuevo Director: ");
                    nDirector = sc.nextLine().trim();
                    p.setDirector(nDirector);
                    System.out.println("Director actualizado.");
                    break;
                case 3:
                    System.out.println("Nuevo Productor: ");
                    nProductor = sc.nextLine().trim();
                    p.setProductor(nProductor);
                    System.out.println("Productor actualizado.");
                    break;
                case 4:
                    System.out.println("Nueva Clasificacion: ");
                    nClasificacion = sc.nextLine().trim();
                    p.setClasificacion(nClasificacion);
                    System.out.println("Clasificacion actualizada.");
                    break;
                case 5:
                    System.out.println("Nueva Duracion(minutos): ");
                    try{
                        nDuracion = Integer.parseInt(sc.nextLine().trim());
                        p.setDuracionMin(nDuracion);
                        System.out.println("Duracion actualizada.");
                    }catch(Exception e){
                        System.out.println("Debes ingresar un numero.");
                    }
                    break;
                case 6:
                    System.out.println("Nuevo Genero: ");
                    nGenero = sc.nextLine().trim();
                    p.setGenero(nGenero);
                    System.out.println("Genero actualizado.");
                    break;
                case 7:
                    System.out.println("saliendo del menu de modificacion.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }while(opcion != 7);
    }
    
    public static void consultarPeliculaAdmin(){
        String titulo;
        System.out.println("--Consultar Pelicula--");
        System.out.println("Titulo: ");
        titulo = sc.nextLine().trim();
        Pelicula p = buscaPelicula(titulo);
        if(p == null){
            System.out.println("Pelicula no encontrada.");
            return;
        }
        System.out.println("Titulo: " + p.getTitulo());
        System.out.println("Director: " + p.getDirector());
        System.out.println("Productor: " + p.getProductor());
        System.out.println("Clasificacion: " + p.getClasificacion());
        System.out.println("Genero: " + p.getGenero());
        System.out.println("Duracion: " + p.getDuracionMin() + " min");
        p.mostrarHorarios();
    }
    
    public static void consultarCartelera(){
        System.out.println("--Cartelera--");
        if(listaPeliculas.tamanio() == 0){
            System.out.println("No hay peliculas en cartelera.");
            return;
        }
        for(int i=0;i<listaPeliculas.tamanio();i++){
            Pelicula p = listaPeliculas.get(i);
            System.out.println((i+1)+". "+p.getTitulo()+" ["+p.getClasificacion()+"] "+p.getGenero());
        }
    }
    
    //zona cliente
    
    public static void buscarPorNombre(){
        String nombre;
        System.out.println("Nombre a buscar: ");
        nombre = sc.nextLine().trim();
        //Buscador.buscarPorNombre(getPrimerNodo(), nombre);
    }
    
    public static void buscarPorClasificacion(){
        String clasi;
        System.out.println("Clasificacion por buscar (AA/A/B/B15/C/D): ");
        clasi = sc.nextLine().trim();
        //Buscador.buscarPorClasificacion(getPrimerNodo(), clasi, false);
    }
    
    public static void buscarPorGenero(){
        String gen;
        System.out.println("Genero a buscar: ");
        gen = sc.nextLine().trim();
        //Buscador.buscarPorGenero(getPrimerNodo(), gen, false);
    }
    
    public static void ordenarCartelera(){
        System.out.println("--ordenar cartelera--");
        System.out.println("1.Ascendente\n2.Descendente");
        System.out.println("Opcion: ");
        int opcion = -1;
        try{
            opcion = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        boolean asc = (opcion == 1);
        
        int n = listaPeliculas.tamanio();
        Pelicula[] arr = new Pelicula[n];
        for(int i=0; i<n;i++){
            arr[i] = listaPeliculas.get(i);
        }
        OrdenarCartelera.ordenar(arr,0,n-1, asc);
        System.out.println("\n--cartelera ordenada "+ (asc ? "A-Z" : "Z-A")+" --");
        for(Pelicula p : arr){
            System.out.println(" "+p.getTitulo());
        }
        listaPeliculas = new ListaPeliculas();
        for(Pelicula p : arr){
            listaPeliculas.add(p);
        }
    }
    
    public static void consultarCineCercano(){
        System.out.println("--Consultar Cines Cercanos--");
        System.out.println("En que estado te encuentras.");
        System.out.println("1. Jalisco");
        System.out.println("2. Nuevo Leon");
        System.out.println("3. Estado de Mexico");
        System.out.println("4. Chihuahua");
        System.out.println("5. Sinaloa");
        System.out.print("Elige una opcion: ");
        
        int opcion = -1;
        try{
            opcion = Integer.parseInt(sc.nextLine().trim());
        }catch(Exception e){}
        
        int[][] matrizSeleccionada = null;
        String[] nombresSeleccionados = null;
        
        switch(opcion){
            case 1:
                matrizSeleccionada = Rutas.distJalisco;
                nombresSeleccionados = Rutas.JALISCO;
                break;
            case 2:
                matrizSeleccionada = Rutas.distNuevoLeon;
                nombresSeleccionados = Rutas.NUEVO_LEON;
                break;
            case 3:
                matrizSeleccionada = Rutas.distEdomex;
                nombresSeleccionados = Rutas.EDOMEX;
                break;
            case 4:
                matrizSeleccionada = Rutas.distChihuahua;
                nombresSeleccionados = Rutas.CHIHUAHUA;
                break;
            case 5:
                matrizSeleccionada = Rutas.distSinaloa;
                nombresSeleccionados = Rutas.SINALOA;
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }
        FloydCines fw = new FloydCines(matrizSeleccionada);
        fw.calcularRuta();
        
        System.out.println("--Municipios Disponibles--");
        for(int i=0;i<nombresSeleccionados.length;i++){
            System.out.println(i+".-"+nombresSeleccionados[i]);
        }
        try{
            System.out.println("Ingresa el numero de tu municipio actual: ");
            int origen = Integer.parseInt(sc.nextLine().trim());
            System.out.println("ingresa el numero del municipio que quieres ir: ");
            int destino = Integer.parseInt(sc.nextLine().trim());
            
            if(origen < 0 || origen >= nombresSeleccionados.length || destino < 0 || destino >= nombresSeleccionados.length){
                System.out.println("Numero de municipio invalido.");
                return;
            }
            fw.calcularDistancia(origen, destino, nombresSeleccionados);
        }catch(Exception e){
            System.out.println("Entrada invalida.");
        }
    }
    
    //utilidades
    public static Pelicula buscaPelicula(String titulo){
        for(int i=0;i<listaPeliculas.tamanio();i++){
            Pelicula p = listaPeliculas.get(i);
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                return p;
            }
        }
        return null;
    }
    
    public static NodoPelicula getPrimerNodo(){
        NodoPelicula cabeza = null;
        NodoPelicula ultimo = null;
        for(int i=0;i<listaPeliculas.tamanio();i++){
            NodoPelicula nuevo = new NodoPelicula(listaPeliculas.get(i));
            if(cabeza == null){
                cabeza = nuevo;
                ultimo = nuevo;
            }else{
                ultimo.siguiente = nuevo; 
                ultimo = nuevo;
            }
        }
        return cabeza;
    }
    
    public static void datosPrueba(){
        Pelicula p1 = new Pelicula("El Rey Leon", "Roger Allers", "Don Hahn", "AA", 88, "Animacion");
        Pelicula p2 = new Pelicula("Avengers Endgame", "Russo Bros", "Marvel Studios", "B", 181, "Accion");
        Pelicula p3 = new Pelicula("Barbie", "Greta Gerwig", "Robbie Brenner", "A", 114, "Comedia");
        Pelicula p4 = new Pelicula("Dune Parte 2", "Denis Villeneuve", "Legendary", "B15", 167, "Ciencia Ficcion");
 
        p1.agregarHorario(new Horario(1, LocalDate.of(2026,4,5), LocalTime.of(10,0), "Sala 1", 88));
        p1.agregarHorario(new Horario(2, LocalDate.of(2026,4,5), LocalTime.of(14,0), "Sala 2", 88));
        p2.agregarHorario(new Horario(3, LocalDate.of(2026,4,5), LocalTime.of(16,0), "Sala 3", 181));
        p3.agregarHorario(new Horario(4, LocalDate.of(2026,4,6), LocalTime.of(12,0), "Sala 1", 114));
        p4.agregarHorario(new Horario(5, LocalDate.of(2026,4,6), LocalTime.of(18,0), "Sala 4", 167));
 
        listaPeliculas.add(p1);
        listaPeliculas.add(p2);
        listaPeliculas.add(p3);
        listaPeliculas.add(p4);
    }
}
