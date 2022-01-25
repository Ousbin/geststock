package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.FournisseurDto;
import com.ousmane.gestiondestock.dto.UtilisateurDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Fournisseur;
import com.ousmane.gestiondestock.model.Utilisateur;
import com.ousmane.gestiondestock.repository.UtilisateurRepository;
import com.ousmane.gestiondestock.services.UtilisateurService;
import com.ousmane.gestiondestock.validator.FournisseurValidator;
import com.ousmane.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("l'utilisateur n'est pas valide{}", dto);
            throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_FOUND, errors);
        }

        Utilisateur savedUtilisateur = utilisateurRepository.save(UtilisateurDto.toEntity(dto));
        return UtilisateurDto.fromEntity(savedUtilisateur);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null ){
            log.error("Utilisateur id est null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun utilisateur avec l'Id = " + id + "n'a été trouver dans la bdd",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Client id est null");
            return ;
        }
        utilisateurRepository.deleteById(id);
    }
}
