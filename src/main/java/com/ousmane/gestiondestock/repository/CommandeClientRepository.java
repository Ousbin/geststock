package com.ousmane.gestiondestock.repository;

import com.ousmane.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
}
