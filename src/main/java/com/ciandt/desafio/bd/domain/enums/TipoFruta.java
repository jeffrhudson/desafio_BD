package com.ciandt.desafio.bd.domain.enums;

public enum TipoFruta {
    MORANGO("MORANGO"), BANANA("BANANA"), ABACATE("ABACATE");

    private final String valor;

    TipoFruta(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }
}