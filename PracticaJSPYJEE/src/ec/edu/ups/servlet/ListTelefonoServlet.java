package ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.modelo.Telefono;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.TelefonoDAO;

/**
 * Servlet implementation class ListTelefonoServlet
 */
@WebServlet("/ListTelefonoServlet")
public class ListTelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTelefonoServlet() {
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
		case "Modificar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ModificarTelefono.jsp");  
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
		
				
				String cedula=request.getParameter("cedula");
				List<Telefono>lista=dao.findbyUserId(cedula);		
				request.setAttribute("telefono", lista);
				request.getRequestDispatcher("/JSPs/ListarTelefono.jsp?accion=Listar").forward(request, response);
		
				
			
			/*case "Ingresar":    
			String cedula1=request.getParameter("cedula");
				String numero=request.getParameter("numero");
				String tipo=request.getParameter("tipo");
				String operadora=request.getParameter("operadora");
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setOperadora(operadora);
				telefono.setUsuario_cedula(cedula1);
				String modi=telefono.getNumero();
				System.out.println("cedula:"+cedula1);
				System.out.println("numero:"+numero);
				System.out.println("tipo:"+tipo);
				System.out.println("operadora:"+operadora);
				dao.create(telefono);
					request.setAttribute("telefono", modi);
					request.getRequestDispatcher("/PracticaJSPYJEE/JSPs/RegistraTelefono.jsp").forward(request, response);
		
			
				break;
			case "Modificar":    
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
					request.getRequestDispatcher("/PracticaJSPYJEE/JSPs/ModificarTelefono.jsp").forward(request, response);
		
			
				break;
			case "Eliminar":    
				int id=Integer.valueOf(request.getParameter("id"));
				telefono.setCodigo(id);			
				dao.delete(telefono);			
					//request.setAttribute("telefono", lista);
					request.getRequestDispatcher("/PracticaJSPYJEE/JSPs/EliminarTelefono.jsp").forward(request, response);
			break;

			default:
				break;*/
			}
	

}
