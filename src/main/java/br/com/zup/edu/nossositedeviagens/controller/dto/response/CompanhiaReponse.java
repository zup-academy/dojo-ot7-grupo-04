package br.com.zup.edu.nossositedeviagens.controller.dto.response;

import br.com.zup.edu.nossositedeviagens.model.Companhia;

import java.time.LocalDateTime;

public class CompanhiaReponse {

    private String nome;
    private String nomePais;
    private LocalDateTime dataCriacao;

    public CompanhiaReponse(Companhia companhia) {
        this.nome = companhia.getNome();
        this.nomePais = companhia.getPais().getNome();
        this.dataCriacao = companhia.getDataCriacao();
    }

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
