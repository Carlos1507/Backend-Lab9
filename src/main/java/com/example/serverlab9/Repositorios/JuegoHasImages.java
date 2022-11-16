package com.example.serverlab9.Repositorios;

import com.example.serverlab9.Entities.JuegoHasImagene;
import com.example.serverlab9.Entities.JuegoHasImageneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoHasImages extends JpaRepository<JuegoHasImagene, JuegoHasImageneId> {
}
