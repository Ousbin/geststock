package com.ousmane.gestiondestock.controller.api;

import com.ousmane.gestiondestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ousmane.gestiondestock.utils.Constants.APP_ETS;

public interface EntrepriseApi {
    @PostMapping(value = APP_ETS + "/entreprises/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(value = APP_ETS + "/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(value = APP_ETS + "/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ETS + "/entreprises/delette/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
