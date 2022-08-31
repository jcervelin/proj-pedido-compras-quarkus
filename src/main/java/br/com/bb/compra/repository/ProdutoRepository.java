package br.com.bb.compra.repository;

import br.com.bb.compra.model.entity.ProdutoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepositoryBase<ProdutoEntity, Long> {

}
