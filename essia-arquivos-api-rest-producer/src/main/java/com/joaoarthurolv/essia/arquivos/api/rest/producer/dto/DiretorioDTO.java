package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Builder
public record DiretorioDTO(
        @Schema(hidden = true) Long idDiretorio,
        String nomeDiretorio,
        @Schema(hidden = true) Long idDiretorioPai,
        @JsonProperty(value = "ativo", defaultValue = "true") Boolean ativo,
        @Schema(hidden = true) Set<DiretorioDTO> diretoriosFilhos,
        @JsonProperty(value = "arquivos") @Schema(hidden = true) List<ArquivoDTO> arquivos) {

    public DiretorioDTO {
        if (ativo == null)
            ativo = Boolean.TRUE;
    }

}
