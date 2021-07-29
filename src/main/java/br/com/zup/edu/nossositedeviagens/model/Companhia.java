package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @NotNull
    @ManyToOne
    private Pais pais;

    public Companhia(@NotBlank String nome,@NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Companhia companhia = (Companhia) o;
        return Objects.equals(id, companhia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
