package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.List;

public interface ModelRepo <T>{
	public T findById(Long id) ;
	public List<T> findAll();
	public void deleteById(long id) ;
	public void deleteAll() ;
	public T save(T t) ;
	public void delete(T t);
}
