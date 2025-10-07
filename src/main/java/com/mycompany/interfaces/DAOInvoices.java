package com.mycompany.interfaces;

import com.mycompany.models.Invoices;
import java.util.List;

public interface DAOInvoices {
    void registrar(Invoices invoice) throws Exception;
    void modificar(Invoices invoice) throws Exception;
    void eliminar(int invoiceId) throws Exception;
    List<Invoices> listar() throws Exception;
    Invoices getInvoiceById(int invoiceId) throws Exception;
}
