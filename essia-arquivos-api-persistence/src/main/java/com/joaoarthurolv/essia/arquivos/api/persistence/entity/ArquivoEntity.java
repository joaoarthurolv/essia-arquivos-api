package com.joaoarthurolv.essia.arquivos.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class ArquivoEntity {

    @Id
    @GeneratedValue(generator = "gen_arquivo_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen_arquivo_id", schema = "arquivo_virtual", sequenceName = "seq_arquivo_id", allocationSize = 1)
    private Long idArquivo;
}
