package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors =new ArrayList<>();
        if (fournisseurDto == null){
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le prenom du fournisseur");
            errors.add("Veuillez renseigner l'email du fournisseur");
            errors.add("Veuillez renseigner le numero du fournisseur");
            errors.add("Veuillez renseigner l'adresse du fournisseur");
            return errors;
        }
        if (!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getMail())){
            errors.add("Veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getUmTel())){
            errors.add("Veuillez renseigner le numero du fournisseur");
        }
        if (fournisseurDto.getCommandeFournisseurs() == null ){
            errors.add("Veuillez renseigner la commande du fournisseur ");
        }
        if (fournisseurDto.getAdresse() == null ){
            errors.add("Veuillez renseigner l'adresse du fournisseur");
        }else {
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getAdresse1())){
                errors.add("le champs 'Adress1' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getAdresse2())){
                errors.add("le champs 'Adress2' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getVille())){
                errors.add("le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getCodePostale())){
                errors.add("le champs 'Code Postale' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getPays())){
                errors.add("le champs 'Pays' est obligatoire");
            }
        }
        return errors;
    }
}
