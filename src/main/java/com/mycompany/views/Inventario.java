package com.mycompany.views;

import com.mycompany.ilib.DAOInventoryProductsImpl;
import com.mycompany.models.InventoryProducts;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JPanel {

    private DAOInventoryProductsImpl dao = new DAOInventoryProductsImpl();
    private int selectedId = -1;

    public Inventario() {
        initComponents();
        loadProducts();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblSupplierId = new javax.swing.JLabel();
        txtSupplierId = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Producto", "Stock", "Precio", "Proveedor ID" }
        ));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        lblName.setText("Nombre del producto:");
        lblStock.setText("Stock:");
        lblPrice.setText("Precio:");
        lblSupplierId.setText("ID del proveedor (opcional):");

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
                    .addComponent(lblStock)
                    .addComponent(txtStock)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice)
                    .addComponent(lblSupplierId)
                    .addComponent(txtSupplierId)
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
                .addComponent(lblStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSupplierId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private void loadProducts() {
        try {
            List<InventoryProducts> list = dao.listar(null);
            DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
            model.setRowCount(0);
            for (InventoryProducts p : list) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getProductName(),
                    p.getStock(),
                    p.getPrice(),
                    p.getSupplierId() != null ? p.getSupplierId() : "—"
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            InventoryProducts p = new InventoryProducts();
            p.setProductName(txtName.getText());
            p.setStock(Integer.parseInt(txtStock.getText()));
            p.setPrice(Double.parseDouble(txtPrice.getText()));
            if (!txtSupplierId.getText().trim().isEmpty()) {
                p.setSupplierId(Integer.parseInt(txtSupplierId.getText()));
            } else {
                p.setSupplierId(null);
            }
            dao.registrar(p);
            loadProducts();
            clearFields();
            JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar: " + e.getMessage());
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar");
            return;
        }
        try {
            InventoryProducts p = new InventoryProducts();
            p.setId(selectedId);
            p.setProductName(txtName.getText());
            p.setStock(Integer.parseInt(txtStock.getText()));
            p.setPrice(Double.parseDouble(txtPrice.getText()));
            if (!txtSupplierId.getText().trim().isEmpty()) {
                p.setSupplierId(Integer.parseInt(txtSupplierId.getText()));
            } else {
                p.setSupplierId(null);
            }
            dao.modificar(p);
            loadProducts();
            clearFields();
            JOptionPane.showMessageDialog(this, "Producto modificado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al editar: " + e.getMessage());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este producto?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dao.eliminar(selectedId);
                loadProducts();
                clearFields();
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
            }
        }
    }

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblProducts.getSelectedRow();
        if (row != -1) {
            selectedId = (int) tblProducts.getValueAt(row, 0);
            txtName.setText(tblProducts.getValueAt(row, 1).toString());
            txtStock.setText(tblProducts.getValueAt(row, 2).toString());
            txtPrice.setText(tblProducts.getValueAt(row, 3).toString());
            Object supplier = tblProducts.getValueAt(row, 4);
            txtSupplierId.setText(supplier != null && !supplier.toString().equals("—") ? supplier.toString() : "");
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtStock.setText("");
        txtPrice.setText("");
        txtSupplierId.setText("");
        selectedId = -1;
        tblProducts.clearSelection();
    }

    // Variables declaration
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSupplierId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSupplierId;
}
