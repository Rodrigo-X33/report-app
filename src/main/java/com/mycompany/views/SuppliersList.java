package com.mycompany.views;

import com.mycompany.ilib.DAOSuppliersImpl;
import com.mycompany.interfaces.DAOSuppliers;
import com.mycompany.ilib.Dashboard;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

// IconLoader removed to match Users view (buttons without icons)

public class SuppliersList extends javax.swing.JPanel {
    private javax.swing.JButton addButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;

    public SuppliersList() {
        initComponents();
        InitStyles();
        LoadSuppliers();
    }
    private void InitStyles() {
    title.putClientProperty("FlatLaf.styleClass", "h1");
    title.setForeground(Color.black);
    searchField.putClientProperty("JTextField.placeholderText", "Buscar proveedor...");
    }
    private void LoadSuppliers() {
        try {
            DAOSuppliers dao = new DAOSuppliersImpl();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            dao.listar(searchField.getText()).forEach((s) -> model.addRow(new Object[]{s.getId(), s.getName(), s.getEmail(), s.getPhone()}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void initComponents() {
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        setBackground(new java.awt.Color(255, 255, 255));
        bg.setBackground(new java.awt.Color(255, 255, 255));
    title.setText("Proveedores");
    searchButton.setBackground(new java.awt.Color(18, 90, 173));
    searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
    searchButton.setForeground(new java.awt.Color(255, 255, 255));
    searchButton.setText("Buscar");
    searchButton.setBorderPainted(false);
    searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    addButton.setBackground(new java.awt.Color(18, 90, 173));
    addButton.setFont(new java.awt.Font("Segoe UI", 0, 18));
    addButton.setForeground(new java.awt.Color(255, 255, 255));
    addButton.setText("Agregar");
    addButton.setBorderPainted(false);
    addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    editButton.setBackground(new java.awt.Color(18, 90, 173));
    editButton.setFont(new java.awt.Font("Segoe UI", 0, 18));
    editButton.setForeground(new java.awt.Color(255, 255, 255));
    editButton.setText("Editar");
    editButton.setBorderPainted(false);
    editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    deleteButton.setBackground(new java.awt.Color(18, 90, 173));
    deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 18));
    deleteButton.setForeground(new java.awt.Color(255, 255, 255));
    deleteButton.setText("Eliminar");
    deleteButton.setBorderPainted(false);
    deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nombre", "Email", "Teléfono"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        // actions
        searchButton.addActionListener((evt) -> LoadSuppliers());
        searchField.addActionListener((evt) -> LoadSuppliers());
        addButton.addActionListener((evt) -> {
            // Open create supplier form
            Dashboard.ShowJPanel(new UpSuppliers());
        });
        editButton.addActionListener((evt) -> {
            try {
                int row = jTable1.getSelectedRow();
                if (row >= 0) {
                    int id = (int) jTable1.getValueAt(row, 0);
                    DAOSuppliers dao = new DAOSuppliersImpl();
                    com.mycompany.models.Suppliers s = dao.getSupplierById(id);
                    if (s != null) {
                        Dashboard.ShowJPanel(new UpSuppliers(s));
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un proveedor para editar.", "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        deleteButton.addActionListener((evt) -> {
            try {
                int row = jTable1.getSelectedRow();
                if (row >= 0) {
                    int id = (int) jTable1.getValueAt(row, 0);
                    DAOSuppliers dao = new DAOSuppliersImpl();
                    dao.eliminar(id);
                    LoadSuppliers();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(searchField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton)
                    .addComponent(addButton))
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel title;
}
