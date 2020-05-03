package ec.ups.edu.controlador;

import java.util.List;



import ec.edu.ups.modelo.Usuario;

public interface GenericDAO<T, ID> {
	public void createTable();

	public void create(T entity);

	public T read(String string);
	public T read2(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();

}
