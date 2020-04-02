package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract class AbstractRepo<T> implements ModelRepo<T> {

	@Autowired
	EntityManager em;
	
	T t;
	private static final Logger logger = LoggerFactory.getLogger(AbstractRepo.class);
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		if(Objects.isNull(id)) {
			logger.error("id->{} is null. Use correct input", id);
			return null;
		}
		return (T) em.find(t.getClass(), id);
	}

	@Override
	public List<T> findAll() {
		@SuppressWarnings("unchecked")
		List<T> resultList = (List<T>) em.createNamedQuery("findAll"+t.getClass().getSimpleName()+"s", t.getClass()).getResultList();
		if(resultList.size()==0) {
			logger.warn("No Object could be found");
		}
		return resultList;
	}

	@Override
	public void deleteById(long id) {
		if(Objects.isNull(id)) {
			logger.error("id->{} is null. Use correct input", id);
			return ;
		}
		T t = findById(id);
		if(Objects.nonNull(t)) {
			em.remove(t);
		}else {
			logger.error("Delete for object with id={} failed. No object found with id={}", id);
		}
		
	}

	

	@Override
	public void deleteAll() {
		em.createNamedQuery("deleteAll"+t.getClass().getSimpleName()+"s").executeUpdate();
		
	}

	@Override
	public T save(T t) {
		return  em.merge(t);
	}

	protected AbstractRepo(){
		
	}
}
