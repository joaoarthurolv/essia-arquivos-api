package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.mapper;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.rest.producer.dto.DiretorioDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Component
public class DiretorioDTOMapper {

    private final ArquivoDTOMapper arquivoDTOMapper;

    public DiretorioDTOMapper(ArquivoDTOMapper arquivoDTOMapper) {
        this.arquivoDTOMapper = arquivoDTOMapper;
    }

    public Diretorio toModel(DiretorioDTO dto) {
        return Diretorio.builder()
                .idDiretorio(dto.idDiretorio())
                .nomeDiretorio(dto.nomeDiretorio())
                .diretorioPai(Objects.isNull(dto.idDiretorioPai()) ? null : Diretorio.builder().idDiretorio(dto.idDiretorioPai()).build())
                .ativo(dto.ativo())
                .diretoriosFilhos(toListModel(dto.diretoriosFilhos()))
                .arquivos(arquivoDTOMapper.toListModel(dto.arquivos()))
                .build();
    }

    public DiretorioDTO fromModel(Diretorio model) {
       return DiretorioDTO.builder()
               .idDiretorio(model.getIdDiretorio())
               .nomeDiretorio(model.getNomeDiretorio())
               .idDiretorioPai(Objects.isNull(model.getDiretorioPai()) ? null : model.getDiretorioPai().getIdDiretorio())
               .ativo(model.getAtivo())
               .diretoriosFilhos(fromListModel(model.getDiretoriosFilhos()))
               .arquivos(arquivoDTOMapper.fromListModel(model.getArquivos()))
               .build();
    }

    public Set<Diretorio> toListModel(Set<DiretorioDTO> dtos) {
        if ( dtos == null ) {
            return Collections.emptySet();
        }

        Set<Diretorio> set = new HashSet<>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( DiretorioDTO diretorioDTO : dtos ) {
            set.add( toModel( diretorioDTO ) );
        }

        return set;
    }

    public Set<DiretorioDTO> fromListModel(Set<Diretorio> models) {
        if ( models == null ) {
            return Collections.emptySet();
        }

        Set<DiretorioDTO> set = new HashSet<>( Math.max( (int) ( models.size() / .75f ) + 1, 16 ) );
        for ( Diretorio model : models ) {
            set.add( fromModel( model ) );
        }

        return set;
    }
}
