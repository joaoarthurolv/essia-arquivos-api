package com.joaoarthurolv.essia.arquivos.api.rest.producer.dto;

import lombok.Builder;

import java.util.List;

/**
 * @author João Arthur on 25/09/2024
 */
@Builder
public record RaizDTO(List<DiretorioDTO> diretorios, List<ArquivoDTO> arquivos) {
}
