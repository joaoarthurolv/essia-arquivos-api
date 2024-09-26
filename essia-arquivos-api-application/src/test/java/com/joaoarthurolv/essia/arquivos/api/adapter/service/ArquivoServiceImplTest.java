package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.exception.ArquivoInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.exception.DiretorioInexistenteException;
import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.port.repository.ArquivoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author João Arthur on 23/09/2024
 */
class ArquivoServiceImplTest {

    private Arquivo arquivoMock;

    private Arquivo arquivoValidoMock;

    private ArquivoServiceImpl arquivoService;

    @Mock
    private ArquivoRepository arquivoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        arquivoMock = Arquivo.builder()
                .nomeArquivo(null)
                .build();

        arquivoValidoMock = Arquivo
                .builder()
                .idArquivo(1L)
                .nomeArquivo("arquivo.txt")
                .ativo(true)
                .build();

        arquivoService = new ArquivoServiceImpl(arquivoRepository);
    }

    @Test
    void validaArquivoSemNome(){
        Arquivo arquivo = arquivoService.validarArquivo(arquivoMock);

        Assertions.assertNotNull(arquivo.getNomeArquivo());
        Assertions.assertTrue(arquivo.getNomeArquivo().contains("sem_nome"));
    }

    @Test
    void naoDeveApagarArquivoInexistente(){
        Mockito.lenient().when(arquivoRepository.findArquivoById(1L)).thenReturn(null);

        Assertions.assertThrows(ArquivoInexistenteException.class, () -> arquivoService.apagarArquivo(1L));
    }

    @Test
    void deveApagarArquivoComSucesso(){
        Mockito.lenient().when(arquivoRepository.findArquivoById(1L)).thenReturn(arquivoValidoMock);

        arquivoService.apagarArquivo(1L);

        Mockito.verify(arquivoRepository, Mockito.times(1)).apagarArquivo(arquivoValidoMock);
    }
}
