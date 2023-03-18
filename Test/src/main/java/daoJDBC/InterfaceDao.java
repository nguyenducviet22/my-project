package daoJDBC;

import java.util.List;

public interface InterfaceDao<T> {
	
	public List<T> selectAll();

	public T selectById(T t);

	public T insert(T t);

	public T update(T t);

	public T delete(T t);
}
