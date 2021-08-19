package uel.ati.mercado.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @NotNull
    private Long id;
    @Column
    @NotNull
    private String nome;
    @Column
    @Email
    private String email;
    @Column
    private Calendar nascimento;
    @Column
    private String telefone;
    @Column
    @NotNull
    private String cpf;

    public Pessoa(String name, String email, Calendar nascimento, String telefone, String cpf) {
        this.nome = name;
        this.email = email;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String namo) {
        this.nome = namo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
