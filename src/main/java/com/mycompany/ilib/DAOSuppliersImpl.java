package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSuppliers;
import com.mycompany.models.Suppliers;
// imports PreparedStatement/ResultSet are used via fully-qualified names in try-with-resources
import java.util.ArrayList;
import java.util.List;

public class DAOSuppliersImpl extends Database implements DAOSuppliers {
    @Override
    public void registrar(Suppliers supplier) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO suppliers(name, email, phone) VALUES(?,?,?)")) {
                st.setString(1, supplier.getName());
                st.setString(2, supplier.getEmail());
                st.setString(3, supplier.getPhone());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Suppliers supplier) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE suppliers SET name=?, email=?, phone=? WHERE id=?")) {
                st.setString(1, supplier.getName());
                st.setString(2, supplier.getEmail());
                st.setString(3, supplier.getPhone());
                st.setInt(4, supplier.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int supplierId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM suppliers WHERE id=?")) {
                st.setInt(1, supplierId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Suppliers> listar(String name) throws Exception {
        List<Suppliers> lista = new ArrayList<>();
        try {
            this.Conectar();
            String query = name == null || name.isEmpty() ? "SELECT * FROM suppliers" : "SELECT * FROM suppliers WHERE name ILIKE ?";
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement(query)) {
                if (name != null && !name.isEmpty()) {
                    st.setString(1, "%" + name + "%");
                }
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Suppliers s = new Suppliers();
                        s.setId(rs.getInt("id"));
                        s.setName(rs.getString("name"));
                        s.setEmail(rs.getString("email"));
                        s.setPhone(rs.getString("phone"));
                        lista.add(s);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Suppliers getSupplierById(int supplierId) throws Exception {
        Suppliers s = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM suppliers WHERE id=?")) {
                st.setInt(1, supplierId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        s = new Suppliers();
                        s.setId(rs.getInt("id"));
                        s.setName(rs.getString("name"));
                        s.setEmail(rs.getString("email"));
                        s.setPhone(rs.getString("phone"));
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return s;
    }
}
