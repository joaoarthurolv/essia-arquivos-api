package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_diretorio_pai", referencedColumnName = "id_diretorio")
    private DiretorioEntity diretorioPai;

    @Column(name = "ativo")
    private Boolean ativo;
}
