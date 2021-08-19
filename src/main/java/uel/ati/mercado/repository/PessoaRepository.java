package uel.ati.mercado.repository;
import uel.ati.mercado.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class PessoaRepository {
    @PersistenceContext(unitName ="MercadoPU")
    private EntityManager em;

    @Transactional(REQUIRED)
    public Pessoa find(Long id){
        return em.find(Pessoa.class,id);
    }
    @Transactional(REQUIRED)
    public Pessoa create(Pessoa produto){
        em.persist(produto);
        return produto;
    }
    @Transactional(REQUIRED)
    public void delete(Long id){
        em.remove(em.getReference(Pessoa.class,id));
    }

    @Transactional(SUPPORTS)
    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Pessoa p", Long.class);
        return query.getSingleResult();
    }

    @Transactional(SUPPORTS)
    public List<Pessoa> findAll(){
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p order by p.nome",Pessoa.class);
        return query.getResultList();
    }
}
