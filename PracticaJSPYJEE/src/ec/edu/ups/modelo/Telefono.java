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
