package com.example.serverlab9;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class RestControllerImagenes {
        @Autowired
        ImagenesRepository imagenesRepository;

        @GetMapping("imagenes/{id}")
        public ResponseEntity<byte[]> mostrarImagenUser(@PathVariable("id") int id2) {
                Optional<Imagenes> opt = imagenesRepository.findById(id2);
                if (opt.isPresent()) {
                        Imagenes f = opt.get();
                        byte[] fotoComoByte = f.getImagen();
                        HttpHeaders httpHeaders = new HttpHeaders();
                        httpHeaders.setContentType(
                                MediaType.parseMediaType("image/png"));
                        return new ResponseEntity<>(
                                fotoComoByte,
                                httpHeaders,
                                HttpStatus.OK);
                } else {
                        return null;
                }
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
