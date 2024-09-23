package com.joaoarthurolv.essia.arquivos.api.model;

import lombok.*;

/**
 * @author João Arthur on 22/09/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arquivo extends AbstractModel {
    private Long idArquivo;
    private String nomeArquivo;
    private Boolean ativo;
    private Diretorio diretorioPai;
}
