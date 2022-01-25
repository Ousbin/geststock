package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();
        if (entrepriseDto == null){
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner l'email de l'entreprise");
            errors.add("Veuillez renseigner le code fiscal de l'entreprise");
            errors.add("Veuillez renseigner l'adresse de l'entreprise");
            errors.add("Veuillez renseigner le numero de l'entreprise");
            return errors;
        }
        if (!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("Veuillez renseigner le prenom de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Veuillez renseigner le code fiscal de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de l'entreprise");
        }
        if (entrepriseDto.getAdresse() == null ){
            errors.add("Veuillez renseigner l'adresse de l'entreprise");
        }else {
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())){
                errors.add("le champs 'Adress1' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse2())){
                errors.add("le champs 'Adress2' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())){
                errors.add("le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())){
                errors.add("le champs 'Code Postale' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())){
                errors.add("le champs 'Pays' est obligatoire");
            }
        }
        return errors;
    }
}
