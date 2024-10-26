package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Notas;
import util.MySQLConexion;

public class ServicioNotas {
	public List<Notas> getNotas() throws Exception{
		List<Notas> Nota = new ArrayList<>();
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null;
		
		//ESTABLECER CONEXION
		miConexion = MySQLConexion.getConexion();
		
		//CREAR SENTENCIA SQL
		//String instruccionSql = "select * from tb_productos;";
		String instruccionSql = "SELECT * FROM TB_NOTAS;";
		miStatement = miConexion.createStatement();
		
		//EJECUTAR SQL
		miResultSet = miStatement.executeQuery(instruccionSql);
		
		//RECOGER EL RESULTSET OBTENIDO
		while(miResultSet.next()) {
		
		    // Obtener los campos del producto
		    int id_nota = miResultSet.getInt("id");
		    int id_alumno = miResultSet.getInt("id_alumno");
		    String registro = miResultSet.getString("registro");
		    double nota = miResultSet.getDouble("nota");
		    
		    // Crear el objeto Producto con los datos obtenidos
		    Notas tempNotas = new Notas(id_nota, id_alumno, registro, nota);
		    
			Nota.add(tempNotas);
			
			
		}
		return Nota;
	}
	
	public Notas getNota(String codigoNota) {
		Notas laNota = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultset = null;
		String cNota = codigoNota;
		try {
			//ESTABLECER CONEXIÓN A BD
			miConexion = MySQLConexion.getConexion();
			
			//CREAR SQL QUE BUSQUE EL PRODUCTO
			String sql = "SELECT * FROM TB_NOTAS WHERE ID=?;";
			
			//CREAR EL PRPEPARED STATEMENT
			miStatement=miConexion.prepareStatement(sql);
			
			//ESTABLECER PARÁMETROS
			miStatement.setString(1, cNota);
			
			//EJECUTAR LA CONSULTA
			miResultset=miStatement.executeQuery();
			
			//OBTENER LOS DATOS  DE RESPUESTA
			if(miResultset.next()) {
				
			    int id_nota = miResultset.getInt("id");
			    int id_alumno = miResultset.getInt("id_alumno");
			    String registro = miResultset.getString("registro");
			    double nota = miResultset.getDouble("nota");
				
				laNota=new Notas(id_nota, id_alumno, registro, nota);
				
			}else {
				throw new Exception("No encontramos la nota con código " + cNota);
			}
		}catch(Exception e) {
			
		}
		return laNota;
	}
	
	public List<Notas> getNotasID() throws Exception{
		List<Notas> Nota = new ArrayList<>();
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null;
		
		//ESTABLECER CONEXION
		miConexion = MySQLConexion.getConexion();
		
		//CREAR SENTENCIA SQL
		//String instruccionSql = "select * from tb_productos;";
		String instruccionSql = "SELECT * FROM TB_NOTAS WHERE ID_ALUMNO=?;";
		miStatement = miConexion.createStatement();
		
		//EJECUTAR SQL
		miResultSet = miStatement.executeQuery(instruccionSql);
		
		//RECOGER EL RESULTSET OBTENIDO
		while(miResultSet.next()) {
		
		    // Obtener los campos del producto
		    int id_nota = miResultSet.getInt("id");
		    int id_alumno = miResultSet.getInt("id_alumno");
		    String registro = miResultSet.getString("registro");
		    double nota = miResultSet.getDouble("nota");
		    
		    // Crear el objeto Producto con los datos obtenidos
		    Notas tempNotasid = new Notas(id_nota, id_alumno, registro, nota);
		    
			Nota.add(tempNotasid);
			
			
		}
		return Nota;
	}

	public void eliminarNota(String codNota)throws Exception {
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		//ESTABLECER LA CONEXION
		miConexion = MySQLConexion.getConexion();
				
		//CREAR SENTENCIA SQL
		String sql = "DELETE FROM TB_NOTAS WHERE ID=?";
		
		//CREAR EL PRPEPARED STATEMENT
		miStatement=miConexion.prepareStatement(sql);
		miStatement.setString(1, codNota);
		
		//EJECUTAR LA SENTENCIA SQL
		miStatement.execute();
	}

	public void actualizarNota(Notas notaActualizada) throws Exception {
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		//ESTABLECER LA CONEXION
		miConexion = MySQLConexion.getConexion();
		
		//CREAR SENTENCIA SQL
		String sql = "UPDATE tb_notas SET nota = ?, id_alumno = ?, registro = ? WHERE id = ?;";
		
		//CREAR EL PRPEPARED STATEMENT
		miStatement=miConexion.prepareStatement(sql);
		
		//ESTABLECER PARÁMETROS
		miStatement.setDouble(1, notaActualizada.getNota());
		miStatement.setInt(2, notaActualizada.getIdAlumno());
		miStatement.setString(3, notaActualizada.getRegistro());
		miStatement.setInt(4, notaActualizada.getIdNota());
		
		//EJECUTAR LA INSTRUCCION SQL
		miStatement.execute();
	}

	public void agregarLaNuevaNota(Notas nuevaNota) {
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		//CONECTAR A BD
		try {
			miConexion = MySQLConexion.getConexion();
			//CREAR INSTRUCCION QUE INSERTE EL PRODUCTO
			String SQL = "INSERT INTO tb_notas (id, id_alumno, registro, nota) VALUES(?, ?, ?, ?);";
			miStatement = miConexion.prepareStatement(SQL);
			//ESTABLECER PARÁMETRSO PARA EL PRODUCTO
			miStatement.setInt(1, nuevaNota.getIdNota());
			miStatement.setInt(2, nuevaNota.getIdAlumno());
			miStatement.setString(3, nuevaNota.getRegistro());
			miStatement.setDouble(4, nuevaNota.getNota());
			
			//EJECUTAR LA INSTRUCCION SQL
			miStatement.execute();
		}catch(Exception e){
			
		}
	}
}
