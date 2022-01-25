package com.ousmane.gestiondestock.controller.api;

import com.ousmane.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ousmane.gestiondestock.utils.Constants.APP_USER;

public interface UtilisateurApi {

    @PostMapping(value = APP_USER + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(value = APP_USER + "/utilisateurs/{idUtilisateurs}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateurs") Integer id);

    @GetMapping(value = APP_USER + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_USER + "/utilisateurs/delette/{idUtilisateurs}")
    void delete(@PathVariable("idUtilisateurs") Integer id);
}
