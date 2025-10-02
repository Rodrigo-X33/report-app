package com.mycompany.interfaces;

import com.mycompany.models.Purchases;
import java.util.List;

public interface DAOPurchases {
    void registrar(Purchases purchase) throws Exception;
    void modificar(Purchases purchase) throws Exception;
    void eliminar(int purchaseId) throws Exception;
    List<Purchases> listar() throws Exception;
    Purchases getPurchaseById(int purchaseId) throws Exception;
}
