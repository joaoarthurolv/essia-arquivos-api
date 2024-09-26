package com.joaoarthurolv.essia.arquivos.api.port.service;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;

import java.util.List;

/**
 * @author João Arthur on 19/09/2024
 */
public interface DiretorioService {
    Diretorio salvarDiretorio(Diretorio diretorio);

    Diretorio atualizarDiretorio(Diretorio diretorio);

    List<Diretorio> getAll();

    void apagarDiretorio(Long idDiretorio);
}
