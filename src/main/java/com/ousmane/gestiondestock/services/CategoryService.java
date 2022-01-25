package com.ousmane.gestiondestock.services;

import com.ousmane.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
