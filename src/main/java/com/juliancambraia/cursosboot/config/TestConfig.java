package com.juliancambraia.cursosboot.config;

import com.juliancambraia.cursosboot.entities.Categoria;
import com.juliancambraia.cursosboot.entities.Pedido;
import com.juliancambraia.cursosboot.entities.Produto;
import com.juliancambraia.cursosboot.entities.Usuario;
import com.juliancambraia.cursosboot.entities.enums.PedidoStatusEnum;
import com.juliancambraia.cursosboot.repositories.CategoriaRepository;
import com.juliancambraia.cursosboot.repositories.PedidoRepository;
import com.juliancambraia.cursosboot.repositories.ProdutoRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // quando a aplicação iniciar tudo que estiver dentro deste meto será executado
        Usuario u1 = new Usuario(null, "Maria", "maria@gmail.com", "99999999", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alexgreen@gmail.com", "9977717540", "123456");
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatusEnum.PAGO);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, PedidoStatusEnum.AGUARDANDO_PAGAMENTO);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, PedidoStatusEnum.AGUARDANDO_PAGAMENTO);
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Produto pr1 = new Produto("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pr2 = new Produto("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pr3 = new Produto("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pr4 = new Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pr5 = new Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        pr1.getCategorias().add(cat2);
        pr2.getCategorias().addAll(Arrays.asList(cat1, cat3));
        pr3.getCategorias().add(cat3);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

    }
}
