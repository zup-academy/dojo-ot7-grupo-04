package br.com.zup.edu.nossositedeviagens.controller.dto.response;

import br.com.zup.edu.nossositedeviagens.model.Rota;

import java.time.Duration;

public class RotaResponse {
    private  Long id;

    private String nomeRota;

    private String aeroportoOrigem;

    private String aeroportoDestino;

    private Duration duracao;

    public RotaResponse(Rota rota) {

        this.id = rota.getId();
        this.nomeRota = rota.getNomeRota();
        this.aeroportoOrigem = rota.getAeroportoOrigem().getNome();
        this.aeroportoDestino = rota.getAeroportoDestino().getNome();
        this.duracao = rota.getDuracao();
    }

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

    public Duration getDuracao() {
        return duracao;
    }
}
