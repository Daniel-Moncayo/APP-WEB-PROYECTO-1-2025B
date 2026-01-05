package Modelo.Entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="Habito")


public class Habito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHabito;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne // Un hábito tiene una categoría
    @JoinColumn(name = "id_categoria") // Nombre de la columna en la BD
    private Categoria categoria;

    @Temporal(TemporalType.DATE) // Indica que en la BD solo guarde la fecha
    private Date fechaInicio;

    private int frecuencia;
    private String dia;

    @Temporal(TemporalType.TIME) // Indica que en la BD solo guarde la hora
    private Date horario;

}