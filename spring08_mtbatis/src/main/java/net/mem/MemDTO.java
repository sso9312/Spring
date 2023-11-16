package net.mem;

public class MemDTO {

	private int num;
	private String name;
	private int age;
	
	public MemDTO( ) {}

	public MemDTO(int num) {
		this.num = num;
	}

	public MemDTO(int num, int age) {
		this.num = num;
		this.age = age;
	}
	public MemDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public MemDTO(int num, String name, int age) {
		this.num = num;
		this.name = name;		
		this.age = age;
	}//테스트용으로 넘겨주는 용도


	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}//class end
