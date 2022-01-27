package com.ousmane.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ousmane.gestiondestock.model.CommandeClient;
import com.ousmane.gestiondestock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data

public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private String dateCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
        }

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .build();
    }

    public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if (commandeFournisseurDto == null){
            return null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());

        return commandeFournisseur;
    }
}
