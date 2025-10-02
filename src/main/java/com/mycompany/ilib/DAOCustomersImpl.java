package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOCustomers;
import com.mycompany.models.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomersImpl extends Database implements DAOCustomers {
    @Override
    public void registrar(Customers customer) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO customers(name, email, phone, address) VALUES(?,?,?,?)");
            st.setString(1, customer.getName());
            st.setString(2, customer.getEmail());
            st.setString(3, customer.getPhone());
            st.setString(4, customer.getAddress());
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Customers customer) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE customers SET name=?, email=?, phone=?, address=? WHERE id=?");
            st.setString(1, customer.getName());
            st.setString(2, customer.getEmail());
            st.setString(3, customer.getPhone());
            st.setString(4, customer.getAddress());
            st.setInt(5, customer.getId());
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int customerId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM customers WHERE id=?");
            st.setInt(1, customerId);
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Customers> listar(String name) throws Exception {
        List<Customers> lista = new ArrayList<>();
        try {
            this.Conectar();
            String query = name == null || name.isEmpty() ? "SELECT * FROM customers" : "SELECT * FROM customers WHERE name ILIKE ?";
            PreparedStatement st = this.conexion.prepareStatement(query);
            if (name != null && !name.isEmpty()) {
                st.setString(1, "%" + name + "%");
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customers c = new Customers();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
                lista.add(c);
            }
            rs.close();
            st.close();
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Customers getCustomerById(int customerId) throws Exception {
        Customers c = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM customers WHERE id=?");
            st.setInt(1, customerId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Customers();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
            }
            rs.close();
            st.close();
        } finally {
            this.Cerrar();
        }
        return c;
    }
}
