package com.ciandt.desafio.bd.repository;

import com.ciandt.desafio.bd.domain.ingrediente.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdicionalRepository extends JpaRepository<Adicional, Long> {
}
