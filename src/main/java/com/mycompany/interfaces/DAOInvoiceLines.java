package com.mycompany.interfaces;

import com.mycompany.models.InvoiceLines;
import java.util.List;

public interface DAOInvoiceLines {
    void registrar(InvoiceLines line) throws Exception;
    void modificar(InvoiceLines line) throws Exception;
    void eliminar(int lineId) throws Exception;
    List<InvoiceLines> listarPorFactura(int invoiceId) throws Exception;
    InvoiceLines getLineById(int lineId) throws Exception;
}
