package com.ciandt.desafio.bd.repository;

import com.ciandt.desafio.bd.domain.ingrediente.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository<T extends Ingrediente> extends JpaRepository<T, Long> {
}
