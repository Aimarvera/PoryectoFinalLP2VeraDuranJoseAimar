package modelos;

public class Alumnos {
	private int idAlumno, idGrado;
	private String nombre;
	public Alumnos(int idAlumno, int idGrado, String nombre) {
		super();
		this.idAlumno = idAlumno;
		this.idGrado = idGrado;
		this.nombre = nombre;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getIdGrado() {
		return idGrado;
	}
	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
