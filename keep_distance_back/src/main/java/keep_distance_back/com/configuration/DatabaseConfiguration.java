package keep_distance_back.com.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties") // application.properties를 사용할수 있도록 설정.
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	/*
	 * application.properties에 설정했던 데이터베이스 관련 정보를 사용하도록 지정.
	 * @author  장태훈
	 * @version 1.0 / 2022-01-05 최조 작성
	*/
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig()
	{
		return new HikariConfig();
	}

	/*
	 * 히카리를 이용하여 커넥션 테스트 및 dataSource 설정.
	 * @author  장태훈
	 * @version 1.0 / 2022-01-05 최조 작성
	*/
	@Bean
	public DataSource dataSource() throws Exception
	{
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}

	/*
	 * 마이바티스 설정.
	 * @author  장태훈
	 * @version 1.0 / 2022-01-05 최조 작성
	*/	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource); // dataSource()에서 만든 dataSource를 설정.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml")); // 매퍼 파일의 위치를 설정.
		
		return sqlSessionFactoryBean.getObject();
	}
	
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
