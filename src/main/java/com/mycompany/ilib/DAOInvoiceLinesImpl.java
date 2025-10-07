package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOInvoiceLines;
import com.mycompany.models.InvoiceLines;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOInvoiceLinesImpl extends Database implements DAOInvoiceLines {
    @Override
    public void registrar(InvoiceLines line) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO invoice_lines(invoice_id, product_id, quantity, unit_price, subtotal) VALUES(?,?,?,?,?)");
            st.setInt(1, line.getInvoiceId());
            st.setInt(2, line.getProductId());
            st.setInt(3, line.getQuantity());
            st.setDouble(4, line.getUnitPrice());
            st.setDouble(5, line.getSubtotal());
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(InvoiceLines line) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE invoice_lines SET invoice_id=?, product_id=?, quantity=?, unit_price=?, subtotal=? WHERE id=?");
            st.setInt(1, line.getInvoiceId());
            st.setInt(2, line.getProductId());
            st.setInt(3, line.getQuantity());
            st.setDouble(4, line.getUnitPrice());
            st.setDouble(5, line.getSubtotal());
            st.setInt(6, line.getId());
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int lineId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM invoice_lines WHERE id=?");
            st.setInt(1, lineId);
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<InvoiceLines> listarPorFactura(int invoiceId) throws Exception {
        List<InvoiceLines> lista = new ArrayList<>();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM invoice_lines WHERE invoice_id=?");
            st.setInt(1, invoiceId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                InvoiceLines l = new InvoiceLines();
                l.setId(rs.getInt("id"));
                l.setInvoiceId(rs.getInt("invoice_id"));
                l.setProductId(rs.getInt("product_id"));
                l.setQuantity(rs.getInt("quantity"));
                l.setUnitPrice(rs.getDouble("unit_price"));
                l.setSubtotal(rs.getDouble("subtotal"));
                lista.add(l);
            }
            rs.close();
            st.close();
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public InvoiceLines getLineById(int lineId) throws Exception {
        InvoiceLines l = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM invoice_lines WHERE id=?");
            st.setInt(1, lineId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                l = new InvoiceLines();
                l.setId(rs.getInt("id"));
                l.setInvoiceId(rs.getInt("invoice_id"));
                l.setProductId(rs.getInt("product_id"));
                l.setQuantity(rs.getInt("quantity"));
                l.setUnitPrice(rs.getDouble("unit_price"));
                l.setSubtotal(rs.getDouble("subtotal"));
            }
            rs.close();
            st.close();
        } finally {
            this.Cerrar();
        }
        return l;
    }
}
