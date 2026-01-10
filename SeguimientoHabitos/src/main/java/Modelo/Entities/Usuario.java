package Modelo.Entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
	
    
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;


	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;


	@Column(name = "correo_electronico", unique = true, nullable = false)
	private String correoElectronico;


	@Column(name = "password", nullable = false)
	private String password;


	public Usuario() {}

	public Usuario( String nombre, String apellido, String correoElectronico, String password) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.password = password;
	}

    public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}