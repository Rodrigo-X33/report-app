package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Users;
// imports PreparedStatement/ResultSet are used via fully-qualified names in try-with-resources
import java.util.ArrayList;
import java.util.List;

// some comment
//Emily

public class DAOUsersImpl extends Database implements DAOUsers {

    @Override
    public void registrar(Users user) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users(name, last_name_p, last_name_m, domicilio, tel) VALUES(?,?,?,?,?)")) {
                st.setString(1, user.getName());
                st.setString(2, user.getLast_name_p());
                st.setString(3, user.getLast_name_m());
                st.setString(4, user.getDomicilio());
                st.setString(5, user.getTel());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Users user) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE users SET name = ?, last_name_p = ?, last_name_m = ?, domicilio = ?, tel = ? WHERE id = ?")) {
                st.setString(1, user.getName());
                st.setString(2, user.getLast_name_p());
                st.setString(3, user.getLast_name_m());
                st.setString(4, user.getDomicilio());
                st.setString(5, user.getTel());
                st.setInt(6, user.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int userId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM users WHERE id = ?")) {
                st.setInt(1, userId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Users> listar(String name) throws Exception {
        List<Users> lista = null;
        try {
            this.Conectar();
            String Query = name.isEmpty() ? "SELECT * FROM users" : "SELECT * FROM users WHERE name ILIKE ?";
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement(Query)) {
                if (!name.isEmpty()) {
                    st.setString(1, "%" + name + "%");
                }
                lista = new ArrayList<>();
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Users user = new Users();
                        user.setId(rs.getInt("id"));
                        user.setName(rs.getString("name"));
                        user.setLast_name_p(rs.getString("last_name_p"));
                        user.setLast_name_m(rs.getString("last_name_m"));
                        user.setDomicilio(rs.getString("domicilio"));
                        user.setTel(rs.getString("tel"));
                        user.setSanctions(rs.getInt("sanctions"));
                        user.setSanc_money(rs.getInt("sanc_money"));
                        lista.add(user);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Users getUserById(int userId) throws Exception {
        Users user = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users WHERE id = ? LIMIT 1")) {
                st.setInt(1, userId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        user = new Users();
                        user.setId(rs.getInt("id"));
                        user.setName(rs.getString("name"));
                        user.setLast_name_p(rs.getString("last_name_p"));
                        user.setLast_name_m(rs.getString("last_name_m"));
                        user.setDomicilio(rs.getString("domicilio"));
                        user.setTel(rs.getString("tel"));
                        user.setSanctions(rs.getInt("sanctions"));
                        user.setSanc_money(rs.getInt("sanc_money"));
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return user;
    }

    @Override
    public void sancionar(Users user) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE users SET sanctions = ?, sanc_money = ? WHERE id = ?")) {
                st.setInt(1, user.getSanctions());
                st.setInt(2, user.getSanc_money());
                st.setInt(3, user.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }
    
}
