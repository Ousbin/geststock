package com.ousmane.gestiondestock.dto;

import com.ousmane.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
@Builder
@Data

public class AdresseDto {

    private String Adresse1;

    private String Adresse2;

    private String Ville;

    private String codePostale;

    private String Pays;

    public AdresseDto fromEntity(Adresse adresse){
        if (adresse == null){
            return  null;
        }

        return AdresseDto.builder()
                .Adresse1(adresse.getAdresse1())
                .Adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .Ville(adresse.getVille())
                .Pays(adresse.getPays())
                .build();
    }

    public Adresse toEntity(AdresseDto adresseDto){
        if (adresseDto == null){
            return null;
        }

        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());

        return adresse;
    }
}
