package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.ClientDto;
import com.ousmane.gestiondestock.dto.EntrepriseDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Client;
import com.ousmane.gestiondestock.model.Entreprise;
import com.ousmane.gestiondestock.repository.EntrepriseRepository;
import com.ousmane.gestiondestock.services.EntrepriseService;
import com.ousmane.gestiondestock.validator.ClientValidator;
import com.ousmane.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }
    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("l'entreprise n'est pas valide{}", dto);
            throw new InvalidEntityException("l'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_FOUND, errors);
        }

        Entreprise savedEntreprise = entrepriseRepository.save(EntrepriseDto.toEntity(dto));
        return EntrepriseDto.fromEntity(savedEntreprise);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null ){
            log.error("L'entreprise id est null");
            return null;
        }

        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune entreprise avec l'Id = " + id + "n'a été trouver dans la bdd",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Client id est null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }
}
