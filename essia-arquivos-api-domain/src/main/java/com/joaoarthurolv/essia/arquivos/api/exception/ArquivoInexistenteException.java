package com.joaoarthurolv.essia.arquivos.api.exception;

/**
 * @author João Arthur on 25/09/2024
 */
public class ArquivoInexistenteException extends ValidacaoException {
    public ArquivoInexistenteException(String mensagem) {
        super(mensagem);
    }
}
