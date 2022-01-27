package com.ousmane.gestiondestock.services.impl;


import com.ousmane.gestiondestock.dto.CategoryDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Category;
import com.ousmane.gestiondestock.repository.CategoryRepository;
import com.ousmane.gestiondestock.services.CategoryService;
import com.ousmane.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;

    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("la category n'est pas valide{}",dto);
            throw new InvalidEntityException("la category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID,errors);
        }

        Category savedCategory = categoryRepository.save(CategoryDto.toEntity(dto));
        return CategoryDto.fromEntity(savedCategory);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null ){
            log.error("Category id est null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune Category avec l'Id = " + id + "n'a été trouver dans la bdd",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }



    @Override
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Article id est null");
            return ;
        }
        categoryRepository.deleteById(id);
    }
}
