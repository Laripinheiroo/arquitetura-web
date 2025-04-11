package com.example.persistencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistencia.model.Produto;
import com.example.persistencia.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Busca todos os produtos no banco
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    // Busca um produto pelo ID
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    // Salva um novo produto
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualiza um produto existente
    public Optional<Produto> update(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setName(produtoAtualizado.getName());
            produto.setDescription(produtoAtualizado.getDescription());
            return produtoRepository.save(produto);
        });
    }

    // Deleta um produto pelo ID
    public boolean deleteById(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
