package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotasRepository;
import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import java.time.Duration;
import java.time.LocalDateTime;

public class RotaRequest {


    private String nomeRota;

    @NotNull
    private Long aeroportoOrigem;

    @NotNull
    private Long aeroportoDestino;

    @NotNull
    @Positive
    private Duration duracao;

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

    public Rota toModel(AeroportoRepository aeroportoRepository) {

        Aeroporto aeroportoOrigem = aeroportoRepository.findById(this.aeroportoOrigem).get();
        Aeroporto aeroportoDestino = aeroportoRepository.findById(this.aeroportoDestino).get();

        if(nomeRota.isBlank()){

        }
        return new Rota(this.nomeRota);
    }
}
