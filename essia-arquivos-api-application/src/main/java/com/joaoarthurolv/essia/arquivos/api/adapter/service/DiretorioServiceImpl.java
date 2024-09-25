package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.exception.CampoObrigatorioException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioPaiInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.NomeDiretorioRepetidoException;
import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.repository.DiretorioRepository;
import com.joaoarthurolv.essia.arquivos.api.port.service.ArquivoService;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Service
public class DiretorioServiceImpl implements DiretorioService {

    private final DiretorioRepository diretorioRepository;

    private final ArquivoService arquivoService;

    public DiretorioServiceImpl(DiretorioRepository diretorioRepository, ArquivoService arquivoService) {
        this.diretorioRepository = diretorioRepository;
        this.arquivoService = arquivoService;
    }

    @Override
    public Diretorio salvarDiretorio(Diretorio diretorio) {
        validaDiretorio(diretorio);
        return diretorioRepository.salvarDiretorio(diretorio);
    }

    @Override
    public Diretorio atualizarDiretorio(Diretorio diretorio) {
        Diretorio diretorioAtualizado = diretorioRepository.findById(diretorio.getIdDiretorio());

        diretorioAtualizado.setNomeDiretorio(diretorio.getNomeDiretorio());
        diretorioAtualizado.setDiretorioPai(diretorio.getDiretorioPai());
        validaDiretorio(diretorioAtualizado);

        return diretorioRepository.salvarDiretorio(diretorioAtualizado);
    }

    @Override
    public List<Diretorio> getAll() {
        List<Diretorio> diretorios = diretorioRepository.findAll();

        diretorios.forEach(this::carregarArquivos);

        return diretorios;
    }

    private void validaDiretorio(Diretorio diretorio) {
        if(Objects.isNull(diretorio.getNomeDiretorio()) || diretorio.getNomeDiretorio().isEmpty())
            throw new CampoObrigatorioException("Nome do repositório");

        if(Objects.nonNull(diretorio.getDiretorioPai())){
            Diretorio diretorioPai = diretorioRepository.findById(diretorio.getDiretorioPai().getIdDiretorio());

            if(Objects.isNull(diretorioPai))
                throw new DiretorioPaiInexistenteException("O diretório pai informado não existe.");

            if(diretorioPai.getDiretoriosFilhos().stream().anyMatch(diretorioIrmao -> diretorioIrmao.getNomeDiretorio().equalsIgnoreCase(diretorio.getNomeDiretorio())))
                throw new NomeDiretorioRepetidoException("Já existe um diretório com esse nome dentro do diretório pai especificado.");
        }
    }

    public void carregarArquivos(Diretorio diretorio){
        List<Arquivo> arquivos = arquivoService.buscarArquivosPorIdDiretorio(diretorio.getIdDiretorio());
        diretorio.setArquivos(arquivos);

        Set<Diretorio> diretoriosFilhos = diretorio.getDiretoriosFilhos();
        diretoriosFilhos.forEach(this::carregarArquivos);
    }
}
