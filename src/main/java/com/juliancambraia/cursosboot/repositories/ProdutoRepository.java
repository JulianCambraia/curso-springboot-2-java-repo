package com.juliancambraia.cursosboot.repositories;

import com.juliancambraia.cursosboot.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
