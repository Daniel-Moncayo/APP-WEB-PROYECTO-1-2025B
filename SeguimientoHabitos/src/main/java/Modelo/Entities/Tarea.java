package Modelo.Entities;

import java.io.Serializable;

import jakarta.persistence.*; // Si usas JPA/Hibernate

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;

    @Column(name = "nombre_tarea")
    private String nombreTarea; // Cambio de int a String para poder escribir el nombre

    @ManyToOne
    @JoinColumn(name = "id_habito")
    private Habito habito; // Cambio de int a la clase Habito para crear la relación

    public Tarea() {}

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public Habito getHabito() {
		return habito;
	}

	public void setHabito(Habito habito) {
		this.habito = habito;
	}

	public Tarea(int idTarea, String nombreTarea, Habito habito) {
		super();
		this.idTarea = idTarea;
		this.nombreTarea = nombreTarea;
		this.habito = habito;
	}
    
    
    
     
    
}