package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.base.JDBCPersonaDAO;

/**
 * Servlet implementation class IniciarSesionServlet
 */
@WebServlet("/IniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCPersonaDAO dao= new JDBCPersonaDAO();
	Usuario  p= new Usuario();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionServlet() {
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
		HttpSession session=request.getSession(true);
		String accion=request.getParameter("accion");
		
			String user=request.getParameter("nombre");
			String contra=request.getParameter("contra");
			p=dao.validar(user, contra);
			String cedula=p.getCedula();
			String visualizar=p.getNombre();
			if (p.getCorreo()!=null) {
				request.getSession().setAttribute("nombre", cedula);
				request.getSession().setAttribute("usuario",user);
				response.sendRedirect(request.getContextPath()+"/JSPs/Telefono.jsp?nombre="+cedula);
			
			}else
			{
				response.sendRedirect(request.getContextPath()+"/html/index.html");
			
			
			
		}
	}

}
