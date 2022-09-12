package br.com.bb.compra.repository;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @Inject
    EntityManager em;

    public void save(ClienteEntity entity) {
        em.persist(entity);
    }

    public ClienteEntity findById(Long id) {
        return em.find(ClienteEntity.class, id);
    }

    public List<ClienteEntity> findAll() {
        final TypedQuery<ClienteEntity> typedQuery = em.createQuery("select c from ClienteEntity c", ClienteEntity.class);
        return typedQuery.getResultList();
    }

    @Transactional
    public ClienteEntity findByEmail(String email) {
        final TypedQuery<ClienteEntity> typedQuery =
                em.createQuery("select c from ClienteEntity c where c.email = :email", ClienteEntity.class)
                        .setParameter("email", email);
        return typedQuery.getSingleResult();
    }

    public List<String> findByEmailNamedQuery(String email) {
        List<String> cpfByEmail = em.createNamedQuery("CpfByEmail", String.class)
                .setParameter("email", email)
                .getResultList();
        return cpfByEmail;
    }

    public List<Cliente> mapCliente(String nome) {
        List<Cliente> mapCliente = em.createNamedQuery("mapCliente", Cliente.class)
                .setParameter("nome",  nome)
                .getResultList();
        return mapCliente;
    }
}
