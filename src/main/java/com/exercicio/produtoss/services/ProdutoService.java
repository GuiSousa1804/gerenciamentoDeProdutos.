package com.exercicio.produtoss.services;

import com.exercicio.produtoss.models.ProdutoModel;
import com.exercicio.produtoss.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        ProdutoModel produto = produtoRepository.findById(id).get();
        produto.setNome(produtoModel.getNome());
        produto.setPreco(produtoModel.getPreco());
        produto.setDescricao(produtoModel.getDescricao());
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
