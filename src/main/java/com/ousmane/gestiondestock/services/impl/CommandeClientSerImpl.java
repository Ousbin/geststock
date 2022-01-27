package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.CommandeClientDto;
import com.ousmane.gestiondestock.dto.LigneCommandeClientDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Article;
import com.ousmane.gestiondestock.model.Client;
import com.ousmane.gestiondestock.model.LigneCommandeClient;
import com.ousmane.gestiondestock.repository.ArticleRepository;
import com.ousmane.gestiondestock.repository.ClientRepository;
import com.ousmane.gestiondestock.repository.CommandeClientRepository;
import com.ousmane.gestiondestock.repository.LigneCommandeClientRepository;
import com.ousmane.gestiondestock.services.CommandeClient;
import com.ousmane.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class CommandeClientSerImpl implements CommandeClient {

    private CommandeClientRepository commandeClientRepository;
    LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public  CommandeClientSerImpl(CommandeClientRepository commandeClientRepository,ClientRepository clientRepository,
                                  ArticleRepository articleRepository,LigneCommandeClientRepository ligneCommandeClientRepository       ){
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Commande client n'est pas valide");
            throw new EntityNotFoundException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()){
            log.warn("Client avec l'ID n'est pas dans la base", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getClient().getId() + "n'a ete trouve dans la BDD",ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(LigCodClt ->{
                if (LigCodClt.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(LigCodClt.getArticle().getId());
                    articleErrors.add("L'article avce l'ID" + LigCodClt.getArticle().getId() + "n'existe pas");
                }
            });
        }
        if (!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }
        com.ousmane.gestiondestock.model.CommandeClient savedCodClt =  commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if (dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(LigCodClt ->{
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(LigCodClt);
                ligneCommandeClient.setCommandeClient( savedCodClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(savedCodClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null ){
            log.error("Commande Client id est null");
            return null;
        }

        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune Commande client n'a ete trouver avec l'ID" + id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
       if (!StringUtils.hasLength(code)){
           log.error("Commande client Code is NULL");
           return null;
       }
       return commandeClientRepository.findCommandeClientByCode(code)
               .map(CommandeClientDto::fromEntity)
               .orElseThrow(()-> new EntityNotFoundException("Aucune Commande client n'a ete trouver avec le CODE" + code,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Commande Client id est null");
            return ;
        }
        commandeClientRepository.deleteById(id);
    }
}
