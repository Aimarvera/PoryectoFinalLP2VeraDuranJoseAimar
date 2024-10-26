package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Alumnos;
import modelos.Notas;
import servicios.ServicioAlumnos;
import servicios.ServicioNotas;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ControladorNotas
 */
public class ControladorNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServicioNotas servicioNotas;
	private ServicioAlumnos servicioAlumnos;

    public void init() throws ServletException {
        super.init();

        try {
            servicioNotas = new ServicioNotas();
            servicioAlumnos = new ServicioAlumnos();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String elComando = request.getParameter("instruccion");

	    if (elComando == null) {
	        elComando = "listar";
	    }
	    switch (elComando) {
        case "listar":
            obtenerNotas(request, response);
            break;
        case "insertarBBDD":
            agregarNotas(request, response);
            break;
		case "cargar":
			try {
				cargaProductos(request,response);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case "actualizarBBDD":
			try {
				actualizaNotas(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "eliminar":
			try {
				eliminaNotas(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
        default:
            obtenerNotas(request, response);
	    }
	}
	private void eliminaNotas(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// CAPTURAR EL CODIGO ARTÍCULO
		String IDNota=request.getParameter("CNota");
		//BORRAR PRODUCTO DE LA BD
		servicioNotas.eliminarNota(IDNota);
		// VOLVER AL LISTADO DE PRODUCTOS
		obtenerNotas(request,response);
	}
	private void actualizaNotas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// LEER LA INFORMACION DEL PRODUCTO QUE VIENE DEL FORMULARIO
		int IdNota = Integer.parseInt(request.getParameter("idNota"));
		int IdAlumno = Integer.parseInt(request.getParameter("idAlumno"));
		String Registro = request.getParameter("registro");
		double Nota = Double.parseDouble(request.getParameter("nota"));
		
		//CREAR UN OBJETO DE TIPO PRODUCTO
		Notas NotaActualizada = new Notas(IdNota, IdAlumno, Registro, Nota);
		
		//ACTUALIZAR LA BD CON LA INFO DEL ONJ PRODUCTO
		servicioNotas.actualizarNota(NotaActualizada);
		
		//VOLVER AL LISTADO DE PRODUCTOS
		obtenerNotas(request,response);
	}
	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//LEER EL CÓDIGO DEL ARTÍCULO QUE VIENE DEL LISTADO
		String codigoNota=request.getParameter("CNota");
		//ENVIAR EL COD ART AL MODELO
		Notas laNota=servicioNotas.getNota(codigoNota);
		
		//COLOCAR ATRIBUTO CORRESPONDIENTE AL COD ART
		request.setAttribute("NotaActualizar", laNota);
		
		//ENVIAR PRODUCTO AL FORMULARIO DE ACTUALIZAR (JSP)
		RequestDispatcher dispatcher=request.getRequestDispatcher("/comparaNotas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void agregarNotas(HttpServletRequest request, HttpServletResponse response) {
		//LEER LA INFORMACIÓN DEL PRODUCTO QUE VIENE DEL FORMULARIO
		int IdNota = Integer.parseInt(request.getParameter("idNota"));
		int IdAlumno = Integer.parseInt(request.getParameter("idAlumno"));
		String Registro = request.getParameter("registro");
		double Nota = Double.parseDouble(request.getParameter("nota"));
		
		//CREAR UN OBJETO DE TIPO PRODUCTO
		Notas NuevaNota = new Notas(IdNota, IdAlumno, Registro, Nota);
		
		//ENVIAR EL OBJETO AL MODELO E INSERTAR EL PRODUCTO EN LA BD
		servicioNotas.agregarLaNuevaNota(NuevaNota);
		
		//VOLVER AL LISTADO DE PRODUCTOS
		obtenerNotas(request,response);
	}
	private void obtenerNotas(HttpServletRequest request, HttpServletResponse response) {
        List<Notas> notas;
        try {
            notas = servicioNotas.getNotas();
            request.setAttribute("LISTANOTAS", notas);
            RequestDispatcher miDispatcher = request.getRequestDispatcher("ListaNotas.jsp");
            miDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
