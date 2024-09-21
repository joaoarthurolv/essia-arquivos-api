package com.joaoarthurolv.essia.arquivos.api.persistence.repository;

import com.joaoarthurolv.essia.arquivos.api.persistence.entity.DiretorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author João Arthur on 19/09/2024
 */
@Repository
public interface DiretorioJpaRepository extends JpaRepository<DiretorioEntity, Long> {
    List<DiretorioEntity> findAllByDiretorioPaiIsNull();
}
