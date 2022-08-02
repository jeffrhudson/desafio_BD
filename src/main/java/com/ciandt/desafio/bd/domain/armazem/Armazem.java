package com.ciandt.desafio.bd.domain.armazem;

import com.ciandt.desafio.bd.domain.ingrediente.Ingrediente;
import com.ciandt.desafio.bd.exception.IngredienteCadastradoException;
import com.ciandt.desafio.bd.exception.IngredienteNaoEncontradoException;
import com.ciandt.desafio.bd.exception.NaoExisteOuQuantidadeInvalidaException;

import java.util.Map;
import java.util.TreeMap;

public class Armazem {
    private final Map<Ingrediente<?>, Integer> estoque;

    public Armazem(){
        this.estoque = new TreeMap<>();
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente<?> ingrediente) throws IngredienteCadastradoException {
        if (estoque.containsKey(ingrediente)) {
            throw new IngredienteCadastradoException();
        }
        estoque.put(ingrediente, 0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente<?> ingrediente) throws IngredienteNaoEncontradoException {
        if (!estoque.containsKey(ingrediente)) {
            throw new IngredienteNaoEncontradoException();
        }
        estoque.remove(ingrediente);
    }

    public Map<Ingrediente<?>, Integer> getEstoque() {
        return estoque;
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente<?> ingrediente, Integer quantidadeAdicionada) throws NaoExisteOuQuantidadeInvalidaException {
        if (quantidadeAdicionada <= 0 || !estoque.containsKey(ingrediente)){
            throw new NaoExisteOuQuantidadeInvalidaException();
        }

        estoque.computeIfPresent(ingrediente, (key, value) -> value + quantidadeAdicionada);

    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente<?> ingrediente, Integer quantidadeReduzida) throws NaoExisteOuQuantidadeInvalidaException{
        if (quantidadeReduzida <= 0 || !estoque.containsKey(ingrediente) || estoque.get(ingrediente) - quantidadeReduzida < 0){
            throw new NaoExisteOuQuantidadeInvalidaException();
        }

        estoque.computeIfPresent(ingrediente, (key, value) -> value - quantidadeReduzida);
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente<?> ingrediente) throws IngredienteNaoEncontradoException{
        if (!estoque.containsKey(ingrediente)){
            throw new IngredienteNaoEncontradoException();
        }

        return estoque.get(ingrediente);
    }
}
