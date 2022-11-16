package com.example.serverlab9.Repositorios;

import com.example.serverlab9.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "select * from usuario where (nombre=?1 and contra =?2)", nativeQuery = true)
    Usuario validarUsuario(String nombre, String contrasenia);

}
