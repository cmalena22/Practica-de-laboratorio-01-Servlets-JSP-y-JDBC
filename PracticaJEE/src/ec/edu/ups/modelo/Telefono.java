package ec.edu.ups.modelo;

import java.io.Serializable;

public class Telefono implements Serializable  {
	private static final long serialVersionUID = 1L;
	public int codigo;
	public String nombre;
	public String tipo ;
	public String operadora;
	public Usuario usuario;
	public Telefono() {
		
	}		
	public Telefono(int codigo, String nombre, String tipo, String operadora) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario=" + usuario + "]";
	}
	
	
}
