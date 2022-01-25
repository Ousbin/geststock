package com.ousmane.gestiondestock.controller;

import com.ousmane.gestiondestock.controller.api.UtilisateurApi;
import com.ousmane.gestiondestock.dto.UtilisateurDto;
import com.ousmane.gestiondestock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }
    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
