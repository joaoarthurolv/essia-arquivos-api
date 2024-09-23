package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author João Arthur on 18/09/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "arquivo_virtual", name = "arquivo")
@Builder
public class ArquivoEntity extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "gen_arquivo_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen_arquivo_id", schema = "arquivo_virtual", sequenceName = "seq_arquivo_id", allocationSize = 1)
    private Long idArquivo;

    @Column(name = "nome_arquivo", nullable = false)
    private String nomeArquivo;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_diretorio", referencedColumnName = "id_diretorio")
    private DiretorioEntity diretorioPai;
}
