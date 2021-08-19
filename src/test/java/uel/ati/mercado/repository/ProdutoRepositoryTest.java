package uel.ati.mercado.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uel.ati.mercado.model.Email;
import uel.ati.mercado.model.EmailValidator;
import uel.ati.mercado.model.Produto;

import javax.inject.Inject;

import static org.junit.Assert.*;
@RunWith(Arquillian.class)
public class ProdutoRepositoryTest {
    @Inject
    private ProdutoRepository produtoRepository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ProdutoRepository.class)
                .addClass(Produto.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }


    @Test
    public void create() throws Exception {
        Produto produto = new Produto("01", 0.2, "maca", "fruta");
        produtoRepository.create(produto);
        produto = produtoRepository.find(produto.getId());
    }
    @Test
    public void testValidation() throws Exception {
        Produto produto = new Produto("02", 0.2, "maca", "fruta");
        produtoRepository.create(produto);
    }
}