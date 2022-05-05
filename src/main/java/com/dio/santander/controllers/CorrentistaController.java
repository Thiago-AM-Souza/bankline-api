package com.dio.santander.controllers;

import com.dio.santander.repository.CorrentistaRepository;
import com.dio.santander.services.CorrentistaService;
import com.dio.santander.dto.CorrentistaDTO;
import com.dio.santander.models.Correntista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntista){
        service.save(correntista);
    }


}
