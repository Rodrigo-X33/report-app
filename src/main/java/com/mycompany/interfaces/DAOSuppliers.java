package com.mycompany.interfaces;

import com.mycompany.models.Suppliers;
import java.util.List;

public interface DAOSuppliers {
    void registrar(Suppliers supplier) throws Exception;
    void modificar(Suppliers supplier) throws Exception;
    void eliminar(int supplierId) throws Exception;
    List<Suppliers> listar(String name) throws Exception;
    Suppliers getSupplierById(int supplierId) throws Exception;
}
