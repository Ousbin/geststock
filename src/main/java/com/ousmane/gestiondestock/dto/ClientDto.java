package com.ousmane.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;;
import com.ousmane.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String umTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }

        return  ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .umTel(client.getUmTel())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if (clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setUmTel(clientDto.getUmTel());

        return client;
    }
}
