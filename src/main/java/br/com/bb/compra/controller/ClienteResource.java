package br.com.bb.compra.controller;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/clientes")
@Slf4j
public class ClienteResource {

    @Inject
    @Named("clienteServiceImpl")
    ClienteService clienteService;

    @GET
    public List<Cliente> clientes() {
        return clienteService.getClientes();
    }

    @POST
    public Response criarCliente(@Valid Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return Response.ok(cliente)
                .build();
    }

}