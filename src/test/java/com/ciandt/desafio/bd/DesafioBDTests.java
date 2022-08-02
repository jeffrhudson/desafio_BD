package com.ciandt.desafio.bd;

import com.ciandt.desafio.bd.domain.enums.TipoBase;
import com.ciandt.desafio.bd.domain.enums.TipoFruta;
import com.ciandt.desafio.bd.domain.enums.TipoTopping;
import com.ciandt.desafio.bd.domain.ingrediente.Adicional;
import com.ciandt.desafio.bd.domain.ingrediente.Base;
import com.ciandt.desafio.bd.domain.ingrediente.Fruta;
import com.ciandt.desafio.bd.domain.ingrediente.Ingrediente;
import com.ciandt.desafio.bd.domain.ingrediente.Topping;
import com.ciandt.desafio.bd.repository.AdicionalRepository;
import com.ciandt.desafio.bd.repository.IngredienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DesafioBDTests {
    @Autowired
    IngredienteRepository<Ingrediente> ingredienteRepository;

    @Autowired
    AdicionalRepository adicionalRepository;

    @Autowired
    IngredienteRepository<Base> baseIngredienteRepository;

    @Autowired
    IngredienteRepository<Fruta> frutaIngredienteRepository;

    @Autowired
    IngredienteRepository<Topping> toppingIngredienteRepository;

    static Stream<Ingrediente> ingredienteAdicionarProvider(){
        final var base = new Base(TipoBase.IOGURTE);
        final var fruta = new Fruta(TipoFruta.MORANGO);
        final var topping = new Topping(TipoTopping.CHOCOLATE);
        return Stream.of(base, fruta, topping);
    }

    @Order(1)
    @ParameterizedTest(name = "adicionar ingrediente")
    @MethodSource("ingredienteAdicionarProvider")
    void adicionarIngrediente(Ingrediente ingrediente){
        ingredienteRepository.save(ingrediente);
    }

    @Order(2)
    @ParameterizedTest(name = "adicionar ingrediente adicional")
    @MethodSource("ingredienteAdicionarProvider")
    void adicionarIngredienteAdicional(Ingrediente ingrediente){
        final var adicional = new Adicional(null, ingrediente);
        final var insertedAdicional = adicionalRepository.save(adicional);
    }

    static Stream<Long> ingredienteIdProvider(){
        return Stream.of(1L, 2L, 3L);
    }

    @Order(3)
    @ParameterizedTest(name = "consultar ingrediente")
    @MethodSource("ingredienteIdProvider")
    void consultarIngrediente(Long ingredienteId){
        final var ingrediente = ingredienteRepository.findById(ingredienteId).get();
    }

    @Order(4)
    @ParameterizedTest(name = "remover ingrediente por id")
    @MethodSource("ingredienteIdProvider")
    void removerIngrediente(Long ingredienteId){
        final var ingrediente = ingredienteRepository.findById(ingredienteId).get();
        ingredienteRepository.delete(ingrediente);
    }

}
