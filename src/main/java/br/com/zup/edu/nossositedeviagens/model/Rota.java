package br.com.zup.edu.nossositedeviagens.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.Duration;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nomeRota;

    @NotNull
    @ManyToOne
    private Aeroporto aeroportoOrigem;

    @NotNull
    @ManyToOne
    private Aeroporto aeroportoDestino;

    @NotNull
    @Positive
    private Duration duracao;

    public Rota(String nomeRota, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Duration duracao) {
        this.nomeRota = nomeRota;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;

    }

    public Long getId() {
        return id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Duration getDuracao() {
        return duracao;
    }
}
