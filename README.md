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

Paquete de Bases de datos

ContextJDBC.java

package ec.ups.edu.base;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/guia";
		private static final String USER = "root";
		private static final String PASS = "admin";
		private static ContextJDBC jdbc1 = null;
		private static ContextJDBC jdbc2 = null;
		private Statement statement = null;

		public ContextJDBC() {
			this.connect();
		}

		/**
		 * Método connect.
		 * 
		 * Realiza una conexión a la base de datos a través de jdbc
		 */
		public void connect() {
			try {
				Class.forName(DRIVER);
				Connection connection = DriverManager.getConnection(URL, USER, PASS);
				this.statement = connection.createStatement();
				
				System.out.println("Conexion Exitosa");
			} catch (ClassNotFoundException e) {
				System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver\n" + e.getMessage());
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD\n" + e.getMessage());
			}
		}

		/**
		 * Método query.
		 * 
		 * Realiza una sentencia SELECT a la base de datos.
		 */
		public ResultSet query(String sql) {
			try {
				return this.statement.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBC mala sentencia:query): ---" + sql + "---" + e);
			}
			return null;
		}

		/**
		 * Método update.
		 * 
		 * Realiza una sentencia INSERT, UDPDATE, DELETE, CREATE, entre otras a la base
		 * de datos.
		 */
		public boolean update(String sql) {
			try {
				this.statement.executeUpdate(sql);
				return true;
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBC:update)... actualizacion: ---" + sql + "---" + e);
				return false;
			}
		}

		/**
		 * Método getJDBC.
		 * 
		 * Obtiene una conexión activa a la base de datos
		 * 
		 * @return jdbc
		 */
		protected static ContextJDBC getJDBC1() {
			// creación de la conexión a la base de datos solo si no ha sido creada patrón
			// de diseño singleton
			if (jdbc1 == null) {
				jdbc1 = new ContextJDBC();
			}
			return jdbc1;

		}

		/**
		 * Método getJDBC.
		 * 
		 * Obtiene una conexión activa a la base de datos
		 * 
		 * @return jdbc
		 */
		protected static ContextJDBC getJDBC2() {
			// creación de la conexión a la base de datos solo si no ha sido creada patrón
			// de diseño singleton
			if (jdbc2 == null) {
				jdbc2 = new ContextJDBC();
			}
			return jdbc2;

		}
	
	
	
}


JDBCGenericDao.java

package ec.ups.edu.base;

import ec.ups.edu.controlador.GenericDAO;

public abstract class JDBCGenericDAO <T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();
}

JDBCPersonaDao.java
package ec.ups.edu.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.PersonaDAO;

public class JDBCPersonaDAO extends JDBCGenericDAO<Usuario, Integer> implements PersonaDAO {
	
	@Override
	public void createTable() {
	
	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		conexionUno.update("INSERT Usuario VALUES (" +" '" + usuario.getCedula() + "'" +", '" + usuario.getNombre() + "', '" + usuario.getApellido()
		+ "', '" + usuario.getCorreo() +  "', '" + usuario.getContrasenia() + "')");
	

	}

	@Override
	public Usuario read(String id) {
		Usuario user = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario ");
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		
		return user;
	}

