package kr.co.itwill.user3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //<-내부에서 자바 로직을 자리함
public class User3ServiceImp implements User3Service {

	@Autowired
	User3DAOImp uDao;
	
	private ResultDTO rDto;
	
	public User3ServiceImp() {
		System.out.println("-----User3ServiceImp() 객체 생성돰");
	}
	
	@Override
	public ResultDTO findAll() {
		rDto = new ResultDTO();
		List<User3DTO> resultList=uDao.findAll();
		if(resultList != null) {
			rDto.setState(true);
			rDto.setResult(resultList);
		}else {
			rDto.setState(false);
		}//if end
		return rDto;
	}//findAll() end

	@Override
	public ResultDTO editById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDTO delete(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDTO save(User3DTO uDto) {
		rDto = new ResultDTO();
		int state=uDao.save(uDto);
		if(state == 1) {
			rDto.setState(true);
			rDto.setMessage("사용자 생성이 성공 하였습니다");
		}else {
			rDto.setState(false);
			rDto.setMessage("사용자 생성이 실패 하였습니다");
		}//if end
		return rDto;
	}

}
