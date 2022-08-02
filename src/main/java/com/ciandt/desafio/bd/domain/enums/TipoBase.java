package com.ciandt.desafio.bd.domain.enums;

public enum TipoBase {
    IOGURTE("IOGURTE"), SORVETE("SORVETE"), LEITE("LEITE");

    private final String valor;

    TipoBase(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}