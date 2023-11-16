package net.mem;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemMainTest {

	public static void main(String[] args) {
		// MyBatis Framework 기반 JDBC 연습
		
		try {
			
			//factory 공장
			//->어떤 특정 정보를 주면 객체로 생성해 줌
			//->객체 생성: new연산자(POJO방식), Bean
			
			//1) DB연결 환경 설정 파일 가져오기
			String resource="config/jdbc.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			
			//2) DB연결하기 위한 팩토리빈(factory bean) 생성
			//DBOpen + DAO
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			System.out.println("------DB 연결 성공");
			
			//3) 쿼리문 생성 및 변환
			//	->PreparedStatement와 비슷한 기능
			SqlSession sql = ssf.openSession(true); //autocommit 처리
			////////////////////////////////////////////////////////////
			
			//4)쿼리문 실행
			
			//행추가
			//int result = sql.insert("mem.insertRow", new MemDTO("김소영", 30));
			//System.out.println("행추가 결과: " + result);
			
			//행수정
			// ->num=7행의 이름과 나이를 수정하기
			//int result = sql.update("mem.updateRow", new MemDTO(7, "바보", 50));
			//System.out.println("행수정 결과 : " + result);
			
			//행삭제
			// ->나이가 40이상 행 삭제
			/*
			 int result = sql.delete("mem.deleteRow", 40); System.out.println("행삭제 결과 : " + result);
			 */

			
			//전체목록
			/*
			 * List<MemDTO> list = sql.selectList("mem.selectAll");
			   for(int i=0; i<list.size(); i++) { MemDTO dto = list.get(i);
			   System.out.println(dto.getNum() + " "); 
			   System.out.println(dto.getName() + " ");
			   System.out.println(dto.getAge() + " ");
			   System.out.println(); }//for end
			 */			
			
			//검색
			//->이름에 '아' 글자있는 행을 조회
			/*
			  List<MemDTO> list = sql.selectList("mem.search", "아");
			   for(int i=0; i<list.size(); i++) {
			    MemDTO dto = list.get(i);
			   System.out.println(dto.getNum() + " ");
			   System.out.println(dto.getName() + " ");
			   System.out.println(dto.getAge() + " ");
			   System.out.println();
			    }
			 */
			
			//상세보기
			//->num=3 행 상세보기
			MemDTO dto = sql.selectOne("mem.selectRead", 3);	
		    System.out.println(dto.getNum() + " ");
		    System.out.println(dto.getName() +" ");
		    System.out.println(dto.getAge() + " ");
		    System.out.println(); 
			
		}catch(Exception e) {
			System.out.println("실패:" + e);
		}//end
	}//main() end
}//class end
