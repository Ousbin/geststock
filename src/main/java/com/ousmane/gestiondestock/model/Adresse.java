package com.ousmane.gestiondestock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable//permet  d'insérer une colonne c'est a dire les données dans une autre table

public class Adresse {

    @Column(name = "adresse1")
    private String Adresse1;

    @Column(name = "adresse2")
    private String Adresse2;

    @Column(name = "ville")
    private String Ville;

    @Column(name = "codepostale")
    private String codePostale;

    @Column(name = "pays")
    private String Pays;
}
