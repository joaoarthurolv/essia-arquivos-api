package com.joaoarthurolv.essia.arquivos.api.persistence.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.persistence.entity.DiretorioEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author João Arthur on 19/09/2024
 */
@Component
public class DiretorioEntityMapper {

    public Diretorio toModel(DiretorioEntity entity) {
        return Diretorio.builder()
                .idDiretorio(entity.getIdDiretorio())
                .nomeDiretorio(entity.getNomeDiretorio())
                .idDiretorioPai(Objects.isNull(entity.getDiretorioPai()) ? null : entity.getDiretorioPai().getIdDiretorio())
                .ativo(entity.getAtivo())
                .build();
    }

    public DiretorioEntity fromModel(Diretorio model) {
        return DiretorioEntity.builder()
                .idDiretorio(model.getIdDiretorio())
                .nomeDiretorio(model.getNomeDiretorio())
                .diretorioPai(Objects.isNull(model.getIdDiretorioPai()) ? null : DiretorioEntity.builder().idDiretorio(model.getIdDiretorioPai()).build())
                .ativo(model.getAtivo())
                .build();
    }
}
