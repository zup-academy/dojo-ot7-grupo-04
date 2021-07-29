package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.validator.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanhiaRequest {

    @NotBlank
    @UniqueValue(domainClass = Companhia.class, fieldName = "nome")
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
