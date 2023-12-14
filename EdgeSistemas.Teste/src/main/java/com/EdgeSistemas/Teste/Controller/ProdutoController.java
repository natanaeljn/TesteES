package com.EdgeSistemas.Teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EdgeSistemas.Teste.Dto.ProdutoDto;
import com.EdgeSistemas.Teste.Exception.ProdutoException;
import com.EdgeSistemas.Teste.Model.Produto;
import com.EdgeSistemas.Teste.Services.ProdutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
@Validated
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> criarProduto(@Valid @RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(this.produtoService.criarProduto(produto));
		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao criar o Produto" + e.getMessage());
		}
	}

	@GetMapping("/todosProdutos")
	public ResponseEntity<List<ProdutoDto>> listarTodos() {
		List<ProdutoDto> produtos = produtoService.listarTodos();
		try {

			return ResponseEntity.ok(this.produtoService.listarTodos());

		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body(produtos);
		}

	}

	@GetMapping("/buscaPorCodigo/{codigo}")
	public ResponseEntity<?> buscaPorCodigo(@PathVariable("codigo") Long codigo) {
		try {
			return ResponseEntity.ok(this.produtoService.buscarPorCodigo(codigo));
		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao realizar a busca por codigo" + e.getMessage());
		}
	}

	@PutMapping("/alterarProduto/{idEditavel}")
	public ResponseEntity<?> editarProduto(@PathVariable("idEditavel") Long idEditavel, @RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(this.produtoService.alterarProduto(idEditavel, produto));

		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao editar o produto" + e.getMessage());
		}
	}

	@DeleteMapping("/deletarProduto/{codigo}")
	public ResponseEntity<String> deletarProduto(@PathVariable("codigo") Long codigo) {
		try {
			return ResponseEntity.ok(this.produtoService.deletarProduto(codigo));
		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao deletar produto" + e.getMessage());
		}
	}
	
	@GetMapping("/buscaPorNome/{nome}")
	public ResponseEntity<?> buscaPorCodigo(@PathVariable("nome") String nome) {
		try {
			return ResponseEntity.ok(this.produtoService.buscarPorNome(nome));
		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao realizar a busca por Nome" + e.getMessage());
		}
	}
	
	@GetMapping("/buscaPorMarca/{marca}")
	public ResponseEntity<?> buscaPorMarca(@PathVariable("marca") String marca) {
		try {
			return ResponseEntity.ok(this.produtoService.buscarPorMarca(marca));
		} 
		catch (ProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao realizar a busca por Marca" + e.getMessage());
		}
	}

}
