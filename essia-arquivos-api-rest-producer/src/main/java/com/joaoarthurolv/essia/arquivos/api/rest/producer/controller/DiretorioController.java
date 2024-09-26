package com.joaoarthurolv.essia.arquivos.api.rest.producer.controller;

import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.ValidacaoException;
import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.service.ArquivoService;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.controller.routes.RouteDiretorio;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.DiretorioDTO;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.RaizDTO;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper.ArquivoDTOMapper;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper.DiretorioDTOMapper;
import io.swagger.annotations.Api;
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
@Api(value = "diretorios", tags = "diretorios")
public class DiretorioController {

    private final DiretorioService service;

    private final ArquivoService arquivoService;

    private final DiretorioDTOMapper mapper;

    private final ArquivoDTOMapper arquivoDTOMapper;

    public DiretorioController(DiretorioService service, ArquivoService arquivoService, DiretorioDTOMapper mapper, ArquivoDTOMapper arquivoDTOMapper) {
        this.service = service;
        this.arquivoService = arquivoService;
        this.mapper = mapper;
        this.arquivoDTOMapper = arquivoDTOMapper;
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

    @PutMapping(value = RouteDiretorio.ID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza um diretório.", httpMethod = "PUT")
    public ResponseEntity atualizarDiretorio(
            @PathVariable("id-diretorio") Long idDiretorio,
            @RequestBody DiretorioDTO dto){
        try {
            Diretorio diretorio = mapper.toModel(dto);

            diretorio.setIdDiretorio(idDiretorio);

            service.atualizarDiretorio(diretorio);

            return ResponseEntity.ok().body(mapper.fromModel(diretorio));
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca diretórios.", response = DiretorioDTO.class, responseContainer = "List", httpMethod = "GET")
    public ResponseEntity<RaizDTO> buscarDiretorios(){
        List<Diretorio> diretorios = service.getAll();
        List<Arquivo> arquivos = arquivoService.buscarArquivosPorIdDiretorio(null);

        return ResponseEntity.ok().body(
                RaizDTO.builder()
                        .diretorios(diretorios.stream().map(mapper::fromModel).toList())
                        .arquivos(arquivos.stream().map(arquivoDTOMapper::fromModel).toList())
                        .build()
        );
    }

    @DeleteMapping(value = RouteDiretorio.ID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Apaga diretório baseado no identificador passado.", httpMethod = "DELETE")
    public ResponseEntity apagarDiretorio(
            @PathVariable("id-diretorio") Long idDiretorio
    ){
        try {
            service.apagarDiretorio(idDiretorio);
        } catch (DiretorioInexistenteException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
