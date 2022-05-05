package com.dio.santander.repository;

import com.dio.santander.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
