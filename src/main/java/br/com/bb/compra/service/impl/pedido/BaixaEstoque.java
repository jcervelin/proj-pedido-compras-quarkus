package br.com.bb.compra.service.impl.pedido;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.PedidoEntity;
import br.com.bb.compra.model.entity.StatusPedidoTipo;
import br.com.bb.compra.service.ProdutoService;
import io.quarkus.arc.Priority;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Priority(1)
public class BaixaEstoque implements ProcessamentoPedido {

    @Override
    @Transactional
    public void processar(PedidoEntity pedido) {

        if (!StatusPedidoTipo.NOVO.equals(pedido.getStatus())) {
            return;
        }

        pedido.getItens()
                .forEach(item ->
                    item.getProduto().setEstoque(item.getProduto().getEstoque() - item.getQuantidade())
                );
    }
}
