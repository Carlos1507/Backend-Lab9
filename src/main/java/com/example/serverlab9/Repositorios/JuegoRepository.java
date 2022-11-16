package com.example.serverlab9.Repositorios;

import com.example.serverlab9.Entities.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Integer> {
}
