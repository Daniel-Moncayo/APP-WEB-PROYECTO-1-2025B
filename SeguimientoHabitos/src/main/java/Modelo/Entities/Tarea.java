package Modelo.Entities;

import jakarta.persistence.*; // Si usas JPA/Hibernate

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;

    @Column(name = "nombre_tarea")
    private String nombreTarea; // Cambio de int a String para poder escribir el nombre

    @ManyToOne
    @JoinColumn(name = "id_habito")
    private Habito habito; // Cambio de int a la clase Habito para crear la relación

    // Constructores, Getters y Setters
}