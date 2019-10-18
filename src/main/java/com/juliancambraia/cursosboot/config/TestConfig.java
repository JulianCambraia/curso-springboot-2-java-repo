package com.juliancambraia.cursosboot.config;

import com.juliancambraia.cursosboot.entities.Pedido;
import com.juliancambraia.cursosboot.entities.Usuario;
import com.juliancambraia.cursosboot.entities.enums.PedidoStatusEnum;
import com.juliancambraia.cursosboot.repositories.PedidoRepository;
import com.juliancambraia.cursosboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public void run(String... args) throws Exception {
        // quando a aplicação iniciar tudo que estiver dentro deste meto será executado
        Usuario u1 = new Usuario(null, "Maria", "maria@gmail.com", "99999999", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alexgreen@gmail.com", "9977717540", "123456");
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatusEnum.PAGO);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, PedidoStatusEnum.AGUARDANDO_PAGAMENTO);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatusEnum.AGUARDANDO_PAGAMENTO);
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
