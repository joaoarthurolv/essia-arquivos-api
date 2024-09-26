package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.exception.CampoObrigatorioException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioPaiInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.NomeDiretorioRepetidoException;
import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import com.joaoarthurolv.essia.arquivos.api.port.repository.DiretorioRepository;
import com.joaoarthurolv.essia.arquivos.api.port.service.ArquivoService;
import com.joaoarthurolv.essia.arquivos.api.port.service.DiretorioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

/**
 * @author João Arthur on 21/09/2024
 */
class DiretorioServiceImplTest {

    private Diretorio diretorioComNomeNuloMock;

    private Diretorio diretorioRepetidoMock;

    private Diretorio diretorioComFilhoRepetidoMock;

    private Diretorio diretorioComDiretorioPaiInexistenteMock;

    private Diretorio diretorioValidoMock;

    private DiretorioService diretorioService;

    private Set<Diretorio> diretoriosMock;

    @Mock
    private ArquivoService arquivoService;

    @Mock
    private DiretorioRepository diretorioRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        diretorioValidoMock = Diretorio
                .builder()
                .idDiretorio(1L)
                .nomeDiretorio("Diretorio")
                .ativo(true)
                .build();

        diretorioComNomeNuloMock = Diretorio.builder()
                .idDiretorio(1L)
                .nomeDiretorio(null)
                .ativo(true)
                .build();

        diretorioComDiretorioPaiInexistenteMock = Diretorio.builder()
                .idDiretorio(1L)
                .nomeDiretorio("Nome do diretório")
                .ativo(true)
                .diretorioPai(Diretorio.builder().idDiretorio(3L).build())
                .build();


        diretorioComFilhoRepetidoMock = Diretorio.builder()
                .idDiretorio(1L)
                .nomeDiretorio("Diretório pai")
                .ativo(true).build();

        diretorioRepetidoMock = Diretorio.builder()
                .idDiretorio(1L)
                .nomeDiretorio("Nome do diretório")
                .ativo(true)
                .diretorioPai(diretorioComFilhoRepetidoMock)
                .build();

        diretoriosMock = new HashSet<>();
        diretoriosMock.add(diretorioRepetidoMock);
        diretorioComFilhoRepetidoMock.setDiretoriosFilhos(diretoriosMock);

        diretorioService = new DiretorioServiceImpl(diretorioRepository, arquivoService);
    }

    @Test
    void diretorioComNomeVazioOuNulo(){
        Assertions.assertThrows(CampoObrigatorioException.class, () -> diretorioService.salvarDiretorio(diretorioComNomeNuloMock));
    }

    @Test
    void diretorioComDiretorioPaiInexistente(){
        Mockito.lenient().when(diretorioRepository.findById(3L)).thenReturn(null);

        Assertions.assertThrows(DiretorioPaiInexistenteException.class, () -> diretorioService.salvarDiretorio(diretorioComDiretorioPaiInexistenteMock));
    }

    @Test
    void diretorioComNomeJaExistenteNoDiretorioPai(){
        Mockito.lenient().when(diretorioRepository.findById(1L)).thenReturn(diretorioComFilhoRepetidoMock);

        Assertions.assertThrows(NomeDiretorioRepetidoException.class, () -> diretorioService.salvarDiretorio(diretorioRepetidoMock));
    }

    @Test
    void naoDeveApagarDiretorioInexistente(){
        Mockito.lenient().when(diretorioRepository.findById(1L)).thenReturn(null);

        Assertions.assertThrows(DiretorioInexistenteException.class, () -> diretorioService.apagarDiretorio(1L));
    }

    @Test
    void deveApagarDiretorioComSucesso(){
        Mockito.lenient().when(diretorioRepository.findById(1L)).thenReturn(diretorioValidoMock);

        diretorioService.apagarDiretorio(1L);

        Mockito.verify(diretorioRepository, Mockito.times(1)).apagarRepositorio(diretorioValidoMock);
    }
}
