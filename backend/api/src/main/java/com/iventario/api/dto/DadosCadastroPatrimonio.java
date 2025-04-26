package com.iventario.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPatrimonio(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String localizacao) {

}
