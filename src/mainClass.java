import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.util.Map;

import javax.swing.ImageIcon;

import static java.nio.file.StandardCopyOption.*;

import java.util.ArrayList;
import java.util.Calendar;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class mainClass {

	public static void main(String[] args) throws IOException {
		
		String[][] seasonArray = new String[4][4];
		
//		seasonArray[0][0] = "Winter.jpg";
//		seasonArray[0][1] = "winter";
//		seasonArray[1][0] = "Spring.jpg";
//		seasonArray[1][1] = "spring";
//		seasonArray[2][0] = "Summer.jpg";
//		seasonArray[2][1] = "summer";
//		seasonArray[3][0] = "Autumn.jpg";
//		seasonArray[3][1] = "autumn";
		
		Advert winterAd = new Advert("winter", "Winter.jpg");
		Advert springAd = new Advert("spring", "Spring.jpg");
		Advert summerAd = new Advert("summer", "Summer.jpg");
		Advert autumnAd = new Advert("autumn", "Autumn.jpg");
		
		ArrayList<Advert> advertArray = new ArrayList<Advert>();
		advertArray.add(summerAd);
		advertArray.add(winterAd);
		advertArray.add(springAd);
		advertArray.add(autumnAd);
		
		
		Calendar date = Calendar.getInstance();
		int month = (date.get(Calendar.MONTH) + 1);
//		int month = 12;
		
//		System.out.println(month);
		
		String season = " ";
		
		if ((3 <= month)&&(month <= 5)) {season = "spring";}
		else if ((6 <= month)&&(month <= 8)) {season = "summer";} 
		else if ((9 <= month)&&(month <= 11)) {season = "autumn";} 
		else {season = "winter";} 
		
//		System.out.println("MONTH "+month);
//		System.out.println("SEASON "+season);
		
		String path = "";
		
		for (int i=0; i<advertArray.size(); i++) {
//			System.out.println("OUT "+advertArray.get(i).adSeason);
			if (advertArray.get(i).adSeason.equals(season)) {
				path = advertArray.get(i).imageSrc;
			}
		}
		
//		for (int i=0; i<seasonArray.length; i++) {
//			if (seasonArray[i][1].equals(season)) {
////				System.out.println(imageArray[i][0]);
//				path = (seasonArray[i][0]);
//				
////			    Map f  = Files.readAttributes(path, "*");
////			    System.out.println(f);
//			}
//		}

		//// Print out image given path
//		 BufferedImage img=ImageIO.read(new File(path));
//	     ImageIcon icon=new ImageIcon(img);
//	     JFrame frame=new JFrame();
//	     frame.setLayout(new FlowLayout());
//	     frame.setSize(200,300);
//	     JLabel lbl=new JLabel();
//	     lbl.setIcon(icon);
//	     frame.add(lbl);
//	     frame.setVisible(true);
//	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
//	     Advert testAd = new Advert("testseason", "testpath");
//	     String testInput = testAd.adSeason;
//	     System.out.println("testInput "+testInput);
	     	
		String API_KEY = "131f84a6effc0274c8e2b0260bb9dc26";
		String LOCATION = "Dublin, IE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			System.out.println(result);
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			
			// Accessing array of objects isn't working
			Map<String, Object> weatherMap = jsonToMap(respMap.get("weather").toString());
			
			System.out.println("Curr Temp: "+mainMap.get("temp"));
			System.out.println("Curr Humidity: "+mainMap.get("humidity"));
			System.out.println("Wind Speeds: "+windMap.get("speed"));
			System.out.println("Wind Angle: "+windMap.get("deg"));
//			System.out.println("Desc: "+weatherMap.get("main"));
			
			Iterator<String> itr = weatherMap.keySet().iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			for (Object key : weatherMap.values()) {
				System.out.println("out "+key);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	// Convert JSON to Map
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}

}
