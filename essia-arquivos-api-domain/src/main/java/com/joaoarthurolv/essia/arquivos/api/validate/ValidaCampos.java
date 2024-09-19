package com.joaoarthurolv.essia.arquivos.api.validate;

import com.joaoarthurolv.essia.arquivos.api.exception.CampoObrigatorioException;

import java.util.Objects;

/**
 * @author João Arthur on 19/09/2024
 */
public class ValidaCampos {
    public static void assertNotEmpty(String campo, String nomeCampo){
        if(Objects.isNull(campo) || campo.trim().isEmpty())
            throw new CampoObrigatorioException(nomeCampo);
    }
}
