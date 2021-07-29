package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.request.CompanhiaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    private ResponseEntity<?> cadastrar(@RequestBody @Valid CompanhiaRequest request) {
        return null;
    }

}
