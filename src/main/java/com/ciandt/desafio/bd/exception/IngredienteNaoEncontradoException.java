package com.ciandt.desafio.bd.exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException {
    static final String MESSAGE = "_Ingrediente não encontrado_";

    public IngredienteNaoEncontradoException(){
        super(MESSAGE);
    }
}
