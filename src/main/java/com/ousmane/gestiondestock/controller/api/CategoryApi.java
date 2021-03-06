package com.ousmane.gestiondestock.controller.api;

import com.ousmane.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ousmane.gestiondestock.utils.Constants.APP_CAT;

public interface CategoryApi {

    @PostMapping(value = APP_CAT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_CAT + "/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_CAT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_CAT + "/category/delette/{idCategory}")
    void delete(@PathVariable("idCategory") Integer id);
}
