package com.joaoarthurolv.essia.arquivos.api.persistence.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.persistence.entity.DiretorioEntity;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Component
public class DiretorioEntityMapper {

    public Diretorio toModel(DiretorioEntity entity) {
        return Diretorio.builder()
                .idDiretorio(entity.getIdDiretorio())
                .nomeDiretorio(entity.getNomeDiretorio())
                .ativo(entity.getAtivo())
                .diretorioPai(Objects.isNull(entity.getDiretorioPai()) ? null : Diretorio.builder().idDiretorio(entity.getDiretorioPai().getIdDiretorio()).build())
                .diretoriosFilhos(toListModel(entity.getDiretoriosFilhos()))
                .criadoEm(entity.getCriadoEm())
                .ultimaModificacaoEm(entity.getUltimaModificacaoEm())
                .build();
    }

    public DiretorioEntity fromModel(Diretorio model) {
        return DiretorioEntity.builder()
                .idDiretorio(model.getIdDiretorio())
                .nomeDiretorio(model.getNomeDiretorio())
                .ativo(model.getAtivo())
                .diretorioPai(Objects.isNull(model.getDiretorioPai()) ? null : DiretorioEntity.builder().idDiretorio(model.getDiretorioPai().getIdDiretorio()).build())
                .diretoriosFilhos(fromListModel(model.getDiretoriosFilhos()))
                .criadoEm(model.getCriadoEm())
                .ultimaModificacaoEm(model.getUltimaModificacaoEm())
                .build();
    }

    public Set<Diretorio> toListModel(Set<DiretorioEntity> entities) {
        if ( entities == null ) {
            return Collections.emptySet();
        }

        Set<Diretorio> set = new HashSet<>( Math.max( (int) ( entities.size() / .75f ) + 1, 16 ) );
        for ( DiretorioEntity diretorioEntity : entities ) {
            set.add( toModel( diretorioEntity ) );
        }

        return set;
    }

    public Set<DiretorioEntity> fromListModel(Set<Diretorio> models) {
        if ( models == null ) {
            return Collections.emptySet();
        }

        Set<DiretorioEntity> set = new HashSet<>( Math.max( (int) ( models.size() / .75f ) + 1, 16 ) );
        for ( Diretorio diretorio : models ) {
            set.add( fromModel( diretorio ) );
        }

        return set;
    }
}
