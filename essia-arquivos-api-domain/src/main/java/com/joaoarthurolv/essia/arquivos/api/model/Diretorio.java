package com.joaoarthurolv.essia.arquivos.api.model;

import com.joaoarthurolv.essia.arquivos.api.validate.ValidaCampos;
import lombok.*;

import java.util.Set;

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
    private Set<Diretorio> diretoriosFilhos;
    private Diretorio diretorioPai;

    @Builder
    public Diretorio(Long idDiretorio, String nomeDiretorio, Boolean ativo, Diretorio diretorioPai, Set<Diretorio> diretoriosFilhos) {
        this.idDiretorio = idDiretorio;
        this.nomeDiretorio = nomeDiretorio;
        this.ativo = ativo;
        this.diretorioPai = diretorioPai;
        this.diretoriosFilhos = diretoriosFilhos;
//        validaCampos();
    }

    private void validaCampos(){
        assertNotEmpty(nomeDiretorio, "Nome do diretório");
    }
}
