package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public AeroportoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }
}
