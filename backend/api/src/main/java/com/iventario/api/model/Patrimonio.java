package com.iventario.api.model;

import com.iventario.api.dto.DadosAtualizacaoPatrimonio;
import com.iventario.api.dto.DadosCadastroPatrimonio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patrimonios")
@Entity(name = "Patrimonio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String localizacao;

    public Patrimonio(DadosCadastroPatrimonio dados) {
        this.nome = dados.nome();;
        this.descricao = dados.descricao();
        this.localizacao = dados.localizacao();
    }

    public void atualizarInformacoes(DadosAtualizacaoPatrimonio dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }

        if(dados.localizacao() != null){
            this.localizacao = dados.localizacao();
        }

    }
}
