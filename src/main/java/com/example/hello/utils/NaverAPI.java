package com.example.hello.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

// import com.google.gson.Gson;
// import com.google.gson.JsonArray;
// import com.google.gson.JsonElement;
// import com.google.gson.JsonObject;
// import com.lhj.util.Util;

// import dto.NaverapiDto;

public class NaverAPI {

	// Class 11

	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	// // json parsing
	// public static ArrayList<NaverapiDto> getParsingData(String responseBody) {
	// 	ArrayList<NaverapiDto> list = new ArrayList<NaverapiDto>();
	// 	Gson gson = new Gson();
	// 	JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
	// 	JsonArray jsonArray = jsonObject.getAsJsonArray("items");

	// 	for (JsonElement em : jsonArray) {
	// 		NaverapiDto dto = gson.fromJson(em, NaverapiDto.class); // set
	// 		list.add(dto);
	// 	}
	// 	return list;
	// }

	// // 제목, 링크 날짜 만 출력하기
	// public static void cleanSearch(int num, String responseBody) {
	// 	ArrayList<NaverapiDto> list = NaverAPI.getParsingData(responseBody);
		
	// 	for (NaverapiDto dto : list) {
	// 		System.out.println();
	// 		System.out.println("Title: " + dto.getTitle());
	// 		System.out.println("Link: " + dto.getLink());
			
	// 		if (num == 1 || num == 3) {
	// 			System.out.println("Publish Date: " + dto.getPubDate());
	// 		} else if (num == 2) {
	// 			System.out.println("Post Date: " + dto.getPostDate());
	// 		} else if (num == 4) {
	// 			System.out.println("Publish Date: " + dto.getPubdate());
	// 		} else {
	// 			System.out.println("오류입니다");
	// 		}
	// 	}
	// }
	
	public static String naverSearch(String str, String str2) {
		String[] code = Util.readtoConsole("/Users/hyojinlee/java-workspace/naver_client.txt").split("\\n");

		String clientId = code[0]; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = code[1]; // 애플리케이션 클라이언트 시크릿값"

		String text = null;
		try {
			text = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/" + str2 + "?query=" + text; // json 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);
		return responseBody;
	}

	public static String searchNews(String str) {
		String[] code = Util.readtoConsole("/Users/hyojinlee/busanAI/eclipse/java-workspace/naver_client.txt").split("\\n");
//		String[] cArr = code.split("\\n");
		
        String clientId = code[0]; //애플리케이션 클라이언트 아이디값"
        String clientSecret = code[1]; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
            text = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        return responseBody;
	}
	
	public String searchEncyc(String str) {
		return naverSearch(str, "encyc");
	}

	public String searchImage(String str) {
		return naverSearch(str, "image");
	}
	

}
