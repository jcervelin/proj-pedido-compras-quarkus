package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ProdutoConverter;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

//@RequestScoped para cada request
//@SessionScoped para cada sessao => cookie JSESSIONID
//@Singleton instancia classe no startup
//@ApplicationScoped instancia quando voce usa pela primeira vez => cria uma classe proxy

@ApplicationScoped
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    @Override
    @Transactional
    public Produto salvar(Produto novoProduto) {
        final ProdutoEntity produtoEntity = ProdutoConverter.convertProductTo(novoProduto);
        repository.persist(produtoEntity);
        return ProdutoConverter.convertEntityTo(produtoEntity);
    }

    @Override
    @Transactional
    public List<Produto> salvarLista(List<Produto> novoProduto) {
        final List<ProdutoEntity> produtoEntityList = ProdutoConverter.convertProductTo(novoProduto);
        repository.persist(produtoEntityList);
        return ProdutoConverter.convertEntityTo(produtoEntityList);
    }

    @Override
    public Produto buscaPorId(Long id) {
        final ProdutoEntity produtoSalvo = repository.findById(id);
        if (produtoSalvo.getId() == null) {
            throw new RuntimeException();
        }
        return ProdutoConverter.convertEntityTo(produtoSalvo);
    }

    @Override
    public boolean isEmpty() {
        return repository.count() == 0;
    }


}
