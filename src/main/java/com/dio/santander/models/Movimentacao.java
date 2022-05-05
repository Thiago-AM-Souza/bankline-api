package com.dio.santander.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo movimentacaoTipo;

    @Column(name = "id_conta")
    private Integer idConta;

    public Movimentacao() {
    }

    public Movimentacao(Integer id, LocalDateTime dataHora, String descricao, Double valor, MovimentacaoTipo movimentacaoTipo) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.valor = valor;
        this.movimentacaoTipo = movimentacaoTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getMovimentacaoTipo() {
        return movimentacaoTipo;
    }

    public void setMovimentacaoTipo(MovimentacaoTipo movimentacaoTipo) {
        this.movimentacaoTipo = movimentacaoTipo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }
}
