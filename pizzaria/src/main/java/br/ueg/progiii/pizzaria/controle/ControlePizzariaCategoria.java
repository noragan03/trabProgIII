package br.ueg.progiii.pizzaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.progiii.pizzaria.modelo.Categoria;
import br.ueg.progiii.pizzaria.modelo.Pizzaria;
import br.ueg.progiii.pizzaria.service.CategoriaService;

@RestController
@RequestMapping(path = "api/v1/categorias")
public class ControlePizzariaCategoria {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping(path="add")
	public Categoria adicionar(@RequestBody Categoria categoria) {
		return categoriaService.adicionar(categoria);
	}
	
	@GetMapping(path="id/{idCategoria}")
	public Categoria buscaId(@PathVariable("idCategoria") Long idCategoria)
	{
		return categoriaService.getCategoria(idCategoria);
	}
	
//	@GetMapping(path="categoria/{categoria}")
//	public List<Pizzaria> buscaCategoria(@PathVariable("categoria") String categoria){
//		
//		return categoriaService.obterCategoria(categoria);
//	}
//	
	@DeleteMapping(path = "id/{idCategoria}")
	public Categoria remover(@PathVariable("idCategoria") Long idCategoria) {
		return categoriaService.remover(idCategoria);
	}
	
	@PatchMapping (path = "id/{idCategoria}")
	public Categoria alterar(@RequestBody Categoria categoria, @PathVariable("idCategoria") Long idCategoria) {
		return categoriaService.alterar(categoria, idCategoria);
	}
	
	@GetMapping
	public List<Categoria> listarTodos(){
		return categoriaService.listarTodos();
	}
	
}
