package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.modelo.Telefono;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.TelefonoDAO;

/**
 * Servlet implementation class ModificarTelefonoServlet
 */
@WebServlet("/ModificarTelefonoServlet")
public class ModificarTelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarTelefonoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		switch (accion) {		
		case "Eliminar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/EliminarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		case "Listar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ListarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		
		case "Registrar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/RegistraTelefono.jsp");  
			 
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		default:
			  break;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		if ("Modificar".equalsIgnoreCase(accion)) {
		int codigo=Integer.valueOf(request.getParameter("id"));
		String numeroeditar=request.getParameter("numerom");
		String tipoeditar=request.getParameter("tipom");
		String operadoraeditar=request.getParameter("operadoram");
		telefono.setCodigo(codigo);
		telefono.setNumero(numeroeditar);
		telefono.setTipo(tipoeditar);
		telefono.setOperadora(operadoraeditar);
		dao.update(telefono);
		System.out.println("cedula:"+codigo);
		System.out.println("numero:"+numeroeditar);
		System.out.println("tipo:"+tipoeditar);
		System.out.println("operadora:"+operadoraeditar);
		
			//request.setAttribute("telefono", lista);
			request.getRequestDispatcher("/JSPs/ModificarTelefono.jsp").forward(request, response);
		}
	}

}
