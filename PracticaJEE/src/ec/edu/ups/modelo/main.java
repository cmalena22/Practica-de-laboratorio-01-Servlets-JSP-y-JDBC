package ec.edu.ups.modelo;

import ec.ups.edu.base.JDBCPersonaDAO;
import ec.ups.edu.base.JDBCTelefonoDAO;
import ec.ups.edu.controlador.PersonaDAO;
import ec.ups.edu.controlador.TelefonoDAO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaDAO per = new JDBCPersonaDAO();
		Usuario s= new Usuario();
		s.setCedula("1724934110");
		s.setNombre("malena");
		s.setApellido("cajia");
		s.setCorreo("sdk");
		s.setContrasenia("123");
		//per.create(s);
		//per.read("1724934110");
		//per.update(s);
		
		TelefonoDAO tel= new JDBCTelefonoDAO();
		Telefono t =new Telefono();
		t.setCodigo(1);
		t.setNombre("Movi");
		t.setOperadora("claro");
		t.setTipo("linea");
		t.setUsuario(s);
	//	tel.create(t);
		
		     tel.update(t);
		    tel.delete(t);
		    tel.read2(1);
	}

}
