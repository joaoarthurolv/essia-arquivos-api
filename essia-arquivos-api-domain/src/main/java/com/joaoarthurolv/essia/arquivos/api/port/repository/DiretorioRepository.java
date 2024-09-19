package com.joaoarthurolv.essia.arquivos.api.port.repository;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import org.springframework.stereotype.Repository;

/**
 * @author João Arthur on 19/09/2024
 */
@Repository
public interface DiretorioRepository {
    Diretorio salvarDiretorio(Diretorio diretorio);
}
