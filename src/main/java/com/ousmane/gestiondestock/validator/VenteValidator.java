package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VentesDto ventesDto){
        List<String> errors = new ArrayList<>();
        if(ventesDto == null){
            errors.add("Veuillez renseigner le code vente");
            errors.add("Veuillez renseigner la date vente");
        }
        if (!StringUtils.hasLength(ventesDto.getCode())){
            errors.add("Veuillez renseigner le code vente");
        }
        if (ventesDto.getDateVente() == null){
            errors.add("Veuillez renseigner la date vente");
        }
        return errors;
    }
}
