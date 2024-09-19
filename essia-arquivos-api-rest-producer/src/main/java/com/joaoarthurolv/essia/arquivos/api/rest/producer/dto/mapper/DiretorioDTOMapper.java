package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.DiretorioDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author João Arthur on 19/09/2024
 */
@Component
public class DiretorioDTOMapper {

    public Diretorio toModel(DiretorioDTO dto) {
        return Diretorio.builder()
                .idDiretorio(dto.idDiretorio())
                .nomeDiretorio(dto.nomeDiretorio())
                .idDiretorioPai(Objects.isNull(dto.idDiretorioPai()) ? null : dto.idDiretorioPai())
                .ativo(dto.ativo())
                .build();
    }

    public DiretorioDTO fromModel(Diretorio model) {
       return DiretorioDTO.builder()
               .idDiretorio(model.getIdDiretorio())
               .nomeDiretorio(model.getNomeDiretorio())
               .idDiretorioPai(Objects.isNull(model.getIdDiretorioPai()) ? null : model.getIdDiretorioPai())
               .ativo(model.getAtivo())
               .build();
    }
}
