package com.ciandt.desafio.bd.exception;

public class NaoExisteOuQuantidadeInvalidaException extends IllegalArgumentException {
    static final String MESSAGE = "_Ingrediente não encontrado ou quantidade inválida_";

    public NaoExisteOuQuantidadeInvalidaException(){
        super(MESSAGE);
    }
}
