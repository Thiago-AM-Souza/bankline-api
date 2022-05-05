package com.dio.santander.services;

import com.dio.santander.repository.CorrentistaRepository;
import com.dio.santander.dto.CorrentistaDTO;
import com.dio.santander.models.Conta;
import com.dio.santander.models.Correntista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save(CorrentistaDTO correntistaDTO){
        Correntista correntista = new Correntista();
        correntista.setCpf(correntistaDTO.getCpf());
        correntista.setNome(correntistaDTO.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
}
