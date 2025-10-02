package com.mycompany.interfaces;

import com.mycompany.models.InventoryProducts;
import java.util.List;

public interface DAOInventoryProducts {
    void registrar(InventoryProducts product) throws Exception;
    void modificar(InventoryProducts product) throws Exception;
    void eliminar(int productId) throws Exception;
    List<InventoryProducts> listar(String name) throws Exception;
    InventoryProducts getProductById(int productId) throws Exception;
}
