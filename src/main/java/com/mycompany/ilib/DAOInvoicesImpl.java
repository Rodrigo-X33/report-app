package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOInvoices;
import com.mycompany.models.Invoices;
// imports PreparedStatement/ResultSet are used via fully-qualified names in try-with-resources
import java.util.ArrayList;
import java.util.List;

public class DAOInvoicesImpl extends Database implements DAOInvoices {
    @Override
    public void registrar(Invoices invoice) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO invoices(invoice_number, customer_id, date, total) VALUES(?,?,?,?)")) {
                st.setString(1, invoice.getInvoiceNumber());
                st.setInt(2, invoice.getCustomerId());
                st.setDate(3, invoice.getDate());
                st.setDouble(4, invoice.getTotal());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Invoices invoice) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE invoices SET invoice_number=?, customer_id=?, date=?, total=? WHERE id=?")) {
                st.setString(1, invoice.getInvoiceNumber());
                st.setInt(2, invoice.getCustomerId());
                st.setDate(3, invoice.getDate());
                st.setDouble(4, invoice.getTotal());
                st.setInt(5, invoice.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int invoiceId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM invoices WHERE id=?")) {
                st.setInt(1, invoiceId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Invoices> listar() throws Exception {
        List<Invoices> lista = new ArrayList<>();
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM invoices")) {
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Invoices i = new Invoices();
                        i.setId(rs.getInt("id"));
                        i.setInvoiceNumber(rs.getString("invoice_number"));
                        i.setCustomerId(rs.getInt("customer_id"));
                        i.setDate(rs.getDate("date"));
                        i.setTotal(rs.getDouble("total"));
                        i.setCreatedAt(rs.getTimestamp("created_at"));
                        lista.add(i);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Invoices getInvoiceById(int invoiceId) throws Exception {
        Invoices i = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM invoices WHERE id=?")) {
                st.setInt(1, invoiceId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        i = new Invoices();
                        i.setId(rs.getInt("id"));
                        i.setInvoiceNumber(rs.getString("invoice_number"));
                        i.setCustomerId(rs.getInt("customer_id"));
                        i.setDate(rs.getDate("date"));
                        i.setTotal(rs.getDouble("total"));
                        i.setCreatedAt(rs.getTimestamp("created_at"));
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return i;
    }
}
