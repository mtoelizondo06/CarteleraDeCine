
package com.mycompany.carteleradecine;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class UbicacionFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UbicacionFrame.class.getName());
    private static final Color AZUL_OSCURO = new Color(13, 27, 62);
    private static final Color AZUL_MEDIO  = new Color(26, 54, 124);
    private static final Color DORADO      = new Color(212, 175, 55);
    private static final Color BLANCO      = Color.WHITE;
    private static final Color GRIS_CLARO  = new Color(245, 245, 250);
    private static final Color ROJO_ERROR  = new Color(200, 40, 40);
    private static final LinkedHashMap<String, String> ESTADOS = new LinkedHashMap<>();
    private static final LinkedHashMap<String, LinkedHashMap<String, String>> MUNICIPIOS = new LinkedHashMap<>();
 
    static {
        ESTADOS.put("J11", "Jalisco");
        ESTADOS.put("N11", "Nuevo León");
        ESTADOS.put("E11", "Estado de México");
        ESTADOS.put("C11", "Chihuahua");
        ESTADOS.put("S11", "Sinaloa");
 
        String[][] jalisco = {{"A","Guadalajara"},{"B","Zapopan"},{"C","Tlaquepaque"},
            {"D","Tonalá"},{"E","Zapotlanejo"},{"F","Tlajomulco"},
            {"G","Ayotlán"},{"H","Tequila"},{"I","Ocotlán"},{"J","Puerto Vallarta"}};
        
        String[][] nuevoLeon = {{"A","Guadalupe"},{"B","Abasolo"},{"C","Apodaca"},
            {"D","Ciénega de Flores"},{"E","General Zaragoza"},{"F","Iturbide"},
            {"G","Juárez"},{"H","Monterrey"},{"I","Salinas Victoria"},{"J","General Zuazua"}};
        
        String[][] edomex = {{"A","Cuautitlán Izcalli"},{"B","Chalco"},{"C","Aculco"},
            {"D","Atizapán"},{"E","Chapultepec"},{"F","Ecatepec de Morelos"},
            {"G","Naucalpan de Juárez"},{"H","Morelos"},{"I","Texcoco"},{"J","Toluca"}};
        
        String[][] chihuahua = {{"A","Ignacio Zaragoza"},{"B","Allende"},{"C","Valle de Zaragoza"},
            {"D","Rosario"},{"E","Nonoava"},{"F","Matamoros"},
            {"G","Guadalupe y Calvo"},{"H","Coronado"},{"I","Delicias"},{"J","Galeana"}};
        
        String[][] sinaloa = {{"A","Guasave"},{"B","Navolato"},{"C","Cosalá"},
            {"D","Angostura"},{"E","Mocorito"}};
 
        cargarMunicipios("J11", jalisco);
        cargarMunicipios("N11", nuevoLeon);
        cargarMunicipios("E11", edomex);
        cargarMunicipios("C11", chihuahua);
        cargarMunicipios("S11", sinaloa);
    }
 
    private static void cargarMunicipios(String idEstado, String[][] data) {
        LinkedHashMap<String, String> mapa = new LinkedHashMap<>();
        for (String[] entry : data) mapa.put(entry[0], entry[1]);
        MUNICIPIOS.put(idEstado, mapa);
    }
     
    private JComboBox<String> cmbEstado;
    private JComboBox<String> cmbMunicipio;
    private JLabel lblEstadoNombre;
    private JLabel lblMunicipioNombre;
    private JLabel lblError;
    private JLabel lblBienvenida;
    
    public UbicacionFrame() {
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
        java.awt.EventQueue.invokeLater(() -> new UbicacionFrame().setVisible(true));
    }
    
     private void initUI() {
        setTitle("Cartelera de Cine — Ubicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 710);
        setLocationRelativeTo(null);
        setResizable(false);
 
        // Panel principal degradado
        JPanel panelPrincipal = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, AZUL_OSCURO, 0, getHeight(), AZUL_MEDIO);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
 
        // ── Header ─────────────────────────────────────────────────────────────
        JPanel panelHeader = new JPanel(new GridBagLayout());
        panelHeader.setOpaque(false);
        panelHeader.setBorder(BorderFactory.createEmptyBorder(30, 20, 15, 20));
        String rol = AppContext.rolActual.equals("ADMIN") ? "Administrador" : "Cliente";
 
        JLabel lblTitulo = new JLabel("CARTELERA");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(DORADO);
 
        lblBienvenida = new JLabel("Bienvenido, " + rol + " — " + AppContext.emailActual);
        lblBienvenida.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBienvenida.setForeground(new Color(200, 210, 230));
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
 
        JLabel lblSub = new JLabel("Selecciona tu estado y municipio");
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSub.setForeground(new Color(180, 195, 220));
 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.insets = new Insets(0,0,6,0);
        gbc.gridy = 1; panelHeader.add(lblTitulo, gbc);
        gbc.gridy = 2; gbc.insets = new Insets(2,0,2,0);
        panelHeader.add(lblBienvenida, gbc);
        gbc.gridy = 3; panelHeader.add(lblSub, gbc);
 
        // ── Tarjeta ────────────────────────────────────────────────────────────
        JPanel tarjeta = new JPanel(new GridBagLayout());
        tarjeta.setBackground(BLANCO);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            new LoginFrame.ShadowBorder(),
            BorderFactory.createEmptyBorder(28, 35, 28, 35)
        ));
 
        GridBagConstraints t = new GridBagConstraints();
        t.fill = GridBagConstraints.HORIZONTAL;
        t.weightx = 1.0;
 
        // ── ID Estado ──────────────────────────────────────────────────────────
        t.gridx = 0; t.gridy = 0; t.insets = new Insets(0,0,6,0);
        tarjeta.add(crearLabel("ID Estado:"), t);
 
        String[] idsEstado = ESTADOS.keySet().toArray(new String[0]);
        cmbEstado = new JComboBox<>(idsEstado);
        estilizarCombo(cmbEstado);
        t.gridy = 1; t.insets = new Insets(0,0,4,0);
        tarjeta.add(cmbEstado, t);
 
        lblEstadoNombre = new JLabel(ESTADOS.get(idsEstado[0]));
        lblEstadoNombre.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblEstadoNombre.setForeground(new Color(70, 100, 160));
        t.gridy = 2; t.insets = new Insets(0,4,18,0);
        tarjeta.add(lblEstadoNombre, t);
 
        // ── ID Municipio ───────────────────────────────────────────────────────
        t.gridy = 3; t.insets = new Insets(0,0,6,0);
        tarjeta.add(crearLabel("ID Municipio:"), t);
 
        cmbMunicipio = new JComboBox<>();
        estilizarCombo(cmbMunicipio);
        t.gridy = 4; t.insets = new Insets(0,0,4,0);
        tarjeta.add(cmbMunicipio, t);
 
        lblMunicipioNombre = new JLabel("");
        lblMunicipioNombre.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblMunicipioNombre.setForeground(new Color(70, 100, 160));
        t.gridy = 5; t.insets = new Insets(0,4,8,0);
        tarjeta.add(lblMunicipioNombre, t);
 
        // Error
        lblError = new JLabel(" ");
        lblError.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblError.setForeground(ROJO_ERROR);
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        t.gridy = 6; t.insets = new Insets(0,0,10,0);
        tarjeta.add(lblError, t);
 
        // Tabla de referencia pequeña
        JLabel lblTabla = crearTablaHTML();
        t.gridy = 7; t.insets = new Insets(0,0,18,0);
        tarjeta.add(lblTabla, t);
 
        // Botón confirmar
        JButton btnConfirmar = new JButton("Confirmar Ubicación →");
        estilizarBoton(btnConfirmar);
        t.gridy = 8; t.insets = new Insets(0,0,0,0);
        tarjeta.add(btnConfirmar, t);
 
        //wrap
        JPanel wrap = new JPanel(new GridBagLayout());
        wrap.setOpaque(false);
        wrap.setBorder(BorderFactory.createEmptyBorder(0, 35, 15, 35));
        wrap.add(tarjeta);
 
        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelPrincipal.add(wrap, BorderLayout.CENTER);
        setContentPane(panelPrincipal);
 
        //listeners
        actualizarMunicipios((String) cmbEstado.getSelectedItem());
 
        cmbEstado.addActionListener(e -> {
            String idE = (String) cmbEstado.getSelectedItem();
            lblEstadoNombre.setText(ESTADOS.getOrDefault(idE, ""));
            actualizarMunicipios(idE);
        });
 
        cmbMunicipio.addActionListener(e -> {
            String idE = (String) cmbEstado.getSelectedItem();
            String idM = (String) cmbMunicipio.getSelectedItem();
            if (idE != null && idM != null) {
                String nombre = MUNICIPIOS.getOrDefault(idE, new LinkedHashMap<>()).getOrDefault(idM, "");
                lblMunicipioNombre.setText(nombre);
            }
        });
 
        btnConfirmar.addActionListener(e -> confirmarUbicacion());
    }
 
    private void actualizarMunicipios(String idEstado) {
        cmbMunicipio.removeAllItems();
        LinkedHashMap<String, String> munis = MUNICIPIOS.getOrDefault(idEstado, new LinkedHashMap<>());
        for (String id : munis.keySet()) cmbMunicipio.addItem(id);
        if (cmbMunicipio.getItemCount() > 0) {
            String primerMuni = (String) cmbMunicipio.getSelectedItem();
            lblMunicipioNombre.setText(munis.getOrDefault(primerMuni, ""));
        }
        lblEstadoNombre.setText(ESTADOS.getOrDefault(idEstado, ""));
    }
 
    private void confirmarUbicacion() {
        String idE = (String) cmbEstado.getSelectedItem();
        String idM = (String) cmbMunicipio.getSelectedItem();
 
        if (idE == null || idM == null) {
            lblError.setText("Selecciona un estado y municipio válidos.");
            return;
        }
 
        AppContext.idEstado        = idE;
        AppContext.idMunicipio     = idM;
        AppContext.nombreEstado    = ESTADOS.get(idE);
        AppContext.nombreMunicipio = MUNICIPIOS.get(idE).get(idM);
 
        AppContext.listaPeliculas = new ListaPeliculas();
        AppContext.pilaDeshacer = new PilaDeshacer();
        
        // Cargar datos de prueba en el contexto compartido
        CarteleraDeCine.datosPrueba();
 
        SwingUtilities.invokeLater(() -> {
            if (AppContext.rolActual.equals("ADMIN")) {
                AdminFrame af = new AdminFrame();
                af.setVisible(true);
            } else {
                ClienteFrame cf = new ClienteFrame();
                cf.setVisible(true);
            }
            this.dispose();
        });
    }
 
    // ── Tabla HTML de referencia compacta ──────────────────────────────────────
    private JLabel crearTablaHTML() {
        String html = "<html><body style='font-size:10px; color:#445566'>"
            + "<b>Referencia de IDs:</b><br>"
            + "<table border='0' cellpadding='2'>"
            + "<tr><td><b>J11</b> Jalisco</td><td><b>N11</b> Nuevo León</td><td><b>E11</b> EdoMéx</td></tr>"
            + "<tr><td><b>C11</b> Chihuahua</td><td><b>S11</b> Sinaloa</td><td></td></tr>"
            + "<tr><td colspan='3'>Municipios: <b>A</b>-J</td></tr>"
            + "</table></body></html>";
        JLabel lbl = new JLabel(html);
        lbl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 215, 235), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        lbl.setBackground(new Color(240, 246, 255));
        lbl.setOpaque(true);
        return lbl;
    }
 
    // ── Helpers de estilo ──────────────────────────────────────────────────────
    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(new Color(50, 60, 80));
        return lbl;
    }
 
    private void estilizarCombo(JComboBox<?> combo) {
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        combo.setPreferredSize(new Dimension(300, 40));
        combo.setBackground(GRIS_CLARO);
        combo.setBorder(BorderFactory.createLineBorder(new Color(200, 210, 225), 1));
    }
 
    private void estilizarBoton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(AZUL_OSCURO);
        btn.setBackground(DORADO);
        btn.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(230,195,80)); }
            @Override public void mouseExited(MouseEvent e)  { btn.setBackground(DORADO); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
