package com.exercicio.produtoss.repositories;

import com.exercicio.produtoss.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
