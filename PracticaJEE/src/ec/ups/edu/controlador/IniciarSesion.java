package ec.ups.edu.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		String nombre="";
		String contra="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Inicio Sesion</title></head><body>");		
		nombre=request.getParameter("nombre");
		out.println("<h1> Nombre:"+ nombre+ "</h1>");		
		contra=request.getParameter("contra");
		out.println("<h1> Contraseña:"+ contra+ "</h1>");		
		if (nombre!=null && contra!=null) {	
			if ("admin".equals(nombre) &&"admin".equals(contra) ) {
				out.println("<h1> Bienvenido:"+ nombre+ "</h1>");
				//para pasar de un servlet a otro servlet
				//response.sendRedirect(request.getContextPath()+"/Calculadora");
			}else{
				out.println("<h1>Chao inicia sesion de nuevo</h1>");
			
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
