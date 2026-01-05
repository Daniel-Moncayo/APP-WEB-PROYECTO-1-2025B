package Modelo.Entities;

import java.sql.Time;
import java.util.Date;

public class Habito {

	private int idHabito;
	private String nombre;
	private Categoria categoria;
	private Date fechaInicio;
	private int frecuencia;
	private String dia;
	private Time horario;

}