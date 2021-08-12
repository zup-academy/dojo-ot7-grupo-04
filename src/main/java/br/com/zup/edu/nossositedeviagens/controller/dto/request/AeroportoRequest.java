package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.validator.ExistIdValue;
import br.com.zup.edu.nossositedeviagens.validator.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportoRequest {

    @NotBlank @UniqueValue(domainClass = Aeroporto.class, fieldName = "nome")
    private String nome;

    @NotNull @ExistIdValue(dommainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public AeroportoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Aeroporto toModel(EntityManager manager){
        Pais pais = manager.find(Pais.class, paisId);

        return new Aeroporto(nome, pais);
    }
}
