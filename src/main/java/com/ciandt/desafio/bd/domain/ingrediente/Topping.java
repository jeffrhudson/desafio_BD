package com.ciandt.desafio.bd.domain.ingrediente;

import com.ciandt.desafio.bd.domain.enums.TipoTopping;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("topping")
public class Topping extends Ingrediente<TipoTopping> {

    private TipoTopping tipoTopping;

    @Override
    public String toString() {
        return this.tipoTopping.toString();
    }

    @Override
    public TipoTopping obterTipo() {
        return this.tipoTopping;
    }
}
