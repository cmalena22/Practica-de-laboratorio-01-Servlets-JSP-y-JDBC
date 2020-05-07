package ec.ups.edu.base;

import ec.ups.edu.controlador.GenericDAO;

public abstract class JDBCGenericDAO <T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();
}
