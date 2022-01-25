package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner l'email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
            return errors;
        }
        if (!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMail())){
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }
        if (utilisateurDto.getAdresse() == null ){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        }else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("le champs 'Adress1' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse2())){
                errors.add("le champs 'Adress2' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("le champs 'Code Postale' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("le champs 'Pays' est obligatoire");
            }
        }
        return errors;
    }
}
