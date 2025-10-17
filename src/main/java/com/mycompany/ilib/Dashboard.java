/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ilib;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mycompany.views.*;
import com.mycompany.views.Inventario;
import com.mycompany.views.Clientes;
import com.mycompany.views.SuppliersList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author Antonio
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        InitStyles();
        SetDate();
        InitContent();
    }
    
    private void InitStyles() {
        navText.putClientProperty("FlatLaf.style", "font: bold $h3.regular.font");
        navText.setForeground(Color.white);
        dateText.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        dateText.setForeground(Color.white);
        appName.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        appName.setForeground(Color.white);
    }
    
    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = Locale.forLanguageTag("es-ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    private void InitContent() {
        ShowJPanel(new Principal());
    }
    
    public static void ShowJPanel(JPanel p) {
        p.setSize(750, 430);
        p.setLocation(0,0);
        
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
    btn_prin = new javax.swing.JButton();
    btn_books = new javax.swing.JButton();
    btn_reports = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 660));

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(13, 71, 161));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("iLib");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        btn_prin.setBackground(new java.awt.Color(21, 101, 192));
        btn_prin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_prin.setForeground(new java.awt.Color(255, 255, 255));
        btn_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        btn_prin.setText("Principal");
        btn_prin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_prin.setBorderPainted(false);
        btn_prin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_prin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_prin.setIconTextGap(13);
        btn_prin.setInheritsPopupMenu(true);
        btn_prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prinActionPerformed(evt);
            }
        });


        // Usuarios, Préstamos y Devoluciones modules removed — buttons and handlers cleaned up

    btn_books.setBackground(new java.awt.Color(21, 101, 192));
    btn_books.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btn_books.setForeground(new java.awt.Color(255, 255, 255));
    // Ahora este botón mostrará la lista de Facturas (tabla)
    btn_books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-chart.png"))); // NOI18N
    btn_books.setText("Facturas");
        btn_books.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_books.setBorderPainted(false);
        btn_books.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_books.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_books.setIconTextGap(13);
        btn_books.setInheritsPopupMenu(true);
        btn_books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_booksActionPerformed(evt);
            }
        });

        btn_reports.setBackground(new java.awt.Color(21, 101, 192));
        btn_reports.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reports.setForeground(new java.awt.Color(255, 255, 255));
        // Este botón ahora sirve para crear facturas (antes llamado Facturas)
        // Uso un icono existente para evitar recursos faltantes
        btn_reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-chart.png"))); // NOI18N
        btn_reports.setText("Crear facturas");

        // Nuevo botón: Inventario (Existencias)
        btn_inventory = new javax.swing.JButton();
        btn_inventory.setBackground(new java.awt.Color(21, 101, 192));
        btn_inventory.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_inventory.setForeground(new java.awt.Color(255, 255, 255));
    btn_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book-open-page-variant.png")));
    btn_inventory.setText("Existencias");
        btn_inventory.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_inventory.setBorderPainted(false);
        btn_inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_inventory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_inventory.setIconTextGap(13);
        btn_inventory.setInheritsPopupMenu(true);
        btn_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowJPanel(new Inventario());
            }
        });

        // Nuevo botón: Clientes
        btn_clients = new javax.swing.JButton();
        btn_clients.setBackground(new java.awt.Color(21, 101, 192));
        btn_clients.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_clients.setForeground(new java.awt.Color(255, 255, 255));
    btn_clients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png")));
    btn_clients.setText("Clientes");
        btn_clients.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_clients.setBorderPainted(false);
        btn_clients.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_clients.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_clients.setIconTextGap(13);
        btn_clients.setInheritsPopupMenu(true);
        btn_clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowJPanel(new Clientes());
            }
        });

        // Nuevo botón: Proveedores
        btn_suppliers = new javax.swing.JButton();
        btn_suppliers.setBackground(new java.awt.Color(21, 101, 192));
        btn_suppliers.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_suppliers.setForeground(new java.awt.Color(255, 255, 255));
    btn_suppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png")));
    btn_suppliers.setText("Proveedores");
        btn_suppliers.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_suppliers.setBorderPainted(false);
        btn_suppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_suppliers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_suppliers.setIconTextGap(13);
        btn_suppliers.setInheritsPopupMenu(true);
        btn_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowJPanel(new SuppliersList());
            }
        });
        btn_reports.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_reports.setBorderPainted(false);
        btn_reports.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_reports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_reports.setIconTextGap(13);
        btn_reports.setInheritsPopupMenu(true);
        btn_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_prin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_books, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_clients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_suppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_prin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_books, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_reports, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_clients, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header.setBackground(new java.awt.Color(25, 118, 210));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        navText.setText("Administración/Control/Biblioteca");

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prinActionPerformed
        ShowJPanel(new Principal());
    }//GEN-LAST:event_btn_prinActionPerformed

    // Removed handlers for Lendings/Returns/Users modules

    private void btn_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportsActionPerformed
        // "Crear facturas" — abre el formulario/flujo para crear facturas
        ShowJPanel(new Facturas());
    }//GEN-LAST:event_btn_reportsActionPerformed

    private void btn_booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_booksActionPerformed
        // "Facturas" — muestra la tabla/listado de facturas
        ShowJPanel(new FacturasTable());
    }//GEN-LAST:event_btn_booksActionPerformed

    // Nuevo: acceso directo a Inventario
    // Reuso btn_lends/otros no conveniente; añadir enlace en btn_lends no solicitado.
    // Añadimos un handler público para abrir Inventario desde código si se desea.
    public void openInventario() {
        ShowJPanel(new Inventario());
    }

    // Nuevo: acceso directo a Clientes
    public void openClientes() {
        ShowJPanel(new Clientes());
    }

    // Nuevo: acceso directo a Proveedores
    public void openSuppliers() {
        ShowJPanel(new SuppliersList());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appName;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_books;
    private javax.swing.JButton btn_inventory;
    private javax.swing.JButton btn_clients;
    private javax.swing.JButton btn_suppliers;
    private javax.swing.JButton btn_prin;
    private javax.swing.JButton btn_reports;
    private static javax.swing.JPanel content;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    // End of variables declaration//GEN-END:variables
}
