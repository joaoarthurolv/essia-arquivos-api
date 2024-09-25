package com.joaoarthurolv.essia.arquivos.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
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
    private List<Arquivo> arquivos;

    @Builder
    public Diretorio(Long idDiretorio, String nomeDiretorio, Boolean ativo, Diretorio diretorioPai, Set<Diretorio> diretoriosFilhos, List<Arquivo> arquivos, LocalDateTime criadoEm, LocalDateTime ultimaModificacaoEm) {
        super(criadoEm, ultimaModificacaoEm);
        this.idDiretorio = idDiretorio;
        this.nomeDiretorio = nomeDiretorio;
        this.ativo = ativo;
        this.diretorioPai = diretorioPai;
        this.diretoriosFilhos = diretoriosFilhos;
        this.arquivos = arquivos;
    }

    private void validaCampos(){
        assertNotEmpty(nomeDiretorio, "Nome do diretório");
    }
}
