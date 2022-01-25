package com.ousmane.gestiondestock.controller.api;

import com.ousmane.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ousmane.gestiondestock.utils.Constants.APP_FRS;

public interface FournisseurApi {

    @PostMapping(value = APP_FRS + "/fournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value = APP_FRS + "/fournisseurs/{idFournisseurs}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseurs") Integer id);

    @GetMapping(value = APP_FRS + "/fournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_FRS + "/fournisseurs/delette/{idFournisseurs}")
    void delete(@PathVariable("idFournisseurs") Integer id);
}
