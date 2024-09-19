package com.joaoarthurolv.essia.arquivos.api.exception;

/**
 * @author João Arthur on 19/09/2024
 */
public class CampoObrigatorioException extends ValidacaoException {

    public CampoObrigatorioException(String nomeCampo) {
        super(nomeCampo + " é um campo obrigatório.");
    }
}
