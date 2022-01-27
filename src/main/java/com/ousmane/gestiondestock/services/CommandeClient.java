package com.ousmane.gestiondestock.services;

import com.ousmane.gestiondestock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClient {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete(Integer id);
}
