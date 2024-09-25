package com.joaoarthurolv.essia.arquivos.api.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
