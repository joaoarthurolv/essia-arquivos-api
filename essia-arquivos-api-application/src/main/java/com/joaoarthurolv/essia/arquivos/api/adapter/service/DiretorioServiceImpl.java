package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.exception.CampoObrigatorioException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioPaiInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.NomeDiretorioRepetidoException;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.repository.DiretorioRepository;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        validaDiretorio(diretorio);
        return repository.salvarDiretorio(diretorio);
    }

    @Override
    public List<Diretorio> getAll() {
        return repository.findAll();
    }

    private void validaDiretorio(Diretorio diretorio) {
        if(Objects.isNull(diretorio.getNomeDiretorio()) || diretorio.getNomeDiretorio().isEmpty())
            throw new CampoObrigatorioException("Nome do repositório");

        if(Objects.nonNull(diretorio.getDiretorioPai())){
            Diretorio diretorioPai = repository.findById(diretorio.getDiretorioPai().getIdDiretorio());

            if(Objects.isNull(diretorioPai))
                throw new DiretorioPaiInexistenteException("O diretório pai informado não existe.");

            if(diretorioPai.getDiretoriosFilhos().stream().anyMatch(diretorioIrmao -> diretorioIrmao.getNomeDiretorio().equalsIgnoreCase(diretorio.getNomeDiretorio())))
                throw new NomeDiretorioRepetidoException("Já existe um diretório com esse nome dentro do diretório pai especificado.");
        }
    }
}
