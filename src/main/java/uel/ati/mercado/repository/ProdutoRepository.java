package uel.ati.mercado.repository;
import uel.ati.mercado.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ProdutoRepository {
    @PersistenceContext(unitName ="MercadoPU")
    private EntityManager em;

    @Transactional(REQUIRED)
    public Produto find(Long id){
        return em.find(Produto.class,id);
    }
    @Transactional(REQUIRED)
    public Produto create(Produto produto){
        em.persist(produto);
        return produto;
    }
    @Transactional(REQUIRED)
    public void delete(Long id){
        em.remove(em.getReference(Produto.class,id));
    }

    @Transactional(SUPPORTS)
    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Produto p", Long.class);
        return query.getSingleResult();
    }

    @Transactional(SUPPORTS)
    public List<Produto> findAll(){
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p order by p.descricao",Produto.class);
        return query.getResultList();
    }
}
