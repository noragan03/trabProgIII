package br.ueg.progiii.pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ueg.progiii.pizzaria.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findByCategoria(String categoria);
		
	@Query(""+
	"SELECT CASE WHEN COUNT(c) > 0 THEN "+
	"TRUE ELSE FALSE END " + 
	"FROM Categoria c "+
	"WHERE lower(c.categoria)=lower(?1)" //com a adicao de lower ele vai encontrar palavras escritas com letras minusculas tambem
	)
	Boolean existeCategoria(String categoria); //Precisa do banco de dados para confirmar
	
}
