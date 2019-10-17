package com.juliancambraia.cursosboot.repositories;

import com.juliancambraia.cursosboot.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
