package br.com.bb.compra.service.impl;

import br.com.bb.compra.model.PedidoRequestDto;
import br.com.bb.compra.model.PedidoResponseDto;
import br.com.bb.compra.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    final JsonWebToken accessToken;
    @Override
    public PedidoResponseDto realizarPedido(PedidoRequestDto pedido) {
        final String email = accessToken.getSubject();
        log.info("O usuario {} iniciou pedido {}", email, pedido);
        return null;
    }
}
