package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.request.PaisRequest;
import br.com.zup.edu.nossositedeviagens.controller.dto.response.PaisResponse;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("paises")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody PaisRequest dto) {

        Pais pais = paisRepository.save(dto.toModel());
        return ResponseEntity.ok(PaisResponse.toResponse(pais));
    }
}