	@Override
	public void update(Usuario usuario) {
		conexionUno.update("UPDATE Usuario SET nombre = '" + usuario.getNombre() + "',apellido = '" + usuario.getApellido()+"'"
	+ " WHERE cedula = " + usuario.getCedula());
		
		System.out.println(usuario.toString());
		
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexionUno.query("SELECT * FROM usuario");
		try {
			while (rs.next()) {
			
			Usuario usuario = new Usuario(rs.getString("cedula"), rs.getString("nombre")
					,rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"));
				
				System.out.println(usuario.toString());
				list.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	@Override
	public Usuario validar(String correo,String contra) {
		Usuario user= new Usuario();
		
		ResultSet rs = conexionUno.query("SELECT * FROM usuario where correo='"+correo+"'and contrasena='"+contra+"'");
		try {
			while (rs.next()) {
				user.setCorreo(rs.getString("correo"));
				user.setContrasenia(rs.getString("contrasena"));
				user.setCedula(rs.getString("cedula"));
				user.setNombre(rs.getString("nombre"));
				user.setNombre(rs.getString("apellido"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	
	}
	@Override
	public Usuario recuperar(String id) {
		Usuario user = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario where cedula='"+ id+"'" );
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		
		return user;
	}

	
	
	
	
	
}

JDBCTelefonoDao.java
package ec.ups.edu.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sound.midi.Soundbank;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.controlador.TelefonoDAO;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Telefono telefono) {
		conexionDos.update("INSERT Telefono VALUES (" + telefono.getCodigo() 
		+ ", '" + telefono.getNumero()+ " '" 
		+ ", '" +telefono.getTipo()+ "' "
		+ ", '"	+telefono.getOperadora()+ "' "
		+ ", '"+telefono.getUsuario_cedula().getCedula() + "')");
		System.out.println(telefono.toString());
		

	}

	
	

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("UPDATE Telefono SET  numero = '" + telefono.getNumero() + "',tipo = '"
														    	+telefono.getTipo() +"',operadora='"	
														    	+telefono.getOperadora()
														+ "' WHERE id = " + telefono.getCodigo());
		System.out.println("update telefono"+telefono.toString());
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("DELETE FROM Telefono WHERE numero = " + telefono.getNumero());
		System.out.println("eliminado telefono:");
	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rstelefono = conexionUno.query("SELECT * FROM telefono");
		try {
			while (rstelefono.next()) {
				Telefono tel = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					tel.setUsuario_cedula(usu);
				}
				list.add(tel);
				System.out.println(list.toString());
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Telefono read(String id) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rstelefono = conexionUno.query("SELECT * FROM Telefono WHERE Usuario_cedula=" + id);
		try {
			if (rstelefono != null && rstelefono.next()) {
				telefono = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsusuario = conexionDos.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsusuario != null && rsusuario.next()) {
					Usuario usuario = new Usuario(rsusuario.getString("cedula"),rsusuario.getString("numero"),rsusuario.getString("apellido"), rsusuario.getString("correo"), rsusuario.getString("contrasena"));
					telefono.setUsuario_cedula(usuario);
				}
				System.out.println(telefono.toString());

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;
	}

	


	@Override
	public List<Telefono>  findbyUserId(String cedula) {
		List<Telefono> list = new ArrayList<Telefono>();;
		ResultSet rstelefono = conexionUno.query("SELECT * FROM Telefono WHERE Usuario_cedula=" + cedula);
		try {
			while (rstelefono.next()) {
				Telefono tel = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					tel.setUsuario_cedula(usu);
				}
				list.add(tel);
				System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDetailDAO:findByUserId): " + e.getMessage());
		}
		return list;
	
	}
	
		
}
Paquete vista

package ec.ups.edu.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sound.midi.Soundbank;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.controlador.TelefonoDAO;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Telefono telefono) {
		conexionDos.update("INSERT Telefono VALUES (" + telefono.getCodigo() 
		+ ", '" + telefono.getNumero()+ " '" 
		+ ", '" +telefono.getTipo()+ "' "
		+ ", '"	+telefono.getOperadora()+ "' "
		+ ", '"+telefono.getUsuario_cedula().getCedula() + "')");
		System.out.println(telefono.toString());
		

	}

	
	

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("UPDATE Telefono SET  numero = '" + telefono.getNumero() + "',tipo = '"
														    	+telefono.getTipo() +"',operadora='"	
														    	+telefono.getOperadora()
														+ "' WHERE id = " + telefono.getCodigo());
		System.out.println("update telefono"+telefono.toString());
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("DELETE FROM Telefono WHERE numero = " + telefono.getNumero());
		System.out.println("eliminado telefono:");
	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rstelefono = conexionUno.query("SELECT * FROM telefono");
		try {
			while (rstelefono.next()) {
				Telefono tel = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					tel.setUsuario_cedula(usu);
				}
				list.add(tel);
				System.out.println(list.toString());
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Telefono read(String id) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rstelefono = conexionUno.query("SELECT * FROM Telefono WHERE Usuario_cedula=" + id);
		try {
			if (rstelefono != null && rstelefono.next()) {
				telefono = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsusuario = conexionDos.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsusuario != null && rsusuario.next()) {
					Usuario usuario = new Usuario(rsusuario.getString("cedula"),rsusuario.getString("numero"),rsusuario.getString("apellido"), rsusuario.getString("correo"), rsusuario.getString("contrasena"));
					telefono.setUsuario_cedula(usuario);
				}
				System.out.println(telefono.toString());

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;
	}

	


	@Override
	public List<Telefono>  findbyUserId(String cedula) {
		List<Telefono> list = new ArrayList<Telefono>();;
		ResultSet rstelefono = conexionUno.query("SELECT * FROM Telefono WHERE Usuario_cedula=" + cedula);
		try {
			while (rstelefono.next()) {
				Telefono tel = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					tel.setUsuario_cedula(usu);
				}
				list.add(tel);
				System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDetailDAO:findByUserId): " + e.getMessage());
		}
		return list;
	
	}
	
		
}

Paquete de JSPS	
Eliminar Telefono
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Telefono</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../css/Validar Formularios.js" ></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Bienvenido</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/PracticaJSPYJEE/EliminarTelefonoSErvlet?accion=Listar">Listar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/EliminarTelefonoSErvlet?accion=Modificar">Modificar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/EliminarTelefonoSErvlet?accion=Registrar">Registrar
						Telefono</a></li>
			</ul>
			<div class="dropdown">
				<button style="border: none;"
					class="btn btn-outline-dark dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">${usuario}</button>

				<div class="dropdown-menu text-center"
					aria-labelledby="dropdownMenuButton">
					<img alt="" src="../imagenes/login.png" height="100" width="100"
						align="center"> <a class="dropdown-item" href="#">${name}</a>
					<a class="dropdown-item" href="#">${apellido}</a> <a
						class="dropdown-item" href="#">${usuario}</a> <a
						class="dropdown-item" href="#">${nombre}</a>
					<div class="dropdown-divider"></div>
					<form action="/PracticaJSPYJEE/CerrarSesionServlet" method="get">

						<input type="submit" id="crear" value="Salir" name="accion" />
					</form>
				</div>
			</div>
	</nav>
	<br>
	<div class="container col-lg-3">
	<h1>Formulario</h1>
	<form id="formulario01" method="POST"
		action="/PracticaJSPYJEE/EliminarTelefonoSErvlet">
		
		<input type="hidden" id="codigo" name="codigo" value="" /> <label
			for="numero">Numero:(*)</label> <input type="text" id="id" name="id"
			placeholder="Ingrese el numero" class="form-control" onkeypress="return validarNumeroo(event, this)" required="required"/> <br> 
			<input type="submit" id="eliminar" name="accion" value="Eliminar" class="btn btn-default" />
			
	</form>
	</div>
</body>
</html>
Listar Telefono
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Telefono</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bienvenido</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/PracticaJSPYJEE/ListTelefonoServlet?accion=Registrar" >Insertar Telefono</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/PracticaJSPYJEE/ListTelefonoServlet?accion=Modificar">Modificar Telefono</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/PracticaJSPYJEE/ListTelefonoServlet?accion=Eliminar">Eliminar Telefono</a>
      </li>     
    </ul>
     <div class="dropdown">
  <button style="border: none;" class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   ${usuario}
  </button>
  
  <div class="dropdown-menu text-center"  aria-labelledby="dropdownMenuButton" >
  <img alt="" src="../imagenes/login.png" height="100" width="100" align="center">
  <a class="dropdown-item" href="#">${name}</a>
      <a class="dropdown-item" href="#">${apellido}</a>
    <a class="dropdown-item" href="#">${usuario}</a>
    <a class="dropdown-item" href="#">${nombre}</a>
<div class="dropdown-divider"></div>
<form action="/PracticaJSPYJEE/CerrarSesionServlet" method="get">		
		   <input type="submit" id="crear" value="Salir" name="accion"/>
	</form>
  </div>
  </div>
</nav>
<form action="/PracticaJSPYJEE/ListTelefonoServlet"  method="post">
 <input class="btn btn-danger btn block" type="submit" name="accion" value="Listar"> 
 <input id="cedula" name="cedula" type="hidden" value="${nombre}">
 </form>
 	<div >
 		<table class="table table-hover">
 		<thead>
 			<tr>
 			 <th> ID</th>
			    <th> Numero</th>
 				<th> Tipo</th>
				<th> Operadora </th>
					<th> Cedula </th>
				  </tr>
  </thead>  
  <tbody>  
  <c:forEach var="tel" items="${telefono}">  
  <tr>
  <td>${tel.getCodigo()}</td>
  	<td>${tel.getNumero()}</td>
 	<td>${tel.getTipo()}</td>
 	<td>${tel.getOperadora()}</td> 
 	<td>${tel.getUsuario_cedula().getCedula()}</td> 
  </tr>
 
  </c:forEach>
  
  
  </tbody>
 
 
 
 </table>
 
 
 
 
 
 </div>
</body>
</html>
Insertar Telefono
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Telefono</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../css/Validar Formularios.js" ></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Bienvenido</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/PracticaJSPYJEE/InsertarTelefonoServlet?accion=Listar">Listar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/InsertarTelefonoServlet?accion=Modificar">Modificar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/InsertarTelefonoServlet?accion=Eliminar">Eliminar
						Telefono</a></li>

			</ul>
			<div class="dropdown">
				<button style="border: none;"
					class="btn btn-outline-dark dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">${usuario}</button>

				<div class="dropdown-menu text-center"
					aria-labelledby="dropdownMenuButton">
					<img alt="" src="../imagenes/login.png" height="100" width="100"
						align="center"> <a class="dropdown-item" href="#">${name}</a>
					<a class="dropdown-item" href="#">${apellido}</a> <a
						class="dropdown-item" href="#">${usuario}</a> <a
						class="dropdown-item" href="#">${nombre}</a>
					<div class="dropdown-divider"></div>
					<form action="/PracticaJSPYJEE/CerrarSesionServlet" method="get">
						<input type="submit" id="crear" value="Salir" name="accion" />
					</form>
				</div>
			</div>
	</nav>
	<br>
	<div class="container col-lg-3">
	<h1>Formulario</h1>
	<form action="/PracticaJSPYJEE/InsertarTelefonoServlet" method="post"
		role="form">
		<div class="form-group">
		<label for="numero">Numero:</label>
		<input type="text" id="numero"	name="numero" minlength="9" maxlength="10" class="form-control" required="required"  onkeypress="return validarNumeroo(event, this)" /> <br> 
		<label
			for="tipo">Tipo:</label> 
		<input type="text" id="tipo" name="tipo" class="form-control" onkeyup="return validarLetras(this)" required="required" />
		<br> 
		<label for="operadora">Operadora:</label> 
		<input type="text" id="operadora" name="operadora" class="form-control" onkeyup="return validarLetras(this)" required="required"/> <br> 
		<input id="cedula" name="cedula" type="hidden" value="${nombre}"> <input
			type="submit" id="crear" value="Ingresar" name="accion" class="btn btn-default"/>
		
		</div>
		

	</form>
	
	</div>
</body>
</html>
Modificar Telefono
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Telefono</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../css/Validar Formularios.js" ></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Bienvenido</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Listar">Listar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Registrar">Registrar
						Telefono</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Eliminar">Eliminar
						Telefono</a></li>

			</ul>
			<div class="dropdown">
				<button style="border: none;"
					class="btn btn-outline-dark dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">${usuario}</button>

				<div class="dropdown-menu text-center"
					aria-labelledby="dropdownMenuButton">
					<img alt="" src="../imagenes/login.png" height="100" width="100"
						align="center"> <a class="dropdown-item" href="#">${name}</a>
					<a class="dropdown-item" href="#">${apellido}</a> <a
						class="dropdown-item" href="#">${usuario}</a> <a
						class="dropdown-item" href="#">${nombre}</a>
					<div class="dropdown-divider"></div>
					<form action="/PracticaJSPYJEE/CerrarSesionServlet" method="get">

						<input type="submit" id="crear" value="Salir" name="accion" />
					</form>
				</div>
			</div>
	</nav>
	<br>
	<div class="container col-lg-3">
	<form method="POST" action="/PracticaJSPYJEE/ModificarTelefonoServlet"
		role="form">
<h1>Formulario</h1>
		<label for="numero">Id:(*)</label> <input type="text" id="id"
			name="id" placeholder="Ingrese el numero telefono ..."
			class="form-control" onkeypress="return validarNumeroo(event, this)"/>
			 <br> <label for="numero">Numero:(*)</label>
		<input type="text" id="numerom" name="numerom" minlength="9"
			maxlength="10" placeholder="Ingrese el numero telefono ..."
			class="form-control"  onkeypress="return validarNumeroo(event, this)" /> 
			<br> 
			<a>${telefono}</a> <label
			for="tipo">Tipo:(*)</label> <input type="text" id="tipom"
			name="tipom" placeholder="Ingrese tipo de telefono ..."
			class="form-control" required="required" onkeyup="return validarLetras(this)" /> 
			<br> <label for="operadora">Operadora:(*)</label>
		<input type="text" id="operadoram" name="operadoram"
			placeholder="Ingrese la operadora ..." class="form-control" required="required" onkeyup="return validarLetras(this)" /> <br>
		<input type="submit" id="modificar" name="accion" value="Modificar"
			class="btn btn-default" />

	</form>
 </div>
</body>
</html>



