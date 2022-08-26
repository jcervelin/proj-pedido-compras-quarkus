package br.com.bb.compras.service;

import br.com.bb.compras.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente);
    List<Cliente> getClientes();
}
