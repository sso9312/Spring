package kr.co.itwill;

import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class Spring09MyshopApplication {//spring Boot기반 프로젝트 시작클래스

	public static void main(String[] args) {
		SpringApplication.run(Spring09MyshopApplication.class, args);
	}//main() end
	
	//MyBatis Framework관련 환경 설정
	//참조 spring08 mybatis프로젝트 MemMainTest 클래스 참조
	//Mapper 객체 생성
	@Bean //<-스프링 컨테이너가 자동으로 객체 생성
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		System.out.println("----- SqlSessionFactory() 호출됨");
		 SqlSessionFactoryBean been=new  SqlSessionFactoryBean();
		 been.setDataSource(dataSource);
		 Resource[] res=new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml");
		 been.setMapperLocations(res);
		 return been.getObject();   
	}// SqlSessionFactory() end
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		System.out.println("-----sqlSession() 호출됨");
		return new SqlSessionTemplate(factory);
	}//sqlSession() end

}//class end
