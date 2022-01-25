package com.ousmane.gestiondestock.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {

    @Column(name = "rolename")
    private String roleName;
    @Column(name = "identreprise")
    private String idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;

}
