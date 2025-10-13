package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOInventoryProducts;
import com.mycompany.models.InventoryProducts;
// imports PreparedStatement/ResultSet are used via fully-qualified names in try-with-resources
import java.util.ArrayList;
import java.util.List;

public class DAOInventoryProductsImpl extends Database implements DAOInventoryProducts {
    @Override
    public void registrar(InventoryProducts product) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("INSERT INTO inventory_products(product_name, stock, price, supplier_id) VALUES(?,?,?,?)")) {
                st.setString(1, product.getProductName());
                st.setInt(2, product.getStock());
                st.setDouble(3, product.getPrice());
                if (product.getSupplierId() != null) {
                    st.setInt(4, product.getSupplierId());
                } else {
                    st.setNull(4, java.sql.Types.INTEGER);
                }
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(InventoryProducts product) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("UPDATE inventory_products SET product_name=?, stock=?, price=?, supplier_id=? WHERE id=?")) {
                st.setString(1, product.getProductName());
                st.setInt(2, product.getStock());
                st.setDouble(3, product.getPrice());
                if (product.getSupplierId() != null) {
                    st.setInt(4, product.getSupplierId());
                } else {
                    st.setNull(4, java.sql.Types.INTEGER);
                }
                st.setInt(5, product.getId());
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int productId) throws Exception {
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("DELETE FROM inventory_products WHERE id=?")) {
                st.setInt(1, productId);
                st.executeUpdate();
            }
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<InventoryProducts> listar(String name) throws Exception {
        List<InventoryProducts> lista = new ArrayList<>();
        try {
            this.Conectar();
            String query = name == null || name.isEmpty() ? "SELECT * FROM inventory_products" : "SELECT * FROM inventory_products WHERE product_name ILIKE ?";
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement(query)) {
                if (name != null && !name.isEmpty()) {
                    st.setString(1, "%" + name + "%");
                }
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        InventoryProducts p = new InventoryProducts();
                        p.setId(rs.getInt("id"));
                        p.setProductName(rs.getString("product_name"));
                        p.setStock(rs.getInt("stock"));
                        p.setPrice(rs.getDouble("price"));
                        int sid = rs.getInt("supplier_id");
                        p.setSupplierId(rs.wasNull() ? null : sid);
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
    public InventoryProducts getProductById(int productId) throws Exception {
        InventoryProducts p = null;
        try {
            this.Conectar();
            try (java.sql.PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM inventory_products WHERE id=?")) {
                st.setInt(1, productId);
                try (java.sql.ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        p = new InventoryProducts();
                        p.setId(rs.getInt("id"));
                        p.setProductName(rs.getString("product_name"));
                        p.setStock(rs.getInt("stock"));
                        p.setPrice(rs.getDouble("price"));
                        int sid = rs.getInt("supplier_id");
                        p.setSupplierId(rs.wasNull() ? null : sid);
                    }
                }
            }
        } finally {
            this.Cerrar();
        }
        return p;
    }
}
