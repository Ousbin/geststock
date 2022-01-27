package com.ousmane.gestiondestock.validator;

import com.ousmane.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors =new ArrayList<>();
        if (commandeClientDto == null){
            errors.add("Veuillez renseigner le code du commandeClient");
            errors.add("Veuillez renseigner la date du commandeClient ");
            errors.add("Veuillez renseigner le Client");

            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Veuillez renseigner le code du commandeClient");
        }
        if (commandeClientDto.getDateCommande() == null){
            errors.add("Veuillez renseigner la date du commandeClient");
        }
        if (commandeClientDto.getClient() == null){
            errors.add("Veuillez renseigner le Client");
        }

        return errors;
    }
}
