package kr.co.itwill.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentCont {
	
	public CommentCont() {
		System.out.println("------CommentCont()객체생성됨");
	}//end
	
	@Autowired
	private CommentDAO commenDao;
	
	@PostMapping("/insert")
	@ResponseBody
	public int mCommentServiceInsert(@RequestParam int product_code, @RequestParam String content, HttpSession session) {
									//HttpServletRequest req
									//@ModelAttribute CommentDTO commDto
		
		CommentDTO commentDto = new CommentDTO();
		commentDto.setProduct_code(product_code);
		commentDto.setContent(content);
		commentDto.setWname("test");
		//로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 밭아온 값으로 사용하면 된다.
		//->예)session.getAttribute("s_id") 활용
		//->여기서는 따로 폼을 구현하지 않았기 때문에 임시로 "test" 라  한다
		
		int cnt = commenDao.commentInsert(commentDto);
		
		return cnt;    
	
	}//mCommentServiceInsert() end
	
}//calss end
