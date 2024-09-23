package com.joaoarthurolv.essia.arquivos.api.persistence.repository.impl;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.persistence.mapper.ArquivoEntityMapper;
import com.joaoarthurolv.essia.arquivos.api.persistence.repository.ArquivoJpaRepository;
import com.joaoarthurolv.essia.arquivos.api.port.repository.ArquivoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author João Arthur on 22/09/2024
 */
@Repository
public class ArquivoRepositoryImpl implements ArquivoRepository {

    private final ArquivoJpaRepository jpaRepository;

    private final ArquivoEntityMapper mapper;

    public ArquivoRepositoryImpl(ArquivoJpaRepository jpaRepository, ArquivoEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Arquivo salvarArquivo(Arquivo arquivo) {
        return mapper.toModel(jpaRepository.save(mapper.fromModel(arquivo)));
    }

    @Override
    public List<Arquivo> findArquivosSemNome() {
        return mapper.toListModel(jpaRepository.findArquivoEntitiesByNomeArquivoStartsWith("sem_nome"));
    }
}
