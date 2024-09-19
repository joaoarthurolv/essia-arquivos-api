package com.joaoarthurolv.essia.arquivos.api.model;

import com.joaoarthurolv.essia.arquivos.api.validate.ValidaCampos;
import lombok.*;

import static com.joaoarthurolv.essia.arquivos.api.validate.ValidaCampos.assertNotEmpty;

/**
 * @author João Arthur on 19/09/2024
 */
@Getter
@Setter
@NoArgsConstructor
public class Diretorio extends AbstractModel {
    private Long idDiretorio;
    private String nomeDiretorio;
    private Boolean ativo;
    private Long idDiretorioPai;

    @Builder
    public Diretorio(Long idDiretorio, String nomeDiretorio, Boolean ativo, Long idDiretorioPai) {
        this.idDiretorio = idDiretorio;
        this.nomeDiretorio = nomeDiretorio;
        this.ativo = ativo;
        this.idDiretorioPai = idDiretorioPai;
        validaCampos();
    }

    private void validaCampos(){
        assertNotEmpty(nomeDiretorio, "Nome do diretório");
    }
}
