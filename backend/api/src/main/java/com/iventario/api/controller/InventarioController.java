package com.iventario.api.controller;

import com.iventario.api.dto.DadosAtualizacaoPatrimonio;
import com.iventario.api.dto.DadosCadastroPatrimonio;
import com.iventario.api.dto.DadosListagemPatrimonio;
import com.iventario.api.model.Patrimonio;
import com.iventario.api.repository.PatrimonioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("inventario")
public class InventarioController {

    @Autowired
    PatrimonioRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPatrimonio dados){
        repository.save(new Patrimonio(dados));
    }

    @GetMapping
    public Page<DadosListagemPatrimonio> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPatrimonio::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPatrimonio dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);

    }
}
