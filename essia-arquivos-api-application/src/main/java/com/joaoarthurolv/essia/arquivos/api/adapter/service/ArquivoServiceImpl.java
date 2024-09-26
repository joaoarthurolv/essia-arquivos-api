package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.exception.ArquivoInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.port.repository.ArquivoRepository;
import com.joaoarthurolv.essia.arquivos.api.port.service.ArquivoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author João Arthur on 22/09/2024
 */
@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository repository;

    public ArquivoServiceImpl(ArquivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Arquivo salvarArquivo(Arquivo arquivo) {
        Arquivo arquivoValidado = validarArquivo(arquivo);
        return repository.salvarArquivo(arquivoValidado);
    }

    @Override
    public List<Arquivo> buscarArquivosPorIdDiretorio(Long idDiretorio) {
        return repository.findArquivosByIdDiretorio(idDiretorio);
    }

    @Override
    public void apagarArquivo(Long idArquivo) {
        Arquivo arquivo = repository.findArquivoById(idArquivo);

        if(Objects.isNull(arquivo))
            throw new ArquivoInexistenteException("O arquivo passado não existe.");

        repository.apagarArquivo(arquivo);
    }

    public Arquivo validarArquivo(Arquivo arquivo) {
        if(Objects.isNull(arquivo.getNomeArquivo()) || arquivo.getNomeArquivo().isEmpty()){
            List<Arquivo> arquivosSemNome = repository.findArquivosSemNome();

            int numeroArquivo = arquivosSemNome.size() + 1;

            if(arquivosSemNome.size() <= 8)
                arquivo.setNomeArquivo("sem_nome_0" + numeroArquivo);
            else
                arquivo.setNomeArquivo("sem_nome_" + numeroArquivo);

            return arquivo;
        }

        return arquivo;
    }
}
