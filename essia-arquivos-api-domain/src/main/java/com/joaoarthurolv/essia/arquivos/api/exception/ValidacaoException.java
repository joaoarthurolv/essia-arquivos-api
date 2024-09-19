package com.joaoarthurolv.essia.arquivos.api.exception;

/**
 * @author João Arthur on 19/09/2024
 */
public class ValidacaoException extends RuntimeException {

    public ValidacaoException() {
        super();
    }

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
