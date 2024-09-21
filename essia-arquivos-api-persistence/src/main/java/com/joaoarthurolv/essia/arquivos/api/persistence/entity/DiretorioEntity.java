package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "arquivo_virtual", name = "diretorio")
@Builder
public class DiretorioEntity extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "gen_arquivo_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen_arquivo_id", schema = "arquivo_virtual", sequenceName = "seq_arquivo_id", allocationSize = 1)
    @Column(name = "id_diretorio")
    private Long idDiretorio;

    @Column(name = "nome_diretorio")
    private String nomeDiretorio;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_diretorio_pai", referencedColumnName = "id_diretorio")
    private DiretorioEntity diretorioPai;

    @OneToMany(mappedBy="diretorioPai")
    private Set<DiretorioEntity> diretoriosFilhos;

    @Column(name = "ativo")
    private Boolean ativo;
}
