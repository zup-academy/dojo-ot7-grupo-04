package br.com.zup.edu.nossositedeviagens.repository;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotasRepository extends JpaRepository<Rota, Long> {

    List<Rota> findByAeroportoOrigemAndAeroportoDestino(Aeroporto origem, Aeroporto destino);
}
