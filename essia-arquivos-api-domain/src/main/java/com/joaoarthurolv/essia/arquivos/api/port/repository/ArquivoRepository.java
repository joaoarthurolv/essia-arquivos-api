package com.joaoarthurolv.essia.arquivos.api.port.repository;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;

import java.util.List;

/**
 * @author João Arthur on 22/09/2024
 */
public interface ArquivoRepository {
    Arquivo salvarArquivo(Arquivo arquivo);

    List<Arquivo> findArquivosSemNome();

    List<Arquivo> findArquivosByIdDiretorio(Long idDiretorio);

    Arquivo findArquivoById(Long idArquivo);

    void apagarArquivo(Arquivo arquivo);
}
