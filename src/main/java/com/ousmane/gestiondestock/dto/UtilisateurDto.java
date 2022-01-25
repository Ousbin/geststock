package com.ousmane.gestiondestock.dto;

import com.ousmane.gestiondestock.model.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Builder
@Data

public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String umTel;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }

        return  UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .photo(utilisateur.getPhoto())
                .mail(utilisateur.getMail())
                .umTel(utilisateur.getUmTel())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setMail(utilisateurDto.getMail());
        utilisateur.setUmTel(utilisateurDto.getUmTel());

        return utilisateur;
    }
}

