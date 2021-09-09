package br.ueg.progiii.pizzaria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Categoria")
@Table(
		name = "Categoria",
		uniqueConstraints = {
				@UniqueConstraint(name="uk_categoria_pizza_unico", columnNames = "categoria")
							}
	  )
public @Data class Categoria {

	@Id
	@SequenceGenerator(name="categoria_sequence", sequenceName = "categoria_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
	private Long id;
	
	@Column(name = "categoria", nullable = false, length = 40, unique = true)	
	private String categoria;
}
