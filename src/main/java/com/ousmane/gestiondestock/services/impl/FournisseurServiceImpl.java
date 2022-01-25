package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.ClientDto;
import com.ousmane.gestiondestock.dto.FournisseurDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Client;
import com.ousmane.gestiondestock.model.Fournisseur;
import com.ousmane.gestiondestock.repository.FournisseurRepository;
import com.ousmane.gestiondestock.services.FournisseurService;
import com.ousmane.gestiondestock.validator.ClientValidator;
import com.ousmane.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("le fournisseur n'est pas valide{}", dto);
            throw new InvalidEntityException("le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_FOUND, errors);
        }

        Fournisseur savedFournisseur = fournisseurRepository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.fromEntity(savedFournisseur);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null ){
            log.error("Fournisseur id est null");
            return null;
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Fournisseur avec l'Id = " + id + "n'a été trouver dans la bdd",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Client id est null");
            return ;
        }
        fournisseurRepository.deleteById(id);
    }
}
