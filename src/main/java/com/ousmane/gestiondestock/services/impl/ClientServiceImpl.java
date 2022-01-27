package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.ClientDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Client;
import com.ousmane.gestiondestock.repository.ClientRepository;
import com.ousmane.gestiondestock.services.ClientService;
import com.ousmane.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public  ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("le client n'est pas valide{}", dto);
            throw new InvalidEntityException("le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        Client savedClient = clientRepository.save(ClientDto.toEntity(dto));
        return ClientDto.fromEntity(savedClient);
    }


    @Override
    public ClientDto findById(Integer id) {
        if (id == null ){
            log.error("Category id est null");
            return null;
        }

        Optional<Client> client = clientRepository.findById(id);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Client avec l'Id = " + id + "n'a été trouver dans la bdd",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null ){
            log.error("Client id est null");
            return ;
        }
        clientRepository.deleteById(id);

    }
}
