
package com.mycompany.carteleradecine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClienteFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteFrame.class.getName());
    private static final Color AZUL_OSCURO = new Color(13, 27, 62);
    private static final Color AZUL_MEDIO  = new Color(26, 54, 124);
    private static final Color DORADO      = new Color(212, 175, 55);
    private static final Color BLANCO      = Color.WHITE;
    private JTextArea areaResultados;
    
    
    public ClienteFrame() {
        initUI();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ClienteFrame().setVisible(true));
        
    }

    private void initUI() {
        setTitle("Cliente — " + AppContext.nombreEstado + ", " + AppContext.nombreMunicipio);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
 
        // barra lateral
        JPanel sidebar = new JPanel(new GridBagLayout()) {
            @Override protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0,0,AZUL_OSCURO,0,getHeight(),AZUL_MEDIO);
                g2.setPaint(gp); g2.fillRect(0,0,getWidth(),getHeight());
            }
        };
        sidebar.setPreferredSize(new Dimension(220, 600));
 
        GridBagConstraints s = new GridBagConstraints();
        s.gridx = 0; s.fill = GridBagConstraints.HORIZONTAL; s.weightx = 1.0;
 
        JLabel lblTitulo = new JLabel("Cliente");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTitulo.setForeground(DORADO);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        s.gridy = 0; s.insets = new Insets(20,10,4,10);
        sidebar.add(lblTitulo, s);
 
        JLabel lblUbic = new JLabel("<html><center><font size='2' color='#aabbcc'>"
            + AppContext.idEstado + " — " + AppContext.idMunicipio + "<br>"
            + AppContext.nombreMunicipio + "</font></center></html>");
        lblUbic.setHorizontalAlignment(SwingConstants.CENTER);
        s.gridy = 1; s.insets = new Insets(0,10,16,10);
        sidebar.add(lblUbic, s);
 
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(60, 90, 150));
        s.gridy = 2; s.insets = new Insets(0,10,8,10);
        sidebar.add(sep, s);
 
        String[] opciones = {
            "1. Buscar por nombre","2. Buscar por clasificación",
            "3. Buscar por género","4. Ordenar Cartelera (A/D)",
            "5. Consultar Película","6. Consultar Cartelera",
            "7. Cines Cercanos (Rutas)", "8. Fila de Boletos"
        };
        ActionListener[] acciones = {
            e -> buscarNombre(), e -> buscarClasificacion(),
            e -> buscarGenero(), e -> ordenarCartelera(),
            e -> consultarPelicula(), e -> consultarCartelera(),
            e -> cineCercano(), e-> simularFilaBoletos()
        };
 
        for (int i = 0; i < opciones.length; i++) {
            JButton btn = crearBotonMenu(opciones[i]);
            btn.addActionListener(acciones[i]);
            s.gridy = 3 + i; s.insets = new Insets(3,10,3,10);
            sidebar.add(btn, s);
        }
 
        JButton btnSalir = crearBotonMenu("Cerrar Sesión");
        btnSalir.setForeground(new Color(255,160,160));
        btnSalir.addActionListener(e -> { new LoginFrame().setVisible(true); dispose(); });
        s.gridy = 3 + opciones.length + 1; s.insets = new Insets(20,10,10,10);
        sidebar.add(btnSalir, s);
 
        JPanel relleno = new JPanel(); relleno.setOpaque(false);
        s.gridy = 99; s.weighty = 1.0;
        sidebar.add(relleno, s);
 
        // --Panel resultados
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBackground(new Color(248,250,255));
 
        JLabel lblArea = new JLabel("  Resultados / Búsquedas");
        lblArea.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblArea.setForeground(AZUL_OSCURO);
        lblArea.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(200,210,230)));
        lblArea.setPreferredSize(new Dimension(0,36));
        panelResultados.add(lblArea, BorderLayout.NORTH);
 
        areaResultados = new JTextArea();
        areaResultados.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaResultados.setEditable(false);
        areaResultados.setBackground(new Color(248,250,255));
        areaResultados.setForeground(new Color(30,40,60));
        areaResultados.setMargin(new Insets(12,14,12,14));
        areaResultados.setText("Bienvenido al panel de Cliente.\n"
            + "Estado: " + AppContext.nombreEstado + " (" + AppContext.idEstado + ")\n"
            + "Municipio: " + AppContext.nombreMunicipio + " (" + AppContext.idMunicipio + ")\n\n"
            + "Selecciona una opción del menú izquierdo.");
 
        JScrollPane scroll = new JScrollPane(areaResultados);
        scroll.setBorder(null);
        panelResultados.add(scroll, BorderLayout.CENTER);
 
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panelResultados);
        split.setDividerLocation(220); split.setDividerSize(0); split.setBorder(null);
        setContentPane(split);
    }
 
    //--Operaciones
 
    private Pelicula buscarPeliculaGlobal(String titulo) {
        for (int i = 0; i < AppContext.listaPeliculas.tamanio(); i++) {
            Pelicula p = AppContext.listaPeliculas.get(i);
            if (p.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return p;
            }
        }
        return null;
    }
    
    private NodoPelicula getPrimerNodo() {
        NodoPelicula cabeza = null;
        NodoPelicula ultimo = null;
        for (int i = 0; i < AppContext.listaPeliculas.tamanio(); i++) {
            NodoPelicula nuevo = new NodoPelicula(AppContext.listaPeliculas.get(i));
            if (cabeza == null) { 
                cabeza = nuevo; 
                ultimo = nuevo; 
            } else { 
                ultimo.siguiente = nuevo; 
                ultimo = nuevo; 
            }
        }
        return cabeza;
    }
    
    private void buscarNombre() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre de la película:");
        if (nombre == null || nombre.trim().isEmpty()) return;
        
        StringBuilder sb = new StringBuilder();
        boolean[] encontrada = {false}; 
        
       
        Buscador.buscarPorNombre(getPrimerNodo(), nombre.trim(), sb, encontrada);
        mostrar(sb.toString());
    }
 
    private ColaImpresion filaBoletos = new ColaImpresion();

    private void simularFilaBoletos() {
        String[] menuCola = {"1. Formarse", "2. Atender", "3. Ver Fila"};
        String op = (String) JOptionPane.showInputDialog(this, "Taquilla", "Fila de Boletos",
            JOptionPane.PLAIN_MESSAGE, null, menuCola, menuCola[0]);
            
        if (op == null) return;

        if (op.startsWith("1")) {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del cliente:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                filaBoletos.enqueue(nombre.trim()); 
                mostrar(nombre.trim() + " se ha formado en la fila.");
            }
        } else if (op.startsWith("2")) {
            if (filaBoletos.estaVacia()) {
                mostrar("La fila está vacía. No hay clientes por atender.");
            } else {
                String atendido = filaBoletos.dequeue(); 
                mostrar(" Atendiendo en taquilla a: " + atendido);
            }
        } else {
            mostrar(filaBoletos.verFila()); 
        }
    }
    
    private void buscarClasificacion() {
        String[] opts = {"AA","A","B","B15","C","D"};
        String clasif = (String) JOptionPane.showInputDialog(this, "Clasificación:", "Buscar",
            JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
        if (clasif == null) return;
        
        StringBuilder sb = new StringBuilder("Resultados de clasificación " + clasif + ":\n\n");
        
        // ¡Usamos TU clase Buscador!
        Buscador.buscarPorClasificacion(getPrimerNodo(), clasif, false, sb);
        mostrar(sb.toString());
    }
 
    private void buscarGenero() {
        String genero = JOptionPane.showInputDialog(this, "Género a buscar:");
        if (genero == null || genero.trim().isEmpty()) return;
        
        StringBuilder sb = new StringBuilder("Resultados de género " + genero + ":\n\n");
        
        // ¡Usamos TU clase Buscador!
        Buscador.buscarPorGenero(getPrimerNodo(), genero.trim(), false, sb);
        mostrar(sb.toString());
    }
 
    private void ordenarCartelera() {
        String[] opts = {"Ascendente (A-Z)","Descendente (Z-A)"};
        int r = JOptionPane.showOptionDialog(this,"¿Cómo ordenar?","Ordenar Cartelera",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
        if (r < 0) return;
        boolean asc = (r == 0);
        int n = AppContext.listaPeliculas.tamanio();
        Pelicula[] arr = new Pelicula[n];
        for (int i = 0; i < n; i++) arr[i] = AppContext.listaPeliculas.get(i);
        OrdenarCartelera.ordenar(arr, 0, n - 1, asc);
        AppContext.listaPeliculas = new ListaPeliculas();
        StringBuilder sb = new StringBuilder("Cartelera ordenada " + (asc ? "A-Z" : "Z-A") + ":\n\n");
        for (Pelicula p : arr) { AppContext.listaPeliculas.add(p); sb.append("• ").append(p.getTitulo()).append("\n"); }
        mostrar(sb.toString());
    }
 
    private void consultarPelicula() {
        String titulo = JOptionPane.showInputDialog(this, "Título a consultar:");
        if (titulo == null) return;
        
        // ¡Corregido! Ahora usa el buscador global
        Pelicula p = buscarPeliculaGlobal(titulo);
        if (p == null) { mostrar("Película no encontrada."); return; }
        
        StringBuilder sb = new StringBuilder();
        sb.append("══ ").append(p.getTitulo()).append(" ══\n")
          .append("Director:      ").append(p.getDirector()).append("\n")
          .append("Clasificación: ").append(p.getClasificacion()).append("\n")
          .append("Género:        ").append(p.getGenero()).append("\n")
          .append("Duración:      ").append(p.getDuracionMin()).append(" min\n");
          

        anexarHorarios(p, sb);
        mostrar(sb.toString());
    }
 
    private void anexarHorarios(Pelicula p, StringBuilder sb) {
        if (p.getHorarios() == null || p.getHorarios().tamanio() == 0) {
            sb.append("   [Sin horarios programados]\n");
        } else {
            for (int j = 0; j < p.getHorarios().tamanio(); j++) {
                Horario h = p.getHorarios().get(j);
                sb.append(" Sala: ").append(h.getSala())
                  .append(" | ").append(h.getFecha())
                  .append(" | ").append(h.getHoraInicio()).append("\n");
            }
        }
        sb.append("\n");
    }
    
    
    
    private void consultarCartelera() {
        if (AppContext.listaPeliculas.tamanio() == 0) { mostrar("No hay películas."); return; }
        StringBuilder sb = new StringBuilder("══ CARTELERA ══\n");
        sb.append(AppContext.nombreEstado).append(" — ").append(AppContext.nombreMunicipio).append("\n\n");
        for (int i = 0; i < AppContext.listaPeliculas.tamanio(); i++) {
            Pelicula p = AppContext.listaPeliculas.get(i);
            sb.append(i+1).append(". ").append(p.getTitulo())
              .append("  [").append(p.getClasificacion()).append("]  ").append(p.getGenero()).append("\n");
        }
        mostrar(sb.toString());
    }
 
    private void cineCercano() {
        // Detectar estado automáticamente según idEstado del usuario
        String idE = AppContext.idEstado;
        int[][] matriz; String[] nombres;
        switch (idE) {
            case "J11": matriz = Rutas.distJalisco;    nombres = Rutas.JALISCO;    break;
            case "N11": matriz = Rutas.distNuevoLeon;  nombres = Rutas.NUEVO_LEON; break;
            case "E11": matriz = Rutas.distEdomex;     nombres = Rutas.EDOMEX;     break;
            case "C11": matriz = Rutas.distChihuahua;  nombres = Rutas.CHIHUAHUA;  break;
            case "S11": matriz = Rutas.distSinaloa;    nombres = Rutas.SINALOA;    break;
            default: mostrar("Estado no reconocido."); return;
        }
 
        FloydCines fw = new FloydCines(matriz);
        fw.calcularRuta();
 
        // Índice origen = ID municipio (A=0, B=1...)
        char idM = AppContext.idMunicipio.charAt(0);
        int origen = idM - 'A';
        if (origen < 0 || origen >= nombres.length) origen = 0;
 
        // Panel de selección destino
        JComboBox<String> cmbDestino = new JComboBox<>(nombres);
        JPanel panel = new JPanel(new GridLayout(0, 1, 6, 6));
        panel.add(new JLabel("Tu ubicación: " + nombres[origen] + " (" + AppContext.idMunicipio + ")"));
        panel.add(new JLabel("¿A qué municipio quieres ir?"));
        panel.add(cmbDestino);
 
        int r = JOptionPane.showConfirmDialog(this, panel, "Calcular Ruta", JOptionPane.OK_CANCEL_OPTION);
        if (r != JOptionPane.OK_OPTION) return;
 
        int destino = cmbDestino.getSelectedIndex();
        int dist = fw.getDistancia(origen, destino);
 
        StringBuilder sb = new StringBuilder("══ CINES CERCANOS ══\n\n");
        sb.append("Estado:   ").append(AppContext.nombreEstado).append("\n");
        sb.append("Origen:   ").append(nombres[origen]).append("\n");
        sb.append("Destino:  ").append(nombres[destino]).append("\n\n");
        if (dist >= FloydCines.INF) {
            sb.append("No hay ruta disponible entre estos municipios.");
        } else {
            sb.append("Distancia mínima: ").append(dist).append(" km");
        }
        mostrar(sb.toString());
    }
 
    private void mostrar(String texto) { areaResultados.setText(texto); }
 
    private JButton crearBotonMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setForeground(BLANCO);
        btn.setBackground(new Color(35,65,130));
        btn.setBorderPainted(false); btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(9,14,9,14));
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(50,90,170)); }
            @Override public void mouseExited(MouseEvent e)  { btn.setBackground(new Color(35,65,130)); }
        });
        return btn;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
