package com.joaoarthurolv.essia.arquivos.api.persistence.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.persistence.entity.ArquivoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author João Arthur on 22/09/2024
 */
@Component
public class ArquivoEntityMapper {

    private final DiretorioEntityMapper diretorioEntityMapper;

    public ArquivoEntityMapper(DiretorioEntityMapper diretorioEntityMapper) {
        this.diretorioEntityMapper = diretorioEntityMapper;
    }

    public ArquivoEntity fromModel(Arquivo model){
        return ArquivoEntity.builder()
                .idArquivo(model.getIdArquivo())
                .nomeArquivo(model.getNomeArquivo())
                .ativo(model.getAtivo())
                .diretorioPai(Objects.isNull(model.getDiretorioPai()) ? null : diretorioEntityMapper.fromModel(model.getDiretorioPai()))
                .build();
    }

    public Arquivo toModel(ArquivoEntity entity){
        return Arquivo.builder()
                .idArquivo(entity.getIdArquivo())
                .nomeArquivo(entity.getNomeArquivo())
                .ativo(entity.getAtivo())
                .diretorioPai(Objects.isNull(entity.getDiretorioPai()) ? null: diretorioEntityMapper.toModel(entity.getDiretorioPai()))
                .build();
    }

    public List<Arquivo> toListModel(List<ArquivoEntity> entities) {
        if ( entities == null ) {
            return Collections.emptyList();
        }

        List<Arquivo> list = new ArrayList<>();
        for ( ArquivoEntity arquivoEntity : entities ) {
            list.add( toModel( arquivoEntity ) );
        }

        return list;
    }

    public List<ArquivoEntity> fromListModel(List<Arquivo> models) {
        if ( models == null ) {
            return Collections.emptyList();
        }

        List<ArquivoEntity> list = new ArrayList<>();
        for ( Arquivo arquivo : models ) {
            list.add( fromModel( arquivo ) );
        }

        return list;
    }
}
