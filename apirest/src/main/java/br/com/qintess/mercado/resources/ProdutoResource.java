package br.com.qintess.mercado.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.mercado.models.Produto;
import br.com.qintess.mercado.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto")
	@ResponseBody
	@ApiOperation(value="Retorna produto pela ID")
	public Produto listaProdutoId(@RequestParam long id) {
		return produtoRepository.findById(id);
	}

	@GetMapping("")
	@ResponseBody
	@ApiOperation(value="Retorna produtos por categoria")
	public List<Produto> listaProdutosCategoria(@RequestParam String categoria) {
		return produtoRepository.findByCategoria(categoria);
	}

	@PostMapping("/produto")
	@ApiOperation(value="Salva produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta Produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza produtos")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	

}
