package controladores;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ControladorPruebas
 */
public class ControladorPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//CREAR EL OBJETO PRINT WRITER
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		//CREAR CONEXION A BD
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null;
		
		try {
			miConexion = util.MySQLConexion.getConexion();
			String miSQL = "select * from tb_notas;";
			miStatement = miConexion.createStatement();
			miResultSet = miStatement.executeQuery(miSQL);
			while(miResultSet.next()) {
				double nota = miResultSet.getDouble(4);
				salida.println(nota);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
