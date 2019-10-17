package com.juliancambraia.cursosboot.resources;

import com.juliancambraia.cursosboot.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "99999999", "123456");
        return ResponseEntity.ok().body(u);
    }
}


