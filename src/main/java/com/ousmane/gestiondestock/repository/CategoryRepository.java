package com.ousmane.gestiondestock.repository;


import com.ousmane.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
