package uel.ati.mercado.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @NotNull
    private long id;
    @Column (length = 100)
    @NotNull
    private String codigo;
    @Column
    private double preco;
    @Column
    private String nome;
    @Column
    private String descricao;

    public Produto(String codigo, double preco) {
        this.codigo = codigo;
        this.preco = preco;
    }

    public Produto(String codigo, double preco, String nome, String descricao) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto() {

    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
