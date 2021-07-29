package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanhiaRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public CompanhiaRequest(@NotBlank String nome,
                            @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Companhia toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);

        return new Companhia(nome, pais);
    }
}
