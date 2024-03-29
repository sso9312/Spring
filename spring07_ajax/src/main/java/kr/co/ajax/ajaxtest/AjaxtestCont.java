package kr.co.ajax.ajaxtest;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AjaxtestCont {
	
	public AjaxtestCont() {
		System.out.println("-----AjaxtestCont()객체 생성됨");
	}//end
	
	//결과확인 http://localhost:9095/ajaxtest1.do
	@GetMapping("ajaxtest1.do")
	public String ajaxTest1() {
		return "ajax/ajaxTest1";
	}//ajaxtest1() end
	
	//결과확인 http://localhost:9095/ajaxtest2.do
		@GetMapping("ajaxtest2.do")
		public String ajaxTest2() {
			return "ajax/ajaxTest2";
		}//ajaxtest2() end
		
	@GetMapping("message.do")
	private void message(HttpServletResponse resp) {
		try {
			//단순 문자열 응답(AJAX)
			resp.setContentType("text/plain; charset=UTF-8");
			
			//요청한 사용자에게 응답하기 위한 출력 객체
			PrintWriter out=resp.getWriter();
			out.println("서버에서 응답해준 메세지 : ");
			out.println("무궁화 꽃이 피었습니다~");
			out.flush();//out객체에 남아 있는 버퍼의 내용을 클리어
			out.close();
		}catch(Exception e) {
			System.out.println("응답실패:"+e);
		}//end

	}//message() end
	
	//2)@ResponseBody를 활용한 메세지 전송
	//->SP View를 이용하여 출력하지 않고, response객체에 직접 출력한다
	//->return값 그래로 브라우저에 전송
	@GetMapping("message2.do")
	@ResponseBody
	public String message2() {
		return "서버에서 응답해준 메시지 : 바람과 함께 사라지다~";
	}//message2() end

}//class end
