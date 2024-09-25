package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author João Arthur on 19/09/2024
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbstractEntity {

    @CreatedDate
    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column(name = "ultima_modificacao_em", nullable = false)
    private LocalDateTime ultimaModificacaoEm;
}
