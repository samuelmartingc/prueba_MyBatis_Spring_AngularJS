package sam.pruebaautentia.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import sam.pruebaautentia.model.Temario;

@Component
public class TemarioDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public TemarioDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	

	/**
	 * Returns the list of all Temario instances from the database.
	 * @return the list of all Temario instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Temario> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Temario> list = session.selectList("Temario.getAll");
			return list;
		} finally {
			session.close();
		}
	}
        
        public List<Temario> selectAllActivos(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Temario> list = session.selectList("Temario.getAllActivos");
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Returns a Temario instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Temario instance with a primary key value equals to pk. null if there is no matching row.
	 */
	public Temario selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Temario curso = (Temario) session.selectOne("Temario.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Temario in the database.
	 * @param curso the instance to be updated.
	 */
	public void update(Temario curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Temario.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Temario into the database.
	 * @param curso the instance to be persisted.
	 */
	public void insert(Temario curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Temario.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Temario from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Temario.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
}
