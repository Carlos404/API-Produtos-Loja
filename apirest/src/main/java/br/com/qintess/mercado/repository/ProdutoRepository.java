package br.com.qintess.mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qintess.mercado.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);

	List<Produto> findByCategoria(String categoria);

}
