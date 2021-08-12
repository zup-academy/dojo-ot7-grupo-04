package br.com.zup.edu.nossositedeviagens.controller.dto.response;

import java.time.LocalDateTime;

public class RotaResponse {
    private  Long id;

    private String nomeRota;

    private String aeroportoOrigem;

    private String aeroportoDestino;

    private LocalDateTime duracao;

    public Long getId() {
        return id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public LocalDateTime getDuracao() {
        return duracao;
    }
}
