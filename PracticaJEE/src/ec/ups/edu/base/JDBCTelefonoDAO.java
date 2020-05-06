package ec.ups.edu.base;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		+ ", '"	+telefono.getOperadora()+ "', "
		+telefono.getUsuario().getCedula() + ")");
		System.out.println(telefono.toString());
	}

	
	

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("UPDATE Telefono SET  nombre = '" + telefono.getNumero() + "',tipo = '"
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefono read(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefono read2(Integer id) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rstelefono = conexionUno.query("SELECT * FROM Telefono WHERE id=" + id);
		try {
			if (rstelefono != null && rstelefono.next()) {
				telefono = new Telefono(rstelefono.getInt("id"), rstelefono.getString("nombre"),
						rstelefono.getString("tipo"),rstelefono.getString("operadora"));
				ResultSet rsusuario = conexionDos.query("SELECT * FROM Usuario WHERE cedula=" + rstelefono.getString("Usuario_cedula"));

				if (rsusuario != null && rsusuario.next()) {
					Usuario usuario = new Usuario(rsusuario.getString("cedula"),rsusuario.getString("nombre"),rsusuario.getString("apellido"), rsusuario.getString("correo"), rsusuario.getString("contrasena"));
					telefono.setUsuario(usuario);
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
	public Telefono findbyUserId(String cedula) {
		Telefono telefono = null;
		ResultSet rsTelefono = conexionUno.query("SELECT * FROM Telefono WHERE Usuario_cedula=" + cedula);
		try {
			if (rsTelefono != null && rsTelefono.next()) {
				telefono = new Telefono(rsTelefono.getInt("id"), rsTelefono.getString("nombre"), rsTelefono.getString("tipo"), rsTelefono.getString("operadora"));

				ResultSet rsUser = conexionDos.query("SELECT * FROM Usuario WHERE cedula=" + rsTelefono.getString("Usuario_cedula"));
				if (rsUser != null && rsUser.next()) {
					Usuario user = new Usuario(rsUser.getString("cedula"), rsUser.getString("nombre"), rsUser.getString("apellido"),
							rsUser.getString("correo"),rsUser.getString("contrasena"));
					telefono.setUsuario(user);
				}
System.out.println("Recuperado cliente"+telefono.toString());
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDetailDAO:findByUserId): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;
	}
	


}
