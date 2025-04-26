package com.iventario.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPatrimonio(
        @NotNull
        Long id,
        String nome,
        String descricao,
        String localizacao) {
}
