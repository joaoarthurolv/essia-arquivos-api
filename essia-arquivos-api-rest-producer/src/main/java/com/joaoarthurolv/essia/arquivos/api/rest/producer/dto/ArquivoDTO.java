package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * @author João Arthur on 22/09/2024
 */
@Builder
public record ArquivoDTO (
        @Schema(hidden = true) Long idArquivo,
        String nomeArquivo,
        @Schema(hidden = true) Long idDiretorioPai,
        @JsonProperty(value = "ativo", defaultValue = "true") Boolean ativo
){
    public ArquivoDTO {
        if (ativo == null)
            ativo = Boolean.TRUE;
    }
}
