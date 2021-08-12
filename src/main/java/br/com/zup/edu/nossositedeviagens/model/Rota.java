package br.com.zup.edu.nossositedeviagens.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nomeRota;

    @NotNull
    private Long aeroportoOrigem;

    @NotNull
    private Long aeroportoDestino;

    @NotNull
    @Positive
    private Duration duracao;

    public Rota(String nomeRota) {
    }

    public Long getId() {
        return id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public Long getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Long getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Duration getDuracao() {
        return duracao;
    }
}
