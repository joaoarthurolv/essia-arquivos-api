package com.joaoarthurolv.essia.arquivos.api.exception;

/**
 * @author João Arthur on 25/09/2024
 */
public class DiretorioInexistenteException extends ValidacaoException {
    public DiretorioInexistenteException(String mensagem) {
        super(mensagem);
    }
}
