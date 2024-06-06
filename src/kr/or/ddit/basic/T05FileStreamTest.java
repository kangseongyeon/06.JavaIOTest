package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;


public class T05FileStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		// 읽는 용 : FileInputStream 출력용 : FileOutputStream
		try {
			fis = new FileInputStream("d:/D_Other/test2.txt");
			int data = 0;
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}                      
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();	// 마무리 작업 (file 관련된 것들은 close 처리를 하는 것이 좋음)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
