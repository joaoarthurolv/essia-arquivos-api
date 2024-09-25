package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author João Arthur on 18/09/2024
 */
@Getter
@Setter
@Entity
@Table(schema = "arquivo_virtual", name = "arquivo")
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

    @Builder
    public ArquivoEntity (Long idArquivo, String nomeArquivo, Boolean ativo, DiretorioEntity diretorioPai, LocalDateTime criadoEm, LocalDateTime ultimaModificacaoEm) {
        super(criadoEm, ultimaModificacaoEm);
        this.idArquivo = idArquivo;
        this.nomeArquivo = nomeArquivo;
        this.ativo = ativo;
        this.diretorioPai = diretorioPai;
    }

    public ArquivoEntity (){
        super();
    }

    public static class ArquivoEntityBuilder extends AbstractEntityBuilder {
        ArquivoEntityBuilder() {
            super();
        }
    }
}
