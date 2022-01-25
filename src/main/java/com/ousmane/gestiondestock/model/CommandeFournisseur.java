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
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends  AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private String dateCommande;

    @Column(name = "identreprise")
    private String idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private  Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
