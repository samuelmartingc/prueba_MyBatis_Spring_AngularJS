package sam.pruebaautentia.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import sam.pruebaautentia.model.Curso;

@Component
public class CursoDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public CursoDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	

	/**
	 * Returns the list of all Curso instances from the database.
	 * @return the list of all Curso instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Curso> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Curso> list = session.selectList("Curso.getAll");
			return list;
		} finally {
			session.close();
		}
	}
        
        public List<Curso> selectAllActivos(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Curso> list = session.selectList("Curso.getAllActivos");
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Returns a Curso instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Curso instance with a primary key value equals to pk. null if there is no matching row.
	 */
	public Curso selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Curso curso = (Curso) session.selectOne("Curso.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Curso in the database.
	 * @param curso the instance to be updated.
	 */
	public void update(Curso curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Cursot.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Curso into the database.
	 * @param curso the instance to be persisted.
	 */
	public void insert(Curso curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Curso.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Curso from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Curso.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
}
