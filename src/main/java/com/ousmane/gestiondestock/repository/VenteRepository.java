package com.ousmane.gestiondestock.repository;

import com.ousmane.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Ventes,Integer> {
}
