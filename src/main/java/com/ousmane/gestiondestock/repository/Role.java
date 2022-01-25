package com.ousmane.gestiondestock.repository;

import com.ousmane.gestiondestock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role extends JpaRepository<Roles,Integer> {
}
