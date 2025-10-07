package com.mycompany.interfaces;

import com.mycompany.models.Clients;
import java.util.List;

public interface DAOClients {
    void registrar(Clients client) throws Exception;
    void modificar(Clients client) throws Exception;
    void eliminar(int clientId) throws Exception;
    List<Clients> listar(String name) throws Exception;
    Clients getClientById(int clientId) throws Exception;
}
