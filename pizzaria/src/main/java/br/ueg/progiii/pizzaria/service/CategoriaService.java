package br.ueg.progiii.pizzaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.ueg.progiii.pizzaria.modelo.Categoria;
import br.ueg.progiii.pizzaria.modelo.Pizzaria;
import br.ueg.progiii.pizzaria.repository.CategoriaRepository;
import br.ueg.progiii.pizzaria.repository.PizzariaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria adicionar(Categoria categoria) {
		Boolean existeCategoria = categoriaRepository.existeCategoria(categoria.getCategoria());
		
		if(existeCategoria)//Verifica se a pizza existe
		{
			throw new IllegalStateException("A categoria: "+categoria.getCategoria()+" já está na lista");
		}
		Categoria categoriaRetorno = categoriaRepository.save(categoria);
		
		return categoriaRetorno;
	}
	
	public List<Categoria> listarTodos(){
		return categoriaRepository.findAll();
	}

	public Categoria getCategoria(Long idCategoria) {
		Optional<Categoria> categoria= obterCategoriaExistente(idCategoria);
		return categoria.get();
	}
	
	public Optional<Categoria> obterCategoriaExistente(Long idCategoria) {
		Optional<Categoria> categoria= categoriaRepository.findById(idCategoria);
		if(!categoria.isPresent()) {
			throw new IllegalStateException("Não existe uma categoria com o ID: "+idCategoria);
		}
		return categoria;
	}

	public Categoria alterar(Categoria categoria, Long idCategoria) {
		Optional<Categoria> categoriaOptional = obterCategoriaExistente(idCategoria);
		Categoria categoriaBD = categoriaOptional.get();
		
		if(StringUtils.hasLength(categoria.getCategoria())) {
			categoriaBD.setCategoria(categoria.getCategoria());
		}
		
		categoriaBD = categoriaRepository.save(categoriaBD);
		return categoriaBD;
	}

	public Categoria remover(Long idCategoria) {
		Optional<Categoria> categoriaOptional = obterCategoriaExistente(idCategoria);
		Categoria categoria = categoriaOptional.get();
		categoriaRepository.delete(categoria);
		return categoria;
	}
}
