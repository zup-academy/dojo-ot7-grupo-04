package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.request.AeroportoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/aeroporto")
public class AeroportoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    private ResponseEntity<?> cadastrar(@RequestBody @Valid AeroportoRequest request) {

    }
}