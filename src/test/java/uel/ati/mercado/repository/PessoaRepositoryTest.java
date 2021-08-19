package uel.ati.mercado.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uel.ati.mercado.model.Pessoa;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(Arquillian.class)
public class PessoaRepositoryTest {
    @Inject
    private PessoaRepository pessoaRepository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(PessoaRepository.class)
                .addClass(Pessoa.class)
                .addClass(Calendar.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }


    @Test
    public void create() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2001,05,12);
        Pessoa pessoa = new Pessoa("Kristiano","kristiano@uel.br",calendar,"(43) 99015-8468","111.222.666-77");
        pessoaRepository.create(pessoa);
        pessoa = pessoaRepository.find(pessoa.getId());
    }
    @Test
    public void testValidation() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2001,05,12);
        Pessoa pessoa = new Pessoa("Kristiano","kristiano@el.br",calendar,"(43) 99015-8468","111.222.666-77");
        pessoaRepository.create(pessoa);
    }
}