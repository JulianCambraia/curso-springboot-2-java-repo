package com.juliancambraia.cursosboot.repositories;

import com.juliancambraia.cursosboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
