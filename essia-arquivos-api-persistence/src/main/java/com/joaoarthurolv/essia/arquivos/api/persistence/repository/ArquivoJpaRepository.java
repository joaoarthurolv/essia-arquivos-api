package com.joaoarthurolv.essia.arquivos.api.persistence.repository;

import com.joaoarthurolv.essia.arquivos.api.persistence.entity.ArquivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author João Arthur on 22/09/2024
 */
@Repository
public interface ArquivoJpaRepository extends JpaRepository<ArquivoEntity, Long> {
    List<ArquivoEntity> findArquivoEntitiesByNomeArquivoStartsWith(String nomeArquivo);

    List<ArquivoEntity> findArquivoEntitiesByDiretorioPai_IdDiretorio(Long idDiretorio);
}
