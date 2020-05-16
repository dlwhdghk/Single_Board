package hwa.jong.lee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;




public class Test {
	private static String clientID="WWJKK8nYSknY1spU7Rnj";
	private static String clientSecret="lBAgYKP7GS";
    public static void main(String[] args) throws Exception{
        //java코드로 특정 url에 요청보내고 응답받기
        //기본 자바 API를 활용한 방법
    	
        URL url = new URL("https://openapi.naver.com/v1/search/movie.json?query="
        		+URLEncoder.encode("헤리포터","UTF-8") + "&display= 10 &start=1");	//API 기본정보의 요청 url을 복사해오고 필수인 query를 적어줍니당! 
        
        URLConnection urlConn=url.openConnection(); //openConnection 해당 요청에 대해서 쓸 수 있는 connection 객체 
        
        urlConn.setRequestProperty("X-Naver-Client-ID", clientID);
        urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        
        BufferedReader br = null;
        
        br = new BufferedReader(new InputStreamReader(urlConn.getInputStream() , "UTF-8"));
        
		 //네이버 api는 이거 넣어 주기
      String line;
      String result = "";
      while ((line = br.readLine()) != null) {
         result = result + line ;
      }
      System.out.println(result);
        
//        String msg = null;
//        while((msg = br.readLine())!=null)
//        {
//            System.out.println(msg);
//        }
    }
}
