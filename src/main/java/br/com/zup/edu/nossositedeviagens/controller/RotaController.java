package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.request.RotaRequest;
import br.com.zup.edu.nossositedeviagens.controller.dto.response.RotaResponse;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotasRepository rotasRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PostMapping
    @Transactional
    private ResponseEntity<?> cadastrar(@RequestBody @Valid RotaRequest request, UriComponentsBuilder builder) {
        Rota rota = request.toModel(aeroportoRepository, rotasRepository);
        rotasRepository.save(rota);

        URI uri = builder.path("/rotas/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.created(uri).body(new RotaResponse(rota));
    }
}
