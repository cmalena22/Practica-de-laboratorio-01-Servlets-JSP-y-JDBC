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
		+ ", '"	+telefono.getOperadora()+ "','"
		+telefono.getUsuario_cedula() + "')");
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
		conexionDos.update("DELETE FROM Telefono WHERE id = " + telefono.getCodigo());
		System.out.println("eliminado telefono:");
	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rstelefono = conexionUno.query("SELECT * FROM telefono");
		try {
			while (rstelefono.next()) {
				Telefono tel = new Telefono(rstelefono.getInt("id"), rstelefono.getString("numero"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"),rstelefono.getString("usuario_cedula"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					
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
						rstelefono.getString("tipo"),rstelefono.getString("operadora"),rstelefono.getString("usuario_cedula"));
				ResultSet rsusuario = conexionDos.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsusuario != null && rsusuario.next()) {
					Usuario usuario = new Usuario(rsusuario.getString("cedula"),rsusuario.getString("numero"),rsusuario.getString("apellido"), rsusuario.getString("correo"), rsusuario.getString("contrasena"));
					
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
						rstelefono.getString("tipo"),rstelefono.getString("operadora"),rstelefono.getString("usuario_cedula"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usu = new Usuario(rsUsuario.getString("cedula"),rsUsuario.getString("nombre"),rsUsuario.getString("apellido")
							,rsUsuario.getString("correo"),rsUsuario.getString("contrasena"));
					
				}
				list.add(tel);
				System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDetailDAO:findByUserId): " + e.getMessage());
		}
		return list;
	
	}
	
	public Telefono listarporId(String id) {
		Telefono tel= new Telefono();
		
		ResultSet rs = conexionUno.query("SELECT * FROM telefono where Usuario_cedula='"+id+"'");
		try {
			while (rs.next()) {
				tel.setNumero(rs.getString("numero"));
				tel.setTipo(rs.getString("tipo"));
				tel.setOperadora(rs.getString("operadora"));
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tel;
	
	}
	
	public Telefono devolverid(String numero) {
		Telefono tel= new Telefono();
		
		ResultSet rs = conexionUno.query("SELECT id FROM telefono where numero="+numero);
		try {
			while (rs.next()) {
				tel.setCodigo(rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tel;
	
	}
	
	

}
