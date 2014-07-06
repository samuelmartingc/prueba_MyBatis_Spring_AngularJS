package sam.pruebaautentia.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import sam.pruebaautentia.model.Profesor;
@Component
public class ProfesorDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public ProfesorDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	

	/**
	 * Returns the list of all Profesor instances from the database.
	 * @return the list of all Profesor instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Profesor> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Profesor> list = session.selectList("Profesor.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Returns a Profesor instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Profesor instance with a primary key value equals to pk. null if there is no matching row.
	 */
	public Profesor selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Profesor curso = (Profesor) session.selectOne("Profesor.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Profesor in the database.
	 * @param curso the instance to be updated.
	 */
	public void update(Profesor curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Profesort.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Profesor into the database.
	 * @param curso the instance to be persisted.
	 */
	public void insert(Profesor curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Profesor.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Profesor from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Profesor.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
}
