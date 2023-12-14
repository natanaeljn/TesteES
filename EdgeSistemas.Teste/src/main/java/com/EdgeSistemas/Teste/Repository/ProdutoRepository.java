package com.EdgeSistemas.Teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EdgeSistemas.Teste.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
