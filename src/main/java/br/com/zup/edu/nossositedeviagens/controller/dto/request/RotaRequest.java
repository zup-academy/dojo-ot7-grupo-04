package br.com.zup.edu.nossositedeviagens.controller.dto.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotasRepository;
import br.com.zup.edu.nossositedeviagens.validator.ExistIdValue;
import com.sun.istack.NotNull;
import org.springframework.util.Assert;

import javax.validation.constraints.Positive;
import java.time.Duration;
import java.util.List;

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

    public Rota toModel(AeroportoRepository aeroportoRepository, RotasRepository rotasRepository) {

        Aeroporto aeroportoOrigem = aeroportoRepository.getById(this.aeroportoOrigem);
        Aeroporto aeroportoDestino = aeroportoRepository.getById(this.aeroportoDestino);

        Assert.isTrue(this.aeroportoOrigem != this.aeroportoDestino, "Aeroporto origem e destino não podem ser iguais.");

        List<Rota> resultados = rotasRepository.findByAeroportoOrigemAndAeroportoDestino(aeroportoOrigem, aeroportoDestino);

        Assert.isTrue(resultados.isEmpty(), "Ja existem uma rota com esta origem e destino");

        if(nomeRota == null || nomeRota.isEmpty()){
            this.nomeRota = aeroportoOrigem.getNome() + " - " + aeroportoDestino.getNome();
        }

        return new Rota(this.nomeRota, aeroportoOrigem, aeroportoDestino, Duration.ofMinutes(duracao));
    }
}
