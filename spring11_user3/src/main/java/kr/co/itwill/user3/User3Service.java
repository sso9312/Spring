package kr.co.itwill.user3;

public interface User3Service {
	
	public ResultDTO findAll();
	public ResultDTO editById();
	public ResultDTO delete(int no);
	public ResultDTO save(User3DTO uDto);
}//interface end
