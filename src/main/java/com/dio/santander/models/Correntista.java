package com.dio.santander.models;

import javax.persistence.*;

@Entity
@Table(name = "tab_correntista")
public class Correntista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String cpf;
    @Column(length = 60)
    private String nome;
    @Embedded
    private Conta conta;

    public Correntista(){
    }

    public Correntista(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
