package com.ousmane.gestiondestock.services;

import com.ousmane.gestiondestock.dto.ClientDto;
import com.ousmane.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);

}
