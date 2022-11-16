package com.example.serverlab9;


import com.example.serverlab9.Entities.Usuario;
import com.example.serverlab9.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class RestControllerImagenes {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuario/obtener")
    public ResponseEntity<HashMap<String, Object>> obtenerUsuarioPorNombreContras(@RequestParam("nombre") String nombre,
                                                                  @RequestParam("contrasenia") String contrasenia){
        HashMap<String, Object> responseMap = new HashMap<>();
        Usuario u= usuarioRepository.validarUsuario(nombre, contrasenia);
        responseMap.put("Usuario", u);
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
