package br.com.bb.compras.controller;

import br.com.bb.compras.model.Cliente;
import br.com.bb.compras.service.ClienteService;
import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class ClienteResource {

    private final ClienteService clienteService;

    @GET
    public List<Cliente> clientes() {
        return clienteService.getClientes();
    }

    @POST
    public Response criarCliente(@Valid Cliente cliente) {
        final Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        return Response.ok(clienteSalvo)
                .build();
    }

}