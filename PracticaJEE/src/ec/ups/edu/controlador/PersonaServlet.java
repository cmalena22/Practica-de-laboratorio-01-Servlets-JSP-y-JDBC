package ec.ups.edu.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.base.JDBCPersonaDAO;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	PersonaDAO dao = DAOFactory.getFactory().getPersonaDAO();
		
	Usuario p=new Usuario();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		

			
				switch (accion) {
				case "Listar":    
					
					List<Usuario>lista=dao.find();
					
						request.setAttribute("listar", lista);
						request.getRequestDispatcher("/JSPs/UsuarioListar.jsp").forward(request, response);
			
				
					break;

				default:
					break;
				}
			
			
	
		
	}

}
