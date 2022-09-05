package br.com.bb.compra.repository;

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

    @Transactional
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

    public ClienteEntity findByEmail(String email) {
        final TypedQuery<ClienteEntity> typedQuery =
                em.createQuery("select c from ClienteEntity c where c.email = :email", ClienteEntity.class)
                        .setParameter("email", email);
        return typedQuery.getSingleResult();
    }

}
