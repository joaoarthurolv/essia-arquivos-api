package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.ArquivoDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author João Arthur on 22/09/2024
 */
@Component
public class ArquivoDTOMapper {
    public Arquivo toModel(ArquivoDTO dto) {
        return Arquivo.builder()
                .idArquivo(dto.idArquivo())
                .nomeArquivo(dto.nomeArquivo())
                .ativo(dto.ativo())
                .diretorioPai(Objects.isNull(dto.idDiretorioPai()) ? null : Diretorio.builder().idDiretorio(dto.idDiretorioPai()).build())
                .build();
    }

    public ArquivoDTO fromModel(Arquivo model) {
        return ArquivoDTO.builder()
                .idArquivo(model.getIdArquivo())
                .nomeArquivo(model.getNomeArquivo())
                .ativo(model.getAtivo())
                .idDiretorioPai(Objects.isNull(model.getDiretorioPai()) ? null : model.getDiretorioPai().getIdDiretorio())
                .build();
    }
}
