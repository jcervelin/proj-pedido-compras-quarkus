package br.com.bb.compra.service.impl;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;
import br.com.bb.compra.model.enums.PerfilEnum;
import br.com.bb.compra.repository.ClienteRepository;
import br.com.bb.compra.security.PasswordUtils;
import br.com.bb.compra.service.ClienteService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

import static br.com.bb.compra.converter.ClienteConverter.convertDtoTo;
import static br.com.bb.compra.converter.ClienteConverter.convertEntityTo;

@ApplicationScoped
@Named("clienteServiceImpl")
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public void salvarCliente(Cliente cliente) {
        cliente.setPerfil(PerfilEnum.CLIENTE);

        if (Objects.isNull(cliente.getId())) {
            cliente.setSenha(PasswordUtils.encode(cliente.getSenha()));
            final ClienteEntity entidadeNaoGerenciada = convertDtoTo(cliente);
            clienteRepository.save(entidadeNaoGerenciada);
        } else {
            ClienteEntity entity = clienteRepository.findById(cliente.getId());
            entity.setNome(cliente.getNome());
            entity.setEmail(cliente.getEmail());
        }
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