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


	public Temario selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Temario curso = (Temario) session.selectOne("Temario.getById",id);
			return curso;
		} finally {
			session.close();
		}
	}


	public void update(Temario curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Temario.update", curso);
			session.commit();
		} finally {
			session.close();
		}
	}


	public void insert(Temario curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Temario.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}


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
