package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOPurchases;
import com.mycompany.models.Purchases;
// imports PreparedStatement/ResultSet are used via fully-qualified names in try-with-resources
import java.util.ArrayList;
import java.util.List;

public class DAOPurchasesImpl extends Database implements DAOPurchases {
    @Override
    public void registrar(Purchases purchase) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO purchases(supplier_id, product_id, quantity, purchase_date, total_cost, notes) VALUES(?,?,?,?,?,?)")) {
                st.setInt(1, purchase.getSupplierId());
                st.setInt(2, purchase.getProductId());
                st.setInt(3, purchase.getQuantity());
                st.setDate(4, purchase.getPurchaseDate());
                st.setDouble(5, purchase.getTotalCost());
                st.setString(6, purchase.getNotes());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Purchases purchase) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE purchases SET supplier_id=?, product_id=?, quantity=?, purchase_date=?, total_cost=?, notes=? WHERE id=?")) {
                st.setInt(1, purchase.getSupplierId());
                st.setInt(2, purchase.getProductId());
                st.setInt(3, purchase.getQuantity());
                st.setDate(4, purchase.getPurchaseDate());
                st.setDouble(5, purchase.getTotalCost());
                st.setString(6, purchase.getNotes());
                st.setInt(7, purchase.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int purchaseId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM purchases WHERE id=?")) {
                st.setInt(1, purchaseId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Purchases> listar() throws Exception {
        List<Purchases> lista = new ArrayList<>();
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM purchases")) {
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Purchases p = new Purchases();
                        p.setId(rs.getInt("id"));
                        p.setSupplierId(rs.getInt("supplier_id"));
                        p.setProductId(rs.getInt("product_id"));
                        p.setQuantity(rs.getInt("quantity"));
                        p.setPurchaseDate(rs.getDate("purchase_date"));
                        p.setTotalCost(rs.getDouble("total_cost"));
                        p.setNotes(rs.getString("notes"));
                        lista.add(p);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Purchases getPurchaseById(int purchaseId) throws Exception {
        Purchases p = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM purchases WHERE id=?")) {
                st.setInt(1, purchaseId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        p = new Purchases();
                        p.setId(rs.getInt("id"));
                        p.setSupplierId(rs.getInt("supplier_id"));
                        p.setProductId(rs.getInt("product_id"));
                        p.setQuantity(rs.getInt("quantity"));
                        p.setPurchaseDate(rs.getDate("purchase_date"));
                        p.setTotalCost(rs.getDouble("total_cost"));
                        p.setNotes(rs.getString("notes"));
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return p;
    }
}
