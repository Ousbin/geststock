package com.ousmane.gestiondestock.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String Description;

    @Embedded
    private Adresse adresse;

    @Column(name = "codefiscal")
    private String codeFiscal;

    @Column(name = "photo")
    private String Photo;


    @Column(name = "email")
    private String Email;

    @Column(name = "numtel")
    private String numTel;

    @Column(name = "siteweb")
    private String siteWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;
}
