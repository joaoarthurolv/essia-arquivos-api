package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.repository.DiretorioRepository;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Arthur on 19/09/2024
 */
@Service
public class DiretorioServiceImpl implements DiretorioService {

    private final DiretorioRepository repository;

    public DiretorioServiceImpl(DiretorioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Diretorio salvarDiretorio(Diretorio diretorio) {
        return repository.salvarDiretorio(diretorio);
    }

    @Override
    public List<Diretorio> getAll() {
        return repository.findAll();
    }
}
