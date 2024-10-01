package com.joaoarthurolv.essia.arquivos.api.port.service;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;

import java.util.List;

/**
 * @author João Arthur on 22/09/2024
 */
public interface ArquivoService {
    Arquivo salvarArquivo(Arquivo arquivo);

    List<Arquivo> buscarArquivosPorIdDiretorio(Long idDiretorio);

    void apagarArquivo(Long idArquivo);

    Arquivo atualizarArquivo(Arquivo model);
}
