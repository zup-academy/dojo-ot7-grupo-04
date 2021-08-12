package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.validator.ExistIdValue;
import com.sun.istack.NotNull;

import javax.validation.constraints.Positive;
import java.time.Duration;

public class RotaRequest {


    private String nomeRota;

    @ExistIdValue(dommainClass = Aeroporto.class, fieldName = "id")
    @NotNull
    private Long aeroportoOrigem;

    @ExistIdValue(dommainClass = Aeroporto.class, fieldName = "id")
    @NotNull
    private Long aeroportoDestino;

    @NotNull
    @Positive
    private Integer duracao;

    public String getNomeRota() {
        return nomeRota;
    }

    public Long getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Long getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Rota toModel(AeroportoRepository aeroportoRepository) {

        Aeroporto aeroportoOrigem = aeroportoRepository.getById(this.aeroportoOrigem);
        Aeroporto aeroportoDestino = aeroportoRepository.getById(this.aeroportoDestino);

        if(nomeRota.isBlank()){
            this.nomeRota = aeroportoOrigem.getNome() + " - " + aeroportoDestino.getNome();
        }

        return new Rota(this.nomeRota, aeroportoOrigem, aeroportoDestino, Duration.ofMinutes(duracao));
    }
}
