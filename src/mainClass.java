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
		
		Advert winterAd = new Advert("winter", "", "", "Winter.jpg");
		Advert springAd = new Advert("spring", "", "", "Spring.jpg");
		Advert summerAd = new Advert("summer", "", "", "Summer.jpg");
		Advert autumnAd = new Advert("autumn", "", "", "Autumn.jpg");
		
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
//		showAd (path);
	     	
		String WEATHER_API_KEY = "131f84a6effc0274c8e2b0260bb9dc26";
		String LOCATION = "Dublin, IE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+WEATHER_API_KEY+"&units=metric";
		
            String retVal = "";
            String weatherType = "";
            double currTemp = 0;
            String tempType = "";

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

//                System.out.println("retVal: "+retVal);
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
                    
                    Map<String, Object> respMap = jsonToMap(retVal.toString());
        			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

        			currTemp =  (double) mainMap.get("temp");
//        			System.out.println("Curr Temp: "+currTemp);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        
            
            Advert clearAd = new Advert("", "Clear", "", "Clear.jpg");
    		Advert cloudsAd = new Advert("", "Clouds", "", "Clouds.jpg");
    		Advert drizzleAd = new Advert("", "Drizzle", "", "Drizzle.jpg");
    		Advert rainAd = new Advert("", "Rain", "", "Rain.jpg");
    		Advert snowAd = new Advert("", "Snow", "", "Snow.jpg");
    		Advert tstormAd = new Advert("", "Thunderstorm", "", "Thunderstorm.jpg");
    		
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
//    		showAd (path);
    	     
			if ((-30 <= currTemp)&&(currTemp <= -10)) {tempType = "Extremely Freezing";}
			else if ((-10 < currTemp)&&(currTemp <= 0)) {tempType = "Freezing";} 
			else if ((0 < currTemp)&&(currTemp <= 10)) {tempType = "Very Cold";} 
			else if ((10 < currTemp)&&(currTemp <= 15)) {tempType = "Cold";} 
			else if ((15 < currTemp)&&(currTemp <= 20)) {tempType = "Cool";} 
			else if ((20 < currTemp)&&(currTemp <= 25)) {tempType = "Warm";} 
			else if ((25 < currTemp)&&(currTemp <= 30)) {tempType = "Very Warm";} 
			else if ((30 < currTemp)&&(currTemp <= 37)) {tempType = "Hot";} 
			else if ((37 < currTemp)&&(currTemp <= 50)) {tempType = "Very Hot";} 
			else if (50 < currTemp) {tempType = "Extremely Hot";} 
			
			Advert extremelyFreezingAd = new Advert("", "", "Extremely Freezing", "ExtremelyFreezing.jpg");
			Advert freezingAd = new Advert("", "", "Freezing", "Freezing.jpg");
			Advert veryColdAd = new Advert("", "", "Very Cold", "VeryCold.jpg");
			Advert coldAd = new Advert("", "", "Cold", "Cold.jpg");
			Advert coolAd = new Advert("", "", "Cool", "Cool.jpg");
			Advert warmAd = new Advert("", "", "Warm", "Warm.jpg");
			Advert veryWarmAd = new Advert("", "", "Very Warm", "VeryWarm.jpg");
			Advert hotAd = new Advert("", "", "Hot", "Hot.jpg");
			Advert veryHotAd = new Advert("", "", "Very Hot", "VeryHot.jpg");
			Advert ExtremelyHotAd = new Advert("", "", "Extremely Hot", "ExtremelyHot.jpg");
			
			advertArray.add(extremelyFreezingAd);
			advertArray.add(freezingAd);
			advertArray.add(veryColdAd);
			advertArray.add(coldAd);
			advertArray.add(coolAd);
			advertArray.add(warmAd);
			advertArray.add(veryWarmAd);
			advertArray.add(hotAd);
			advertArray.add(veryHotAd);
			advertArray.add(ExtremelyHotAd);
			
			for (int i=0; i<advertArray.size(); i++) {
//    			System.out.println("OUT1 "+advertArray.get(i).adTemp);
    			if (advertArray.get(i).adTemp.equals(tempType)) {
    				path = advertArray.get(i).imageSrc;
//    				System.out.println("OUT "+advertArray.get(i).imageSrc);
    			}
    		}
//			showAd (path);
			
			String EVENTS_API_KEY = "Qn3VKm3dgWtS0AXLUiQ5zEIorM54bTli";
			String EVENTS_LOCATION = "53.345070,-6.256610";
//			String eventsUrlString = "https://app.ticketmaster.com/discovery/v2/events.json?countryCode=IE&apikey="+EVENTS_API_KEY;
//			String eventsUrlString = "https://api.predicthq.com/v1/events/count/?country=IE&apikey=phq.T9og95XRJGYHLmDBBte4KRo3lBYsxCU8mJmrtLDQ";
//			53.345070,-6.256610
			int NUM_PAGES = 20;
			String eventsUrlString = "https://app.ticketmaster.com/discovery/v2/events?apikey="+EVENTS_API_KEY+"&radius=20&size="+NUM_PAGES+"&unit=km&geoPoint="+EVENTS_LOCATION;
