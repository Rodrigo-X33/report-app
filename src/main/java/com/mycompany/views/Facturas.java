package com.mycompany.views;

import com.mycompany.ilib.DAOInvoicesImpl;
import com.mycompany.ilib.DAOInvoiceLinesImpl;
import com.mycompany.models.Invoices;
import com.mycompany.models.InvoiceLines;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Facturas extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    private List<InvoiceLines> lineas;

    public Facturas() {
        initComponents();
        configurarTabla();
        lineas = new ArrayList<>();
        txtFecha.setText(LocalDate.now().toString());
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[] { "Producto", "Cantidad", "Precio Unitario", "Subtotal", "ProductID" }, 0);
        tablaLineas.setModel(modeloTabla);
        // Ocultar la columna ProductID
        tablaLineas.getColumnModel().getColumn(4).setMinWidth(0);
        tablaLineas.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaLineas.getColumnModel().getColumn(4).setWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        txtClienteId = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLineas = new javax.swing.JTable();
        btnAgregarLinea = new javax.swing.JButton();
        btnEliminarLinea = new javax.swing.JButton();
        btnGuardarFactura = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        jLabel1.setText("Número de Factura:");
        jLabel2.setText("Cliente ID:");
        jLabel3.setText("Fecha:");
        jLabel4.setText("Total:");

        tablaLineas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Producto", "Cantidad", "Precio Unitario", "Subtotal" }));
        jScrollPane1.setViewportView(tablaLineas);

        btnAgregarLinea.setText("Agregar Línea");
        btnAgregarLinea.addActionListener(evt -> btnAgregarLineaActionPerformed(evt));

        btnEliminarLinea.setText("Eliminar Línea");
        btnEliminarLinea.addActionListener(evt -> btnEliminarLineaActionPerformed(evt));

        btnGuardarFactura.setText("Guardar Factura");
        btnGuardarFactura.addActionListener(evt -> btnGuardarFacturaActionPerformed(evt));

        lblTotal.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtNumeroFactura,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtClienteId)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 100, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(btnAgregarLinea)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminarLinea)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90,
                                                        Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnGuardarFactura, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAgregarLinea)
                                        .addComponent(btnEliminarLinea)
                                        .addComponent(jLabel4)
                                        .addComponent(lblTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardarFactura)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = tablaLineas.getSelectedRow();
        if (fila >= 0) {
            modeloTabla.removeRow(fila);
            actualizarTotal();
        }
    }

    private void btnAgregarLineaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cargar productos desde la BD
            com.mycompany.ilib.DAOInventoryProductsImpl daoProductos = new com.mycompany.ilib.DAOInventoryProductsImpl();
            java.util.List<com.mycompany.models.InventoryProducts> productos = daoProductos.listar("");

            if (productos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay productos disponibles", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Crear combo con los nombres de producto
            JComboBox<String> comboProductos = new JComboBox<>();
            for (com.mycompany.models.InventoryProducts p : productos) {
                comboProductos.addItem(p.getProductName());
            }

            JTextField txtCantidad = new JTextField();
            JTextField txtPrecio = new JTextField();

            Object[] campos = {
                    "Producto:", comboProductos,
                    "Cantidad:", txtCantidad,
                    "Precio Unitario:", txtPrecio
            };

            int opcion = JOptionPane.showConfirmDialog(this, campos, "Agregar línea", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {
                int productoSeleccionado = comboProductos.getSelectedIndex();
                com.mycompany.models.InventoryProducts producto = productos.get(productoSeleccionado);

                int cantidad = Integer.parseInt(txtCantidad.getText());
                double precio = Double.parseDouble(txtPrecio.getText());
                double subtotal = cantidad * precio;

                // Guardar también el ID del producto de forma oculta (en la tabla)
                modeloTabla.addRow(
                        new Object[] { producto.getProductName(), cantidad, precio, subtotal, producto.getId() });

                actualizarTotal();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTotal() {
        double total = 0;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            total += Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
        }
        lblTotal.setText(String.format("%.2f", total));
    }

    private void btnGuardarFacturaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            DAOInvoicesImpl daoFactura = new DAOInvoicesImpl();
            DAOInvoiceLinesImpl daoLineas = new DAOInvoiceLinesImpl();
            Invoices factura = new Invoices();
            factura.setInvoiceNumber(txtNumeroFactura.getText());
            factura.setCustomerId(Integer.parseInt(txtClienteId.getText()));
            factura.setDate(Date.valueOf(txtFecha.getText()));
            factura.setTotal(Double.parseDouble(lblTotal.getText()));
            int invoiceId = daoFactura.registrar(factura);
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int productId = Integer.parseInt(modeloTabla.getValueAt(i, 4).toString());
                int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
                double precio = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString());
                double subtotal = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());

                daoLineas.registrarLinea(invoiceId, productId, cantidad, precio, subtotal);
            }
            JOptionPane.showMessageDialog(this, "Factura guardada correctamente");
            modeloTabla.setRowCount(0);
            lblTotal.setText("0.00");
            txtNumeroFactura.setText("");
            txtClienteId.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLinea;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.JButton btnGuardarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaLineas;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumeroFactura;
    // End of variables declaration//GEN-END:variables
}
