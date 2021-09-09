package br.ueg.progiii.pizzaria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.progiii.pizzaria.modelo.Categoria;
import br.ueg.progiii.pizzaria.modelo.Pizzaria;
import br.ueg.progiii.pizzaria.repository.PizzariaRepository;
import br.ueg.progiii.pizzaria.repository.CategoriaRepository;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(PizzariaRepository pizzariaRepository, CategoriaRepository pizzariaRepositoryCategoria) {
		return args -> {
			Pizzaria pizza = new Pizzaria(null, "Peperonni","Salgada","Tomate, queijo, milho, peperonni", 50.00, false);
			
			Categoria categoria = new Categoria(null,"Salgada");
			
			pizzariaRepositoryCategoria.save(categoria);
			pizzariaRepository.save(pizza);
		};
	}
}
