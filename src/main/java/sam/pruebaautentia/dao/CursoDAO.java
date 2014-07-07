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

	public Curso selectById(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Curso curso = (Curso) session.selectOne("Curso.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}

	public void update(Curso curso){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Cursot.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}


	public void insert(Curso curso){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Curso.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}

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
