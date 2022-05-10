package com.dio.santander.services;

import com.dio.santander.dto.MovimentacaoDTO;
import com.dio.santander.models.Correntista;
import com.dio.santander.models.Movimentacao;
import com.dio.santander.models.MovimentacaoTipo;
import com.dio.santander.repository.CorrentistaRepository;
import com.dio.santander.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = new Movimentacao();

        Double valor = movimentacaoDTO.getMovimentacaoTipo()== MovimentacaoTipo.RECEITA ? movimentacaoDTO.getValor() : movimentacaoDTO.getValor() * -1;

        movimentacao.setDescricao(movimentacaoDTO.getDescricao());
        movimentacao.setValor(valor);
        movimentacao.setMovimentacaoTipo(movimentacaoDTO.getMovimentacaoTipo());
        movimentacao.setIdConta(movimentacao.getIdConta());
        movimentacao.setDataHora(LocalDateTime.now());

        Correntista correntista = correntistaRepository.findById(movimentacaoDTO.getIdConta()).orElse(null);
        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }

}
