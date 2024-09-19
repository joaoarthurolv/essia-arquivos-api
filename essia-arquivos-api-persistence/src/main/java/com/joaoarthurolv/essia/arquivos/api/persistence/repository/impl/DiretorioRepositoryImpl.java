package com.joaoarthurolv.essia.arquivos.api.persistence.repository.impl;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.persistence.entity.DiretorioEntity;
import com.joaoarthurolv.essia.arquivos.api.persistence.mapper.DiretorioEntityMapper;
import com.joaoarthurolv.essia.arquivos.api.persistence.repository.DiretorioJpaRepository;
import com.joaoarthurolv.essia.arquivos.api.port.repository.DiretorioRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Arthur on 19/09/2024
 */
@Repository
public class DiretorioRepositoryImpl implements DiretorioRepository {

    private final DiretorioJpaRepository jpaRepository;

    private final DiretorioEntityMapper mapper;

    public DiretorioRepositoryImpl(DiretorioJpaRepository jpaRepository, DiretorioEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Diretorio salvarDiretorio(Diretorio diretorio) {
        DiretorioEntity diretorioSalvo = jpaRepository.save(mapper.fromModel(diretorio));
        return mapper.toModel(diretorioSalvo);
    }
}
