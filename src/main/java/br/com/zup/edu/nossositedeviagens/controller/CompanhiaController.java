package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.request.CompanhiaRequest;
import br.com.zup.edu.nossositedeviagens.controller.dto.response.CompanhiaReponse;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    private ResponseEntity<?> cadastrar(@RequestBody @Valid CompanhiaRequest request, UriComponentsBuilder uri) {
        Companhia companhia = request.toModel(manager);

        manager.persist(companhia);

        URI link = uri.path("/companhias/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(link).body(new CompanhiaReponse(companhia));
    }

}
