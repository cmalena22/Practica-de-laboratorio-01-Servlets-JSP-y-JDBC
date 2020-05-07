package ec.ups.edu.controlador;

import java.util.List;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	public abstract List<Telefono> findbyUserId(String cedula);
}
