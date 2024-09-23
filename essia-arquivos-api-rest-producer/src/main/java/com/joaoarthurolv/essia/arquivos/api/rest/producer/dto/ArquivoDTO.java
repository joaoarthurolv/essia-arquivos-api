package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * @author João Arthur on 22/09/2024
 */
@Builder
public record ArquivoDTO (
        @JsonProperty("id-arquivo") Long idArquivo,
        @JsonProperty("nome-arquivo") String nomeArquivo,
        @JsonProperty("id-diretorio-pai") Long idDiretorioPai,
        @JsonProperty(value = "ativo", defaultValue = "true") Boolean ativo
){
    public ArquivoDTO {
        if (ativo == null)
            ativo = Boolean.TRUE;
    }
}
