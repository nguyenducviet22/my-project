package dao_db;

import java.util.List;

public interface InterfaceDao<T> {

	public List<T> selectAll();
	
	public T selectById(T t);
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
}
