package com.ciandt.desafio.bd.domain.ingrediente;

import com.ciandt.desafio.bd.domain.enums.TipoFruta;
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
@DiscriminatorValue("fruta")
public class Fruta extends Ingrediente<TipoFruta> {

     @Enumerated(EnumType.STRING)
     private TipoFruta tipoFruta;

     @Override
     public String toString() {
          return this.tipoFruta.toString();
     }

     @Override
     public TipoFruta obterTipo() {
          return this.tipoFruta;
     }
}
