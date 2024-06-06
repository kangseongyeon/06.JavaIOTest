package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];

		
		// 스트림 클래스를 이용한 방법
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		

		int readBytes = 0;	// 읽은 바이트 수

		// read 데이터를 4개씩 읽었기 때문에 while문을 3번만 읽으면 됨
		while((readBytes = bais.read(temp)) != -1) {
			System.out.println("temp => " + Arrays.toString(temp));
			baos.write(temp, 0, readBytes);
		}
		outSrc = baos.toByteArray();
		
		System.out.println("스트림 클래스 이용하여 복사 후 outSrc => " + Arrays.toString(outSrc));
	}
}
