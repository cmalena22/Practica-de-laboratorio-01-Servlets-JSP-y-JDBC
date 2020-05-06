package ec.ups.edu.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.base.JDBCTelefonoDAO;

/**
 * Servlet implementation class InsertarTelefonoServlet
 */
@WebServlet("/InsertarTelefonoServlet")
public class InsertarTelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarTelefonoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Telefono telefono= new Telefono();
		Usuario s= new Usuario();
		JDBCTelefonoDAO tel=new JDBCTelefonoDAO();
		String url=null;
		try {
			telefono.setNumero(request.getParameter("numero"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
			telefono.setUsuario(s);
			tel.create(telefono);
			response.setContentType("text/html");
			PrintWriter out=  response.getWriter();
			out.println("inserta"+telefono.toString());;
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage()+e.getLocalizedMessage()+e.getCause());

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
