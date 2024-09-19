package com.joaoarthurolv.essia.arquivos.api.model;

import com.joaoarthurolv.essia.arquivos.api.exception.CampoObrigatorioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author João Arthur on 19/09/2024
 */
class DiretorioTest {

    @Test
    void criaDiretorioValido(){
        Diretorio diretorio = Diretorio.builder()
                                .idDiretorio(1L)
                                .nomeDiretorio("Nome do diretório")
                                .ativo(true)
                                .build();

        Assertions.assertEquals(1L, diretorio.getIdDiretorio());
        Assertions.assertEquals(true, diretorio.getAtivo());
        Assertions.assertNotNull(diretorio.getNomeDiretorio());
    }

    @Test
    void criaDiretorioSemNome(){
        assertThrows(CampoObrigatorioException.class, () ->
                Diretorio.builder()
                        .idDiretorio(1L)
                        .nomeDiretorio("")
                        .ativo(true)
                        .build());
    }
}
