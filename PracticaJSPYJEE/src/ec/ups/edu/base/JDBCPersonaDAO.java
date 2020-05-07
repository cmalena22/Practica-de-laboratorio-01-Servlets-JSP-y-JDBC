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

	
	
	
	int r=0;
	public Usuario validar(String correo,String contra) {
		Usuario user= new Usuario();
		
		ResultSet rs = conexionUno.query("SELECT * FROM usuario where correo='"+correo+"'and contrasena='"+contra+"'");
		try {
			while (rs.next()) {
				user.setCorreo(rs.getString("correo"));
				user.setContrasenia(rs.getString("contrasena"));
				user.setCedula(rs.getString("cedula"));
				user.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	
	}
	
	
	
	
}
