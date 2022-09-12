package br.com.bb.compra.resource;

import br.com.bb.compra.model.PedidoRequestDto;
import br.com.bb.compra.model.PedidoResponseDto;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/pedidos")
@RequiredArgsConstructor
@Slf4j
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    @Operation(description = "Realizar pedido de compras")
    @POST
    @RolesAllowed("CLIENTE")
    public Response realizarPedido(
            @Valid PedidoRequestDto request) {
        final PedidoResponseDto response = pedidoService.realizarPedido(request);
        return Response.ok(response).build();
    }
}
