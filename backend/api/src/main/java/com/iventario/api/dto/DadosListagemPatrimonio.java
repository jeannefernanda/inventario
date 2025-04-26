package com.iventario.api.dto;

import com.iventario.api.model.Patrimonio;

public record DadosListagemPatrimonio(Long id, String nome, String descricao, String localizacao) {
    public DadosListagemPatrimonio(Patrimonio patrimonio){
        this(patrimonio.getId(), patrimonio.getNome(),
                patrimonio.getDescricao(),
                patrimonio.getLocalizacao());
    }
}
