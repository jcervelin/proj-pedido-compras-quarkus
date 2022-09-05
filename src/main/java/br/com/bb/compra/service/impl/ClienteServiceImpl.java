package br.com.bb.compra.service.impl;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;
import br.com.bb.compra.repository.ClienteRepository;
import br.com.bb.compra.service.ClienteService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

import static br.com.bb.compra.converter.ClienteConverter.convertDtoTo;
import static br.com.bb.compra.converter.ClienteConverter.convertEntityTo;

@ApplicationScoped
@Named("clienteServiceImpl")
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(convertDtoTo(cliente));
    }

    @Override
    public List<Cliente> getClientes() {
        return convertEntityTo(clienteRepository.findAll());
    }

    @Override
    public Cliente findByEmail(String email) {
        final ClienteEntity entity = clienteRepository.findByEmail(email);
        return convertEntityTo(entity);
    }
}