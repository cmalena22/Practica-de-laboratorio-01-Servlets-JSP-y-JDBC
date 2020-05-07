package ec.edu.ups.modelo;

import ec.ups.edu.base.JDBCPersonaDAO;
import ec.ups.edu.base.JDBCTelefonoDAO;
import ec.ups.edu.controlador.DAOFactory;
import ec.ups.edu.controlador.PersonaDAO;
import ec.ups.edu.controlador.TelefonoDAO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaDAO dao1 = DAOFactory.getFactory().getPersonaDAO();
		JDBCTelefonoDAO dao = new 	JDBCTelefonoDAO();
		//JDBCTelefonoDAO p= new JDBCPersonaDAO();
		Usuario s= new Usuario();
		s.setCedula("0502757910");
		s.setNombre("sara");
		s.setApellido("cc");
		s.setCorreo("sara@gmail.com");
		s.setContrasenia("123");
		Usuario s2= new Usuario();
		///dao1.create(s);
		//dao1.find();
		
		//p.validar(s);
		//per.update(s);
		
		//TelefonoDAO tel= new JDBCTelefonoDAO();
		Telefono t =new Telefono();
		
		t.setNumero("032352042");
		t.setOperadora("telconel");
		t.setTipo("linea");
		t.setUsuario_cedula(s.getCedula());
		   
	    //dao.create(t);
	     System.out.println("cxxc"+dao.find());
	     //System.out.println("por id de usr"+dao.listarporId("1725634110"));
	    System.out.println("jkhdbdjbhjhbdhbjf"+ dao.findbyUserId("0502157910"));

		    /* tel.update(t);
		 
		    tel.read2(1);*/
	}

}
