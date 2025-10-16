package com.mycompany.views;

import com.mycompany.ilib.DAOClientsImpl;
import com.mycompany.models.Clients;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clientes extends javax.swing.JPanel {

    private DAOClientsImpl dao = new DAOClientsImpl();
    private int selectedId = -1;

    public Clientes() {
        initComponents();
        loadClients();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nombre", "Correo", "Teléfono", "Dirección" }
        ));
        tblClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClients);

        lblName.setText("Nombre:");
        lblEmail.setText("Correo:");
        lblPhone.setText("Teléfono:");
        lblAddress.setText("Dirección:");

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(evt -> btnEditActionPerformed(evt));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));

        btnClear.setText("Limpiar");
        btnClear.addActionListener(evt -> clearFields());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName)
                    .addComponent(txtName)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    // --- Métodos CRUD ---
    private void loadClients() {
        try {
            List<Clients> list = dao.listar(null);
            DefaultTableModel model = (DefaultTableModel) tblClients.getModel();
            model.setRowCount(0);
            for (Clients c : list) {
                model.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getEmail(),
                    c.getPhone(),
                    c.getAddress()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Clients c = new Clients();
            c.setName(txtName.getText());
            c.setEmail(txtEmail.getText());
            c.setPhone(txtPhone.getText());
            c.setAddress(txtAddress.getText());
            dao.registrar(c);
            loadClients();
            clearFields();
            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar: " + e.getMessage());
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar");
            return;
        }
        try {
            Clients c = new Clients();
            c.setId(selectedId);
            c.setName(txtName.getText());
            c.setEmail(txtEmail.getText());
            c.setPhone(txtPhone.getText());
            c.setAddress(txtAddress.getText());
            dao.modificar(c);
            loadClients();
            clearFields();
            JOptionPane.showMessageDialog(this, "Cliente modificado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al editar: " + e.getMessage());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este cliente?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dao.eliminar(selectedId);
                loadClients();
                clearFields();
                JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
            }
        }
    }

    private void tblClientsMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblClients.getSelectedRow();
        if (row != -1) {
            selectedId = (int) tblClients.getValueAt(row, 0);
            txtName.setText(tblClients.getValueAt(row, 1).toString());
            txtEmail.setText(tblClients.getValueAt(row, 2).toString());
            txtPhone.setText(tblClients.getValueAt(row, 3).toString());
            txtAddress.setText(tblClients.getValueAt(row, 4).toString());
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        selectedId = -1;
        tblClients.clearSelection();
    }

    // Variables declaration
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtAddress;
}
