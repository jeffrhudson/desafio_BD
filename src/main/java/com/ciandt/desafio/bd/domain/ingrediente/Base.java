package com.ciandt.desafio.bd.domain.ingrediente;

import com.ciandt.desafio.bd.domain.enums.TipoBase;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("base")
public class Base extends Ingrediente<TipoBase> {

    @Enumerated(EnumType.STRING)
    private TipoBase tipoBase;

    @Override
    public String toString() {
        return this.tipoBase.toString();
    }

    @Override
    public TipoBase obterTipo() {
        return this.tipoBase;
    }
}
