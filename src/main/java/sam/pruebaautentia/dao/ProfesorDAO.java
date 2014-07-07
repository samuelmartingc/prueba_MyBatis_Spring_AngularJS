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

	public Profesor selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Profesor curso = (Profesor) session.selectOne("Profesor.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}


	public void update(Profesor curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Profesort.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void insert(Profesor curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Profesor.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}


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
