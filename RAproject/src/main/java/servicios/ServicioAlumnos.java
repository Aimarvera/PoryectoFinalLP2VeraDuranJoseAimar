package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modelos.Alumnos;
import util.MySQLConexion;

public class ServicioAlumnos {
	public List<Alumnos> getAlumnos() throws Exception{
		
		List<Alumnos> Alumno = new ArrayList<>();
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null;
		
		//ESTABLECER CONEXION
		miConexion = MySQLConexion.getConexion();
		
		//CREAR SENTENCIA SQL
		String instruccionSql = "SELECT * FROM tb_alumnos";
		miStatement = miConexion.createStatement();
		
		//EJECUTAR SQL
		miResultSet = miStatement.executeQuery(instruccionSql);
		
		//RECOGER EL RESULTSET OBTENIDO
		while(miResultSet.next()) {
			int id_alumno = miResultSet.getInt("ID");
			int id_grado = miResultSet.getInt("ID_GRADO");
			String nombre = miResultSet.getString("NOMBRE");
			
			Alumnos tempAlumno = new Alumnos(id_alumno, id_grado,nombre);
			Alumno.add(tempAlumno);
		}
		return Alumno;
	}
	
	public Alumnos getAlumno(String codigoAlumno) {
		Alumnos elAlumno = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultset = null;
		String cAlumno = codigoAlumno;
		try {
			//ESTABLECER CONEXIÓN A BD
			miConexion = MySQLConexion.getConexion();
			
			//CREAR SQL QUE BUSQUE EL PRODUCTO
			String sql = "SELECT * FROM TB_ALUMNOS WHERE ID=?";
			
			//CREAR EL PRPEPARED STATEMENT
			miStatement=miConexion.prepareStatement(sql);
			
			//ESTABLECER PARÁMETROS
			miStatement.setString(1, cAlumno);
			
			//EJECUTAR LA CONSULTA
			miResultset=miStatement.executeQuery();
			
			//OBTENER LOS DATOS  DE RESPUESTA
			if(miResultset.next()) {
				int id_alumno = miResultset.getInt("ID");
				int id_grado = miResultset.getInt("ID_GRADO");
				String nombre = miResultset.getString("NOMBRE");
				
				elAlumno=new Alumnos(id_alumno, id_grado, nombre);
				
			}else {
				throw new Exception("No encontramos el alumno con código " + cAlumno);
			}
		}catch(Exception e) {
			
		}
		return elAlumno;
	}	
}
