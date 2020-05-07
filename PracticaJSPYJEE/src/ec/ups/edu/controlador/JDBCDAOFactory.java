package ec.ups.edu.controlador;

import ec.ups.edu.base.JDBCPersonaDAO;
import ec.ups.edu.base.JDBCTelefonoDAO;

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return new JDBCPersonaDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}

}
