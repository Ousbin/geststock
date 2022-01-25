package com.ousmane.gestiondestock.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
public class Client extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "identreprise")
    private String idEntreprise;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numtel")
    private String umTel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
