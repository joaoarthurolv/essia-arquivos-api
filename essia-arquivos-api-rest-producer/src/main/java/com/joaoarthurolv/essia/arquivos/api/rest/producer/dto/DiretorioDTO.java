package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Builder
public record DiretorioDTO(
        @JsonProperty("id-diretorio") Long idDiretorio,
        @JsonProperty("nome-diretorio") String nomeDiretorio,
        @JsonProperty("id-diretorio-pai") Long idDiretorioPai,
        @JsonProperty(value = "ativo", defaultValue = "true") Boolean ativo,
        @JsonProperty(value = "diretorios-filhos") Set<DiretorioDTO> diretoriosFilhos) {

    public DiretorioDTO {
        if (ativo == null)
            ativo = Boolean.TRUE;
    }

}
