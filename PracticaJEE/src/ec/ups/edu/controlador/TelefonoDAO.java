package ec.ups.edu.controlador;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	public abstract Telefono findbyUserId(String cedula);
}
