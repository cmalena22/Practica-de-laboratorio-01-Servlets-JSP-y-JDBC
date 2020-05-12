# Practica-de-laboratorio-01-Servlets-JSP-y-JDBC
En este programa se realiza un ejemplo del uso del patrón DAO para persistencia de información en base de datos.

versiones
Eclipse=2020-03 (4.15.0)
Java=JavaSE-1.8
MySQL=8.0.19
MySQL_Java_Connector=8.0.19




Instalación
Iniciar el servidor MySQL en el puerto 3306
Crear una base de datos llamada db_test
Actualizar los datos de conexión en la clase ec.edu.ups.mysql.jdbc.ContextJDBC
Ejecutar las pruebas que se encuentran en el paquete ec.edu.ups.test

Diagrama de Clases


https://raw.githubusercontent.com/cmalena22/Practica-de-laboratorio-01-Servlets-JSP-y-JDBC/master/assets/diagrama.png


Paquete modelo

Telefono.java
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Set;

public class Telefono implements Serializable  {
	private static final long serialVersionUID = 1L;
	public int codigo;
	public String numero;
	public String tipo ;
	public String operadora;
	public String usuario_cedula;
	public Telefono() {
		
	}		
	
	public Telefono(int codigo, String numero, String tipo, String operadora, String usuario_cedula) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.usuario_cedula = usuario_cedula;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
		
	
	public String getUsuario_cedula() {
		return usuario_cedula;
	}
	public void setUsuario_cedula(String usuario_cedula) {
		this.usuario_cedula = usuario_cedula;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario_cedula=" + usuario_cedula + "]";
	}
	

	
}

Usuario.java
package ec.edu.ups.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public String cedula;
	public String nombre;
	public String apellido;
	public String correo;
	public String contrasenia;
	
	public Usuario() {
		
	}
	
	
	public Usuario(String cedula, String nombre, String apellido, String correo, String contrasenia) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasenia=" + contrasenia + "]";
	}

}


Paquete del Servlet

BuscarCedulaServlet.javapackage ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import ec.edu.ups.modelo.Telefono;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.TelefonoDAO;

/**
 * Servlet implementation class BuscarPorCedulaServlet
 */
@WebServlet("/BuscarPorCedulaServlet")
public class BuscarPorCedulaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPorCedulaServlet() {
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
		case "Iniciar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/html/index.html");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
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
		String dato=request.getParameter("buscar");
		switch (accion) {
		case "Buscar":
			List<Telefono>lista=dao.findbyUserId(dato);
			request.setAttribute("telefono", lista);
			request.getRequestDispatcher("/JSPs/Publicca.jsp").forward(request, response);
			break;
		
		}
	
		
	}

}

EliminarTelefonoServlet.javapackage ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import ec.edu.ups.modelo.Telefono;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.TelefonoDAO;

/**
 * Servlet implementation class BuscarPorCedulaServlet
 */
@WebServlet("/BuscarPorCedulaServlet")
public class BuscarPorCedulaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPorCedulaServlet() {
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
		case "Iniciar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/html/index.html");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
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
		String dato=request.getParameter("buscar");
		switch (accion) {
		case "Buscar":
			List<Telefono>lista=dao.findbyUserId(dato);
			request.setAttribute("telefono", lista);
			request.getRequestDispatcher("/JSPs/Publicca.jsp").forward(request, response);
			break;
		
		}
	
		
	}

}

IniciarSesionServlet.java
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

InsertarTelefonoServlet.java
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
 * Servlet implementation class InsertarTelefonoServlet
 */
@WebServlet("/InsertarTelefonoServlet")
public class InsertarTelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono();
       
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
		String accion=request.getParameter("accion");
		switch (accion) {		
		case "Listar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ListarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		case "Modificar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ModificarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		
		case "Eliminar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/EliminarTelefono.jsp");  
			 
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		default:
			  break;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			request.getRequestDispatcher("/JSPs/RegistraTelefono.jsp").forward(request, response);
	}
		
}
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
 * Servlet implementation class InsertarTelefonoServlet
 */
@WebServlet("/InsertarTelefonoServlet")
public class InsertarTelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
TelefonoDAO dao = DAOFactory.getFactory().getTelefonoDAO();
	
	//JDBCTelefonoDAO tel= new JDBCTelefonoDAO();
	Telefono telefono=new Telefono();
       
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
		String accion=request.getParameter("accion");
		switch (accion) {		
		case "Listar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ListarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		case "Modificar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/ModificarTelefono.jsp");  
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		
		case "Eliminar":
			System.out.println("shdbsdhfbshfbsfh");
			  response.sendRedirect("/PracticaJSPYJEE/JSPs/EliminarTelefono.jsp");  
			 
			//request.getRequestDispatcher("../html/index.html").forward(request, response);
			  break;
		default:
			  break;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			request.getRequestDispatcher("/JSPs/RegistraTelefono.jsp").forward(request, response);
	}
		
}

ListTelefonoServlet.java

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


ModificarTelefonoServlet.java
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

