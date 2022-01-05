package keep_distance_back.com;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class KeepDistanceBackApplicationTests {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testSqlSession() throws Exception
	{
		System.out.println("------ Sql 연결 테스트 ------");
		System.out.println(sqlSession.toString());
		System.out.println("--------------------------");
	}
}
