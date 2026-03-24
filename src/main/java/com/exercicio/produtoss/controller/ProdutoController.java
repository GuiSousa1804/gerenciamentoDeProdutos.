package com.exercicio.produtoss.controller;

import com.exercicio.produtoss.models.ProdutoModel;
import com.exercicio.produtoss.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> requeste = produtoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Long id) {
        ProdutoModel produtoModel = produtoService.findById(id);
        return ResponseEntity.ok(produtoModel);
    }
}
