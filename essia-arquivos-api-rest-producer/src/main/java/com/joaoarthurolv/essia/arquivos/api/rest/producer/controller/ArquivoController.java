package com.joaoarthurolv.essia.arquivos.api.rest.producer.controller;

import com.joaoarthurolv.essia.arquivos.api.exception.ValidacaoException;
import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.port.service.ArquivoService;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.controller.routes.RouteArquivo;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.ArquivoDTO;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper.ArquivoDTOMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author João Arthur on 22/09/2024
 */
@RestController
@RequestMapping(RouteArquivo.ARQUIVOS)
@Api(value = "arquivos", tags = "arquivos")
public class ArquivoController {

    private final ArquivoService service;

    private final ArquivoDTOMapper mapper;

    public ArquivoController(ArquivoService service, ArquivoDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Salva um arquivo.", httpMethod = "POST", response = ArquivoDTO.class)
    public ResponseEntity salvarArquivo(@RequestBody ArquivoDTO dto){
        try {
            Arquivo arquivo = service.salvarArquivo(mapper.toModel(dto));
            return ResponseEntity.ok().body(mapper.fromModel(arquivo));
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca arquivos baseado no identificador do diretório.", httpMethod = "GET")
    public ResponseEntity<List<ArquivoDTO>> buscarArquivosPorIdDiretorio(@RequestParam(name = "id-diretorio") Long idDiretorio){
        List<Arquivo> arquivos = service.buscarArquivosPorIdDiretorio(idDiretorio);

        return ResponseEntity.ok().body(arquivos.stream().map(mapper::fromModel).toList());
    }
}
