package com.ciandt.desafio.bd.domain.ingrediente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="ingrediente_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Ingrediente <T> implements Comparable<Ingrediente<T>> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    T obterTipo() {
        return null;
    }

    @Override
    public int compareTo(Ingrediente<T> ingrediente) {
        return this.obterTipo().toString().compareToIgnoreCase(ingrediente.obterTipo().toString());
    }
}
