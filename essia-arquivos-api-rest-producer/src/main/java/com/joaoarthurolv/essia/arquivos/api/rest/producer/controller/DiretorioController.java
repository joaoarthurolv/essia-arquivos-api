package com.joaoarthurolv.essia.arquivos.api.rest.producer.controller;

import com.joaoarthurolv.essia.arquivos.api.exception.ValidacaoException;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.controller.routes.RouteDiretorio;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.DiretorioDTO;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper.DiretorioDTOMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author João Arthur on 19/09/2024
 */
@RestController
@RequestMapping(RouteDiretorio.DIRETORIOS)
public class DiretorioController {

    private final DiretorioService service;

    private final DiretorioDTOMapper mapper;

    public DiretorioController(DiretorioService service, DiretorioDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Salva um diretório.", httpMethod = "POST")
    public ResponseEntity salvarDiretorio(@RequestBody DiretorioDTO dto){
        try {
            Diretorio diretorio = service.salvarDiretorio(mapper.toModel(dto));
            return ResponseEntity.ok().body(mapper.fromModel(diretorio));
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca diretórios.", response = DiretorioDTO.class, responseContainer = "List", httpMethod = "GET")
    public ResponseEntity<List<DiretorioDTO>> buscarDiretorios(){
        List<Diretorio> diretorios = service.getAll();
        return ResponseEntity.ok().body(diretorios.stream().map(mapper::fromModel).toList());
    }
}
