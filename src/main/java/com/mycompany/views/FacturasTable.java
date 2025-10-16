package com.mycompany.views;

import com.mycompany.ilib.DAOClientsImpl;
import com.mycompany.ilib.DAOInvoicesImpl;
import com.mycompany.ilib.DAOInventoryProductsImpl;
import com.mycompany.ilib.DAOInvoiceLinesImpl;
import com.mycompany.models.Invoices;
import com.mycompany.models.InvoiceLines;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FacturasTable extends javax.swing.JPanel {

    private JTable tablaFacturas;
    private JTable tablaLineas;
    private DefaultTableModel modeloFacturas;
    private DefaultTableModel modeloLineas;

    public FacturasTable() {
        configurarTablas();
        cargarFacturas();
    }

    private void configurarTablas() {
        // Tabla de facturas
        modeloFacturas = new DefaultTableModel(new Object[] { "ID", "Número", "Cliente ID", "Fecha", "Total" }, 0);
        tablaFacturas = new JTable(modeloFacturas);
        tablaFacturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Tabla de líneas
        modeloLineas = new DefaultTableModel(new Object[] { "Producto ID", "Cantidad", "Precio Unitario", "Subtotal" },
                0);
        tablaLineas = new JTable(modeloLineas);

        // Escuchar selección de factura
        tablaFacturas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaFacturas.getSelectedRow() >= 0) {
                int invoiceId = Integer
                        .parseInt(tablaFacturas.getValueAt(tablaFacturas.getSelectedRow(), 0).toString());
                cargarLineas(invoiceId);
            }
        });

        // Layout
        JScrollPane scrollFacturas = new JScrollPane(tablaFacturas);
        JScrollPane scrollLineas = new JScrollPane(tablaLineas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(scrollLineas, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));
    }

private void cargarFacturas() {
    try {
        DAOInvoicesImpl daoFacturas = new DAOInvoicesImpl();
        DAOClientsImpl daoClientes = new DAOClientsImpl(); // DAO para clientes

        List<Invoices> facturas = daoFacturas.listar();
        modeloFacturas.setRowCount(0);

        for (Invoices f : facturas) {
            String nombreCliente = "Desconocido";
            try {
                nombreCliente = daoClientes.getClientById(f.getCustomerId()).getName();
            } catch (Exception e) {
                System.out.println("Cliente no encontrado: " + f.getCustomerId());
            }

            modeloFacturas.addRow(new Object[]{
                f.getId(),
                f.getInvoiceNumber(),
                nombreCliente,   // mostramos el nombre en vez del ID
                f.getDate(),
                f.getTotal()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar facturas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void cargarLineas(int invoiceId) {
        try {
            DAOInvoiceLinesImpl daoLineas = new DAOInvoiceLinesImpl();
            DAOInventoryProductsImpl daoProductos = new DAOInventoryProductsImpl();

            List<InvoiceLines> lineas = daoLineas.listarPorFactura(invoiceId);
            modeloLineas.setRowCount(0);

            for (InvoiceLines l : lineas) {
                // Obtener el nombre del producto usando el productId
                String nombreProducto = "Desconocido";
                try {
                    nombreProducto = daoProductos.getProductById(l.getProductId()).getProductName();
                } catch (Exception e) {
                    System.out.println("Producto no encontrado: " + l.getProductId());
                }

                modeloLineas.addRow(new Object[] {
                        nombreProducto,
                        l.getQuantity(),
                        l.getUnitPrice(),
                        l.getSubtotal()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar líneas: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
