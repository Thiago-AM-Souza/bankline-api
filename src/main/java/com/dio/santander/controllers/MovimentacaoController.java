package com.dio.santander.controllers;


import com.dio.santander.dto.MovimentacaoDTO;
import com.dio.santander.models.Movimentacao;
import com.dio.santander.repository.MovimentacaoRepository;
import com.dio.santander.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacao){
        service.save(movimentacao);
    }
}
