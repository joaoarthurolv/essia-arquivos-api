package com.joaoarthurolv.essia.arquivos.api.adapter.service;

import com.joaoarthurolv.essia.arquivos.api.model.Arquivo;
import com.joaoarthurolv.essia.arquivos.api.port.repository.ArquivoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author João Arthur on 23/09/2024
 */
class ArquivoServiceImplTest {

    private Arquivo arquivoMock;

    private ArquivoServiceImpl arquivoService;

    @Mock
    private ArquivoRepository arquivoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        arquivoMock = Arquivo.builder()
                .nomeArquivo(null)
                .build();

        arquivoService = new ArquivoServiceImpl(arquivoRepository);
    }

    @Test
    void validaArquivoSemNome(){
        Arquivo arquivo = arquivoService.validarArquivo(arquivoMock);

        Assertions.assertNotNull(arquivo.getNomeArquivo());
        Assertions.assertTrue(arquivo.getNomeArquivo().contains("sem_nome"));
    }
}
