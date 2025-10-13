package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOClients;
import com.mycompany.models.Clients;
// PreparedStatement/ResultSet used with fully-qualified names in this file
import java.util.ArrayList;
import java.util.List;

public class DAOClientsImpl extends Database implements DAOClients {
    @Override
    public void registrar(Clients client) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO clients(name, email, phone, address) VALUES(?,?,?,?)")) {
                st.setString(1, client.getName());
                st.setString(2, client.getEmail());
                st.setString(3, client.getPhone());
                st.setString(4, client.getAddress());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Clients client) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE clients SET name=?, email=?, phone=?, address=? WHERE id=?")) {
                st.setString(1, client.getName());
                st.setString(2, client.getEmail());
                st.setString(3, client.getPhone());
                st.setString(4, client.getAddress());
                st.setInt(5, client.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int clientId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM clients WHERE id=?")) {
                st.setInt(1, clientId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Clients> listar(String name) throws Exception {
        List<Clients> lista = new ArrayList<>();
        try {
            this.Conectar();
            String query = name == null || name.isEmpty() ? "SELECT * FROM clients" : "SELECT * FROM clients WHERE name ILIKE ?";
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement(query)) {
                if (name != null && !name.isEmpty()) {
                    st.setString(1, "%" + name + "%");
                }
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Clients c = new Clients();
                        c.setId(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setEmail(rs.getString("email"));
                        c.setPhone(rs.getString("phone"));
                        c.setAddress(rs.getString("address"));
                        lista.add(c);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Clients getClientById(int clientId) throws Exception {
        Clients c = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM clients WHERE id=?")) {
                st.setInt(1, clientId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        c = new Clients();
                        c.setId(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setEmail(rs.getString("email"));
                        c.setPhone(rs.getString("phone"));
                        c.setAddress(rs.getString("address"));
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return c;
    }
}
