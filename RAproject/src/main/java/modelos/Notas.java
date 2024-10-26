package modelos;

public class Notas {
	private int idNota, idAlumno;
	private String registro;
	private double nota;
	public Notas(int idNota, int idAlumno, String registro, double nota) {
		super();
		this.idNota = idNota;
		this.idAlumno = idAlumno;
		this.registro = registro;
		this.nota = nota;
	}
	public int getIdNota() {
		return idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
}
