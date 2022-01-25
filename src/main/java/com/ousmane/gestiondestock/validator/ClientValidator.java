package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();
        if (clientDto == null){
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner l'email du client");
            errors.add("Veuillez renseigner l'adresse du client");
            return errors;
        }
        if (!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getMail())){
            errors.add("Veuillez renseigner l'email du client");
        }
        if (clientDto.getAdresse() == null ){
            errors.add("Veuillez renseigner l'adresse du clientr");
        }else {
            if (!StringUtils.hasLength(clientDto.getAdresse().getAdresse1())){
                errors.add("le champs 'Adress1' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getAdresse2())){
                errors.add("le champs 'Adress2' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getVille())){
                errors.add("le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getCodePostale())){
                errors.add("le champs 'Code Postale' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getPays())){
                errors.add("le champs 'Pays' est obligatoire");
            }
        }
        return errors;
    }
}
