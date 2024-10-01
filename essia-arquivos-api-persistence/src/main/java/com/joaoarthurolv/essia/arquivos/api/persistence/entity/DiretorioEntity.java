package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import com.joaoarthurolv.essia.arquivos.api.model.Diretorio;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author João Arthur on 19/09/2024
 */
@Getter
@Setter
@Entity
@Table(schema = "arquivo_virtual", name = "diretorio")
public class DiretorioEntity extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "gen_arquivo_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen_arquivo_id", schema = "arquivo_virtual", sequenceName = "seq_arquivo_id", allocationSize = 1)
    @Column(name = "id_diretorio")
    private Long idDiretorio;

    @Column(name = "nome_diretorio")
    private String nomeDiretorio;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_diretorio_pai", referencedColumnName = "id_diretorio")
    private DiretorioEntity diretorioPai;

    @OneToMany(mappedBy="diretorioPai")
    private Set<DiretorioEntity> diretoriosFilhos;

    @Column(name = "ativo")
    private Boolean ativo;

    @Builder
    private DiretorioEntity (Long idDiretorio, String nomeDiretorio, DiretorioEntity diretorioPai, Set<DiretorioEntity> diretoriosFilhos, Boolean ativo, LocalDateTime criadoEm, LocalDateTime ultimaModificacaoEm) {
        super(criadoEm, ultimaModificacaoEm);
        this.idDiretorio = idDiretorio;
        this.nomeDiretorio = nomeDiretorio;
        this.diretorioPai = diretorioPai;
        this.diretoriosFilhos = diretoriosFilhos;
        this.ativo = ativo;
    }

    public static class DiretorioEntityBuilder extends AbstractEntityBuilder {
        DiretorioEntityBuilder() {
            super();
        }
    }

    public DiretorioEntity (){
        super();
    }
}
