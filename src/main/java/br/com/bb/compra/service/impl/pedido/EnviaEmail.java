package br.com.bb.compra.service.impl.pedido;

import br.com.bb.compra.model.entity.PedidoEntity;
import io.quarkus.arc.Priority;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Priority(3)
public class EnviaEmail implements ProcessamentoPedido {

    @Override
    @Transactional
    public void processar(PedidoEntity pedido) {
        System.out.println("Pedido enviado " + pedido);
    }
}
