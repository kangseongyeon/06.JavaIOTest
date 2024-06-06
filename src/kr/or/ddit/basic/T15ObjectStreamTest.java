package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체 입출력을 위한 보조스트림 예제
 * 아기 성연이 따끈딱근 신생아 초코먹넹 캬캬캬 기여웡 ㅠ 역시 안유진~ 성연아 키보드 너무 좋다 근데 오타 많이나넹 ㅠ
 * @author 6
 *
 */
public class T15ObjectStreamTest {
	public static void main(String[] args) throws IOException {
		MemberVO mem1 = new MemberVO("홍길동", 20, "대전");
		MemberVO mem2 = new MemberVO("이순신", 30, "부산");
		MemberVO mem3 = new MemberVO("일지매", 40, "대구");
		MemberVO mem4 = new MemberVO("강감찬", 50, "광주");
		
		// 객체 출력을 위한 보조스트림 생성하기
		ObjectOutputStream oos = new ObjectOutputStream(
								 new BufferedOutputStream(
								 new FileOutputStream("d:/D_Other/memObj.bin")));
		
		// 객체 쓰기(저장)
		oos.writeObject(mem1);	// 직렬화
		oos.writeObject(mem2);	// 직렬화
		oos.writeObject(mem3);	// 직렬화
		oos.writeObject(mem4);	// 직렬화
		
		oos.close();
		System.out.println("객체 쓰기 작업 완료...");
		
		///////////////////////////////////////
		
		// 저장된 객체 정보를 읽어와 출력하기
		// FileInputStream fis = new FileInputStream("d:/D_Other/memObj.bin");
		
		// 객체 입력처리를 위한 보조 스트림 생성하기
		ObjectInputStream ois = new ObjectInputStream(
								new BufferedInputStream(
								new FileInputStream("d:/D_Other/memObj.bin")));
		
		Object obj = null;
		
		try {
			// 역직렬화... (readObject를 호출하는 순간)
			while((obj = ois.readObject()) != null) {
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다
				MemberVO mem = (MemberVO) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("---------------------------");
				
			}
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("읽기 작업 끝");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

// Serializable : 직렬화를 시켜 줌
class MemberVO implements Serializable{
	/*
	 * transient => 직렬화가 되지 않을 멤버변수에 지정한다
	 * 				(static 필드도 직렬화가 되지 않는다)
	 * 		직렬화가 되지 않는 멤버변수는 기본값으로 저장된다
	 * 		(참조형 변수 : null, 숫자형 변수 : 0, 논리형 변수 : fasle) 
	 */
	
	private String name;
	transient private int age;
	private String addr;
	
	public MemberVO(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}