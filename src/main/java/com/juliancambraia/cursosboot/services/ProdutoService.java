package com.juliancambraia.cursosboot.services;

import com.juliancambraia.cursosboot.entities.Produto;
import com.juliancambraia.cursosboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }
}
