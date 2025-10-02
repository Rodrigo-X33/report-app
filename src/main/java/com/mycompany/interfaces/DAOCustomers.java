package com.mycompany.interfaces;

import com.mycompany.models.Customers;
import java.util.List;

public interface DAOCustomers {
    void registrar(Customers customer) throws Exception;
    void modificar(Customers customer) throws Exception;
    void eliminar(int customerId) throws Exception;
    List<Customers> listar(String name) throws Exception;
    Customers getCustomerById(int customerId) throws Exception;
}
