package com.juliancambraia.cursosboot.config;

import com.juliancambraia.cursosboot.entities.Usuario;
import com.juliancambraia.cursosboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {
        // quando a aplicação iniciar tudo que estiver dentro deste meto será executado
        Usuario u1 = new Usuario(null, "Maria", "maria@gmail.com", "99999999", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alexgreen@gmail.com", "9977717540", "123456");
        usuarioRepository.saveAll(Arrays.asList(u1, u2));
    }
}
