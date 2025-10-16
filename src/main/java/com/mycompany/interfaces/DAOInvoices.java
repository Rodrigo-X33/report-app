package com.mycompany.interfaces;

import com.mycompany.models.Invoices;
import java.util.List;

public interface DAOInvoices {
    int registrar(Invoices invoice) throws Exception; // retorna el ID generado
    void modificar(Invoices invoice) throws Exception;
    void eliminar(int invoiceId) throws Exception;
    List<Invoices> listar() throws Exception;
    Invoices getInvoiceById(int invoiceId) throws Exception;
}