//			String eventsClassificationsUrlString = "https://app.ticketmaster.com/discovery/v2/classifications?apikey="+EVENTS_API_KEY;

			
			String ticketMasterReturn = "";
			try {
                URL url = new URL(eventsUrlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char c = (char) data;
                    ticketMasterReturn += c;
                    data = reader.read();
                }

//                System.out.println("ticketmaster: "+ticketMasterReturn+"\n");
            } catch (Exception e) {
            	System.out.println(e);
            }
			
//			String eventsClassifications = "";
//			try {
//                URL url = new URL(eventsClassificationsUrlString);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                InputStream in = conn.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int data = reader.read();
//                while (data != -1) {
//                    char c = (char) data;
//                    eventsClassifications += c;
//                    data = reader.read();
//                }

//                System.out.println("Classifications: "+eventsClassifications);
//                
//            } catch (Exception e) {
//            	System.out.println(e);
//            }
			
			
			String eventName = "";
			String eventName2 = "";
			try {
                JSONObject json = new JSONObject(ticketMasterReturn);                    
              

                        @SuppressWarnings("unchecked")
                        Map<String, String> map = new Gson().fromJson(json.toString(),Map.class);
//                        System.out.println(map);
                        
//                        System.out.println("TOSTRING "+map.toString());
                        String details = map.toString();
                        
                   ArrayList<String> eventGenres = new ArrayList<String>();     
                   int endIndex = 0;     
                   int size = details.length();
//                   while (endIndex != details.length()) {     
                   for (int i=0; i<details.length(); i+=endIndex) {
                	   int startIndex = details.indexOf("genre={name=");
                     endIndex = details.indexOf(" ", startIndex);
                     if (endIndex == -1) {
                         endIndex = details.length();
                     }
                     String link = details.substring(startIndex+12, endIndex-1);
//                     System.out.println("LINK "+link);
                     details = details.substring(endIndex+startIndex);
//                     int nextIndex = details.indexOf("genre={name=");
                     eventGenres.add(link);
                   }
                   
                   System.out.println("Genres: "+eventGenres.toString());
                   
//                        System.out.println("genres "+eventGenres.toString());
//                        
//                        JSONObject obj2 = (JSONObject)json.get("_embedded");
//                        System.out.println("Field \"1\"");
////                        System.out.println(obj2.get("events"));   
//                        obj2 = (JSONObject)obj2.get("events");
//                        System.out.println(obj2.toString());
//                        
//                        int startIndex = details.indexOf("genre={name=");
//                        endIndex = details.indexOf(" ", startIndex);
//                        if (endIndex == -1) {
//                            endIndex = details.length();
//                        }
//                        String link = details.substring(startIndex+12, endIndex-1);
//                        System.out.println("LINK "+link);
//                
//                }
//                    Map<String, Object> respMap = jsonToMap(ticketMasterReturn.toString());
//        			Map<String, Object> mainMap = jsonToMap(respMap.get("embedded").toString());
//
//        			eventName2 =  (String) mainMap.get("events");
//        			eventName =  (String) respMap.get("subGenre");
//        			System.out.println("Curr Temp: "+eventName);
//        			System.out.println("2 Temp: "+eventName2);
////                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
			
			
			
			
			
			
//			String MAPS_API_KEY = "AIzaSyD_Yzb_x6GQhtsUnyXLFPD2yfMdKvvMJZs";
//			String eventsUrlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=53.345070,-6.256610&radius=100&key="+MAPS_API_KEY;
//			
//			String mapsMasterReturn = "";
//			try {
//                URL url = new URL(eventsUrlString);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                InputStream in = conn.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int data = reader.read();
//                while (data != -1) {
//                    char c = (char) data;
//                    mapsMasterReturn += c;
//                    data = reader.read();
//                }
//
//                System.out.println("Maps: "+mapsMasterReturn);
//            } catch (Exception e) {
//            	System.out.println(e);
//            }
//			String mapsType = "";
//			
//			 try {
//	                JSONObject json = new JSONObject(retVal);
//	                JSONArray partJson = json.getJSONArray("results");
//	                for (int i = 0; i < partJson.length(); i++) {
//	                    JSONObject mapsJSON = partJson.getJSONObject(i);
//	                    mapsType = (mapsJSON.getString("name"));
//	                    String descText = (mapsJSON.getString("description"));
////	                    System.out.println("weatherType "+weatherType);
////	                  System.out.println("descText "+descText);
//	                    
//	                    Map<String, Object> respMap = jsonToMap(retVal.toString());
//	        			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
//
//	        			currTemp =  (double) mainMap.get("temp");
////	        			System.out.println("Curr Temp: "+currTemp);
//	                }
//	            } catch (JSONException e) {
//	                e.printStackTrace();
//	            }
			
	}
	
	// Convert JSON to Map
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}
	
	public static void showAd (String pathIn) throws IOException {
		BufferedImage img=ImageIO.read(new File(pathIn));
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

}
