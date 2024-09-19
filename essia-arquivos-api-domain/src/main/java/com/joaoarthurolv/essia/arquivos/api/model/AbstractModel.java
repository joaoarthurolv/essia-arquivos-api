package com.joaoarthurolv.essia.arquivos.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author João Arthur on 19/09/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractModel {
    private LocalDateTime criadoEm;
    private LocalDateTime ultimaModificacaoEm;
}
