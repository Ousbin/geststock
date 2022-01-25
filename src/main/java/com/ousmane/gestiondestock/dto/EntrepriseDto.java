package com.ousmane.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ousmane.gestiondestock.model.Client;
import com.ousmane.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Embedded;
import java.util.List;

@Builder
@Data
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String Description;

    @Embedded
    private AdresseDto adresse;

    private String codeFiscal;

    private String Photo;

    private String Email;

    private String numTel;

    private String siteWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if (entreprise == null){
            return null;
        }

        return  EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .codeFiscal(entreprise.getCodeFiscal())
                .Photo(entreprise.getPhoto())
                .Email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if (entrepriseDto == null){
            return null;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());

        return entreprise;
    }
}
