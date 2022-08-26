package br.com.bb.compras.service.impl;

import br.com.bb.compras.model.Cliente;
import br.com.bb.compras.service.ClienteService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class ClienteServiceInMemory implements ClienteService {

    private static Map<Long, Cliente> MAP = new HashMap<>();
    private static AtomicLong GERADOR_ID = new AtomicLong();

    public Cliente salvarCliente(Cliente cliente) {
        cliente.setId(GERADOR_ID.incrementAndGet());
        MAP.put(cliente.getId(), cliente);
        return cliente;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(MAP.values());
    }

}
