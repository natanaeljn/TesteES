package com.EdgeSistemas.Teste.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EdgeSistemas.Teste.Dto.ProdutoDto;
import com.EdgeSistemas.Teste.Model.Produto;
import com.EdgeSistemas.Teste.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto criarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<ProdutoDto> listarTodos() {
		return produtoRepository.findAll().stream().map(ProdutoDto::new).toList();
	}

	public Produto buscarPorCodigo(Long id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		return produto;
	}

	public Produto alterarProduto(Long idProdutoEditavel, Produto produtoEditado) {
		Produto prod = produtoRepository.findById(idProdutoEditavel).get();
		prod.setId(produtoEditado.getId());
		prod.setNome(produtoEditado.getNome());
		prod.setPreco(produtoEditado.getPreco());
		prod.setMarca(produtoEditado.getMarca());
		return prod;
	}

	public String deletarProduto(Long id) {
		produtoRepository.deleteById(id);
		return "deletado";
	}

}
