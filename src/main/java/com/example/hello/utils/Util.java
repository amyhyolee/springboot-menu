package com.example.hello.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {
	// 오늘 날짜를 가져 오는 메소드(yyyyMMdd)
	public static String getCurrentDate(String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(new Date());
	}

	// 파일 읽어오는 메소드
	public static void readLineFile(String filePath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath)); // Desktop에 파일 찾기
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 파일 쓰고 화면에 출력
	public static String readtoConsole(String filePath) {
		BufferedReader br = null;
		String retLine = "";
//		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				retLine += line + "\n"; // 문자열을 리턴
//				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retLine; // sb.toString()
//		return sb.toString(); 
	}

	// 파일 쓰기 (새로운 파일에 쓰기, 덮어쓰기)
	public static void writeLineFile(ArrayList<String> strList, String filePath) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(filePath); // Desktop에 파일
			for (String s : strList) {
				out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	// 파일 쓰기 (이어 쓰기)
	public static void writeLineFile(ArrayList<String> strList, String filePath, boolean isAppend) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(filePath, isAppend));
			for (String s : strList) {
				out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	// 내가 만든 문자열을 잘라서 데이터 전달
	public static void mySplit(String str, String regex1, String regex2) {
		String[] strArr = str.split(regex1);
		for (String s : strArr) {
//			System.out.println(s);
			String[] tmpArr = s.split(regex2);
//			for (String ss : tmpArr) {
//				System.out.println(ss);
//			}
//			System.out.println(tmpArr.length);
			for (int i = 0; i < tmpArr.length; i++) {
				if (i == tmpArr.length - 1) {
					System.out.print(tmpArr[i]);
				} else {
					System.out.print(tmpArr[i] + " / ");
				}
			}
			System.out.println();

		}
	}

}