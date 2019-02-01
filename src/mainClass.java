import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Wrapper;
import java.text.DecimalFormat;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	public static void main(String[] args) throws IOException, JSONException {
		
		String[][] seasonArray = new String[4][4];
		
//		seasonArray[0][0] = "Winter.jpg";
//		seasonArray[0][1] = "winter";
//		seasonArray[1][0] = "Spring.jpg";
//		seasonArray[1][1] = "spring";
//		seasonArray[2][0] = "Summer.jpg";
//		seasonArray[2][1] = "summer";
//		seasonArray[3][0] = "Autumn.jpg";
//		seasonArray[3][1] = "autumn";
		
		Advert winterAd = new Advert("winter", "", "Winter.jpg");
		Advert springAd = new Advert("spring", "", "Spring.jpg");
		Advert summerAd = new Advert("summer", "", "Summer.jpg");
		Advert autumnAd = new Advert("autumn", "", "Autumn.jpg");
		
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
	     
	     	
		String API_KEY = "131f84a6effc0274c8e2b0260bb9dc26";
		String LOCATION = "Dublin, IE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";
		
            String retVal = "";
            String weatherType = "";

            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char c = (char) data;
                    retVal += c;
                    data = reader.read();
                }

                System.out.println("retVal: "+retVal);
            } catch (Exception e) {
            	System.out.println(e);
            }

            try {
                JSONObject json = new JSONObject(retVal);
                JSONArray partJson = json.getJSONArray("weather");
                for (int i = 0; i < partJson.length(); i++) {
                    JSONObject weatherJSON = partJson.getJSONObject(i);
                    weatherType = (weatherJSON.getString("main"));
                    String descText = (weatherJSON.getString("description"));
//                    System.out.println("weatherType "+weatherType);
//                  System.out.println("descText "+descText);
                    
//                  Map<String, Object> respMap = jsonToMap(retVal.toString());
//        			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

//        			System.out.println("Curr Temp: "+mainMap.get("temp"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        
            
            Advert clearAd = new Advert("", "Clear", "Clear.jpg");
    		Advert cloudsAd = new Advert("", "Clouds", "Clouds.jpg");
    		Advert drizzleAd = new Advert("", "Drizzle", "Drizzle.jpg");
    		Advert rainAd = new Advert("", "Rain", "Rain.jpg");
    		Advert snowAd = new Advert("", "Snow", "Snow.jpg");
    		Advert tstormAd = new Advert("", "Thunderstorm", "Thunderstorm.jpg");
    		
    		advertArray.add(clearAd);
    		advertArray.add(cloudsAd);
    		advertArray.add(drizzleAd);
    		advertArray.add(rainAd);
    		advertArray.add(snowAd);
    		advertArray.add(tstormAd);
    		
    		for (int i=0; i<advertArray.size(); i++) {
//    			System.out.println("OUT1 "+advertArray.get(i).adWeather);
    			if (advertArray.get(i).adWeather.equals(weatherType)) {
    				path = advertArray.get(i).imageSrc;
//    				System.out.println("OUT "+advertArray.get(i).imageSrc);
    			}
    		}

    		//// Print out image given path
    		 BufferedImage img=ImageIO.read(new File(path));
    	     ImageIcon icon=new ImageIcon(img);
    	     JFrame frame=new JFrame();
    	     frame.setLayout(new FlowLayout());
    	     frame.setSize(200,300);
    	     JLabel lbl=new JLabel();
    	     lbl.setIcon(icon);
    	     frame.add(lbl);
    	     frame.setVisible(true);
    	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	     
			
			
		
	}
	
	
	// Convert JSON to Map
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}

}
