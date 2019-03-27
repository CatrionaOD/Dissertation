import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Wrapper;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;

import static java.nio.file.StandardCopyOption.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.util.Timer;
import java.util.TimerTask;


public class mainClass {
	static ArrayList<Advert> advertArray = new ArrayList<Advert>();
	static int index = 0;
	
	public static void main(String[] args) throws IOException, JSONException, ScriptException {		
		String season = " ";

		String path = "";
					
			String EVENTS_API_KEY = "Qn3VKm3dgWtS0AXLUiQ5zEIorM54bTli";
			String EVENTS_LOCATION = "53.345070,-6.256610";
//			String eventsUrlString = "https://app.ticketmaster.com/discovery/v2/events.json?countryCode=IE&apikey="+EVENTS_API_KEY;
//			String eventsUrlString = "https://api.predicthq.com/v1/events/count/?country=IE&apikey=phq.T9og95XRJGYHLmDBBte4KRo3lBYsxCU8mJmrtLDQ";
//			53.345070,-6.256610
			int NUM_PAGES = 20;
//			String eventsUrlString = "https://app.ticketmaster.com/discovery/v2/events?apikey="+EVENTS_API_KEY+"&radius=20&size="+NUM_PAGES+"&unit=km&geoPoint="+EVENTS_LOCATION;
			String classifications = "https://app.ticketmaster.com/discovery/v2/classifications?&events?apikey="+EVENTS_API_KEY;
//			String eventsClassificationsUrlString = "https://app.ticketmaster.com/discovery/v2/classifications?apikey="+EVENTS_API_KEY;

			
//			String ticketMasterReturn = "";
//			try {
//                URL url = new URL(classifications);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                InputStream in = conn.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int data = reader.read();
//                while (data != -1) {
//                    char c = (char) data;
//                    ticketMasterReturn += c;
//                    data = reader.read();
//                }
//
//                System.out.println("classifications: "+ticketMasterReturn+"\n");
//            } catch (Exception e) {
//            	System.out.println(e);
//            }
			
			// Prints Genre ArrayList but is a bit slow
//			String eventName = "";
//			String eventName2 = "";
//			try {
//                JSONObject json = new JSONObject(ticketMasterReturn);                    
//              
//
//                        @SuppressWarnings("unchecked")
//                        Map<String, String> map = new Gson().fromJson(json.toString(),Map.class);
////                        System.out.println(map);
//                        
////                        System.out.println("TOSTRING "+map.toString());
//                        String details = map.toString();
//                        
//                   ArrayList<String> eventGenres = new ArrayList<String>();     
//                   int endIndex = 0;     
//                   int size = details.length();
////                   while (endIndex != details.length()) {     
//                   for (int i=0; i<details.length(); i+=endIndex) {
//                	   int startIndex = details.indexOf("genre={name=");
//                     endIndex = details.indexOf(" ", startIndex);
//                     if (endIndex == -1) {
//                         endIndex = details.length();
//                     }
//                     String link = details.substring(startIndex+12, endIndex-1);
////                     System.out.println("LINK "+link);
//                     details = details.substring(endIndex+startIndex);
////                     int nextIndex = details.indexOf("genre={name=");
//                     eventGenres.add(link);
//                   }
//                   
//                   System.out.println("Genres: "+eventGenres.toString());
//                   
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
			
			
			
//			String predictHQAccessToken = "ZbgbxZsCWaWuOAHXS12P3Wbb61pbvQ";
//			String predictUrlString = "https://api.predicthq.com/v1/events/?apikey="+predictHQAccessToken+"&q=jazz&country=IE";
////			String predictUrlString = "https://api.predicthq.com/v1/events/?q=jazz&country=IE";
//			
//			String predictHQReturn = "";
//			try {
//                URL url = new URL(predictUrlString);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////                conn.setRequestMethod("GET");
////                conn.setRequestProperty("Authorization", predictHQAccessToken);
////
////        		int responseCode = conn.getResponseCode();
////        		System.out.println("\nSending 'GET' request to URL : " + url);
////        		System.out.println("Response Code : " + responseCode);
////
////        		BufferedReader in = new BufferedReader(
////        		        new InputStreamReader(conn.getInputStream()));
////        		String inputLine;
////        		StringBuffer response = new StringBuffer();
////
////        		while ((inputLine = in.readLine()) != null) {
////        			response.append(inputLine);
////        		}
////        		in.close();
////
////        		//print result
////        		System.out.println(response.toString());
//                
//                InputStream in = conn.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int data = reader.read();
//                while (data != -1) {
//                    char c = (char) data;
//                    predictHQReturn += c;
//                    data = reader.read();
//			}
//
//                System.out.println("PredictHQ: "+predictHQReturn+"\n");
//            } catch (Exception e) {
//            	System.out.println(e);
//            }
			
			
//			byte[] jsonData = ticketMasterReturn.getBytes();
//
//			ObjectMapper objectMapper = new ObjectMapper();
//
//			//read JSON like DOM Parser
//			JsonNode rootNode = objectMapper.readTree(jsonData);
//			JsonNode idNode = rootNode.path("event");
//			System.out.println("event = "+idNode.toString());
//
//			JsonNode phoneNosNode = rootNode.path("classifications");
//			Iterator<JsonNode> elements = phoneNosNode.elements();
//			while(elements.hasNext()){
//				JsonNode phone = elements.next();
//				System.out.println("Phone No = "+phone.toString());
//			}
//			System.out.println("Event \n"+event);
			
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
					
				 String fileToParse = "DublinCityCensus.csv";
				 ArrayList<Advert> advertArray = new ArrayList<Advert>();
				 
//					Advert winterAd = new Advert("winter", "", "", "", "Winter.jpg");
//					Advert springAd = new Advert("spring", "", "", "", "Spring.jpg");
//					Advert summerAd = new Advert("summer", "", "", "", "Summer.jpg");
//					Advert autumnAd = new Advert("autumn", "", "", "", "Autumn.jpg");
//					
////					ArrayList<Advert> advertArray = new ArrayList<Advert>();
//					advertArray.add(summerAd);
//					advertArray.add(winterAd);
//					advertArray.add(springAd);
//					advertArray.add(autumnAd);
//				 
//				 Advert clearAd = new Advert("", "Clear", "", "", "Clear.jpg");
//		    		Advert cloudsAd = new Advert("", "Clouds", "", "", "Clouds.jpg");
//		    		Advert drizzleAd = new Advert("", "Drizzle", "", "", "Drizzle.jpg");
//		    		Advert rainAd = new Advert("", "Rain", "", "", "Rain.jpg");
//		    		Advert snowAd = new Advert("", "Snow", "", "", "Snow.jpg");
//		    		Advert tstormAd = new Advert("", "Thunderstorm", "", "", "Thunderstorm.jpg");
//		    		
//		    		advertArray.add(clearAd);
//		    		advertArray.add(cloudsAd);
//		    		advertArray.add(drizzleAd);
//		    		advertArray.add(rainAd);
//		    		advertArray.add(snowAd);
//		    		advertArray.add(tstormAd);  	
//		    		
//		    		Advert extremelyFreezingAd = new Advert("", "", "Extremely Freezing", "", "ExtremelyFreezing.jpg");
//					Advert freezingAd = new Advert("", "", "Freezing", "", "Freezing.jpg");
//					Advert veryColdAd = new Advert("", "", "Very Cold", "", "VeryCold.jpg");
//					Advert coldAd = new Advert("", "", "Cold", "", "Cold.jpg");
//					Advert coolAd = new Advert("", "", "Cool", "", "Cool.jpg");
//					Advert warmAd = new Advert("", "", "Warm", "", "Warm.jpg");
//					Advert veryWarmAd = new Advert("", "", "Very Warm", "", "VeryWarm.jpg");
//					Advert hotAd = new Advert("", "", "Hot", "", "Hot.jpg");
//					Advert veryHotAd = new Advert("", "", "Very Hot", "", "VeryHot.jpg");
//					Advert ExtremelyHotAd = new Advert("", "", "Extremely Hot", "", "ExtremelyHot.jpg");
//					
//					advertArray.add(extremelyFreezingAd);
//					advertArray.add(freezingAd);
//					advertArray.add(veryColdAd);
//					advertArray.add(coldAd);
//					advertArray.add(coolAd);
//					advertArray.add(warmAd);
//					advertArray.add(veryWarmAd);
//					advertArray.add(hotAd);
//					advertArray.add(veryHotAd);
//					advertArray.add(ExtremelyHotAd);
//
//
//			        Advert veryHighEarningAd = new Advert("", "", "", "Very High Earning", "VeryHighEarning.jpg");
//					Advert highEarningAd = new Advert("", "", "", "High Earning", "HighEarningAd.jpg");
//					Advert lowEarningAd = new Advert("", "", "", "Low Earning", "LowEarning.jpg");
//					Advert veryLowEarningAd = new Advert("", "", "", "Very Low Earning", "VeryLowEarning.jpg");
//					
//					advertArray.add(veryHighEarningAd);
//					advertArray.add(highEarningAd);
//					advertArray.add(lowEarningAd);
//					advertArray.add(veryLowEarningAd);

//					int minutes = 1;
					
				 
				 
				    String COMMA_DELIMITER = ",";
				    String NEW_LINE_SEPARATOR = "\n";
				     
				    //CSV file header
				    String FILE_HEADER = "id,firstName,lastName,gender,age";
				    
				    FileWriter fileWriter = null;
			 
				    String csv = "LocationData.csv";
			           					
//					Timer timer = new Timer();
//					timer.schedule(new TimerTask() {
//						 @Override
//						    public void run() {
//							 try {
								printData(fileToParse, csv);
//							} catch (IOException e) {
								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						 }
//					}, 0, 300000);
			        
//					showAd (path);
					
					
					String advertToShowLabel = "";
					
					Advert familyAd = new Advert("Family", "Family.jpg");
					 Advert clothesAd = new Advert("Clothes", "Clothes.jpg");
					 Advert fastfoodAd = new Advert("FastFood", "FastFood.jpg");
					 Advert holidaysAd = new Advert("Holidays", "Holidays.jpg");
					 Advert luxurybrandsAd = new Advert("LuxuryBrands", "LuxuryBrands.jpg");
					 
					 advertArray.add(familyAd);
					 advertArray.add(clothesAd);
					 advertArray.add(fastfoodAd);
					 advertArray.add(holidaysAd);
					 advertArray.add(luxurybrandsAd);
					
					String labelFile = "C:/Users/Catríona/Downloads/Dissertation/outputLabels.csv";
					
					 BufferedReader br = null;
				        String line = "";
				        String cvsSplitBy = ",";
				        String predLabel = "";

				        try {

				            br = new BufferedReader(new FileReader(labelFile));
				            while ((line = br.readLine()) != null) {

				                // use comma as separator
				                String[] label = line.split(cvsSplitBy);
				                
				                predLabel = label[0];
				                
				            }

				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        } finally {
				            if (br != null) {
				                try {
				                    br.close();
				                } catch (IOException e) {
				                    e.printStackTrace();
				                }
				            }
				        }
				        predLabel = predLabel.replace("[", "");
		                predLabel = predLabel.replace("]", "");
//		                
		                int numPredLabel = Integer.parseInt(predLabel);
//		                System.out.println(numPredLabel);
		                
		                switch (numPredLabel) {
		                case 1: advertToShowLabel = "Family";
		                break;
		                case 2: advertToShowLabel = "FastFood";
		                break;
		                case 3: advertToShowLabel = "LuxuryBrands";
		                break;
		                case 4: advertToShowLabel = "Holidays";
		                break;
		                default: advertToShowLabel = "Clothes";
		                break;
		                }
		                
//		                System.out.println(advertToShowLabel);
		                
		                for (int i=0; i<advertArray.size(); i++) {
//		    			System.out.println("OUT "+advertArray.get(i).label);
		                	if (advertArray.get(i).label.equals(advertToShowLabel)) {
		                		path = advertArray.get(i).imageSrc;
//		                		System.out.println("OUT "+advertArray.get(i).imageSrc);
		                	}
		                }
//		                System.out.println(path);
		                showAd(path);
		    		
	
}
	public static void printData(String fileToParse, String csv) throws IOException {
		String indexText = Integer.toString(index);
		
		int seasonVal = getSeason();
		String seasonText = Integer.toString(seasonVal);
//		String seasonText = getSeason();
//		System.out.println("seasonPath "+seasonText); 
		
		int weatherVal = getWeather();
		String weatherText = Integer.toString(weatherVal);
//		String weatherText = getWeather();
//		System.out.println("weatherPath "+weatherText);
		
		int tempVal = getTemp();
		String tempText = Integer.toString(tempVal);
//		System.out.println("tempPath "+tempText);
		
		int classVal = getClass(fileToParse);
		String classText = Integer.toString(classVal);
//		String classText = getClass(fileToParse);
//		 System.out.println("classPath "+classText);
		 
		 FileWriter fwriter= new FileWriter(csv, true);
		 CSVWriter csvwriter= new CSVWriter(fwriter);
		 
		 int timeVal = getTime();
		 String timeText = Integer.toString(timeVal);
		 
//		 LocalTime time = LocalTime.now();
//		 String timeText = time.toString();
//		 System.out.println(timeText);

         String[] row = new String[6];
         row[0] = indexText;
         row[1] = timeText;
         row[2] = seasonText;
         row[3] = weatherText;
         row[4] = tempText;
         row[5] = classText;
         csvwriter.writeNext(row);
         

         csvwriter.close();
         
         index++;
	}
	
	public static int getTime() {
		int timeLabel = 0;
		
		Date date = new Date();   // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);   // assigns calendar to given date 
		int hour =  calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
//		System.out.println("HOUR"+hour);
		
		if ((0 < hour)&&(hour <= 6)) {timeLabel = 1;}
		else if ((6 < hour)&&(hour <= 9)) {timeLabel = 2;} 
		else if ((9 < hour)&&(hour <= 12)) {timeLabel = 3;} 
		else if ((12 < hour)&&(hour <= 14)) {timeLabel = 4;} 
		else if ((14 < hour)&&(hour <= 17)) {timeLabel = 5;} 
		else if ((17 < hour)&&(hour <= 21)) {timeLabel = 6;} 
		else {timeLabel = 7;} 
		
		return timeLabel;
	}
	
	public static int getSeason() {
		Calendar date = Calendar.getInstance();
		int month = (date.get(Calendar.MONTH) + 1);
		int seasonLabel = 0;
//		int month = 12;
		
//		System.out.println(month);
		
		String season = " ";
		
//		if ((3 <= month)&&(month <= 5)) {season = "spring";}
//		else if ((6 <= month)&&(month <= 8)) {season = "summer";} 
//		else if ((9 <= month)&&(month <= 11)) {season = "autumn";} 
//		else {season = "winter";} 
		
		if ((3 <= month)&&(month <= 5)) {seasonLabel = 1;}
		else if ((6 <= month)&&(month <= 8)) {seasonLabel = 2;} 
		else if ((9 <= month)&&(month <= 11)) {seasonLabel = 3;} 
		else {seasonLabel = 4;} 
				
//		System.out.println("MONTH "+month);
//		System.out.println("SEASON "+season);
		
//		String path = "";
//		
//		for (int i=0; i<advertArray.size(); i++) {
////			System.out.println("OUT "+advertArray.get(i).adSeason);
//			if (advertArray.get(i).adSeason.equals(season)) {
//				path = advertArray.get(i).imageSrc;
//			}
//		}
		return seasonLabel;
	}
	
	public static int getWeather() {
		String WEATHER_API_KEY = "131f84a6effc0274c8e2b0260bb9dc26";
		String LOCATION = "Dublin, IE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+WEATHER_API_KEY+"&units=metric";
		
            String retVal = "";
            String weatherType = "";
            double currTemp = 0;
            String tempType = "";
            String path ="";
            int weatherLabel = 0;

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

//        			currTemp =  (double) mainMap.get("temp");
//        			System.out.println("Curr Temp: "+currTemp);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i=0; i<advertArray.size(); i++) {
//    			System.out.println("OUT1 "+advertArray.get(i).adWeather);
    			if (advertArray.get(i).adWeather.equals(weatherType)) {
    				path = advertArray.get(i).imageSrc;
//    				System.out.println("OUT "+advertArray.get(i).imageSrc);
    			}
    		}
            
            if (weatherType.equals("Snow")) {weatherLabel = 1;}
    		else if (weatherType.equals("Drizzle")) {weatherLabel = 2;} 
    		else if (weatherType.equals("Rain")) {weatherLabel = 3;} 
    		else if (weatherType.equals("Clouds")) {weatherLabel = 4;} 
    		else if (weatherType.equals("Thunderstorm")) {weatherLabel = 5;} 
    		else if (weatherType.equals("Clear")) {weatherLabel = 6;} 
    		else if (weatherType.equals("Mist")) {weatherLabel = 7;} 
    		else {weatherLabel = 8;} 
            
			return weatherLabel;
	}
	
	public static int getTemp() {
		String WEATHER_API_KEY = "131f84a6effc0274c8e2b0260bb9dc26";
		String LOCATION = "Dublin, IE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+WEATHER_API_KEY+"&units=metric";
		
		double currTemp = 0;
		String tempType = "";
		String retVal = "";
        String path ="";
        String weatherType = "";
        int tempLabel = 0;

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

//            System.out.println("retVal: "+retVal);
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
//                System.out.println("weatherType "+weatherType);
//              System.out.println("descText "+descText);
                
                Map<String, Object> respMap = jsonToMap(retVal.toString());
    			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

    			currTemp =  (double) mainMap.get("temp");
//    			System.out.println("Curr Temp: "+currTemp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
//		if ((-30 <= currTemp)&&(currTemp <= -10)) {tempType = "Extremely Freezing";}
//		else if ((-10 < currTemp)&&(currTemp <= 0)) {tempType = "Freezing";} 
//		else if ((0 < currTemp)&&(currTemp <= 10)) {tempType = "Very Cold";} 
//		else if ((10 < currTemp)&&(currTemp <= 15)) {tempType = "Cold";} 
//		else if ((15 < currTemp)&&(currTemp <= 20)) {tempType = "Cool";} 
//		else if ((20 < currTemp)&&(currTemp <= 25)) {tempType = "Warm";} 
//		else if ((25 < currTemp)&&(currTemp <= 30)) {tempType = "Very Warm";} 
//		else if ((30 < currTemp)&&(currTemp <= 37)) {tempType = "Hot";} 
//		else if ((37 < currTemp)&&(currTemp <= 50)) {tempType = "Very Hot";} 
//		else if (50 < currTemp) {tempType = "Extremely Hot";} 
		if ((-30 <= currTemp)&&(currTemp <= -10)) {tempLabel = 1;}
		else if ((-10 < currTemp)&&(currTemp <= 0)) {tempLabel = 2;} 
		else if ((0 < currTemp)&&(currTemp <= 10)) {tempLabel = 3;} 
		else if ((10 < currTemp)&&(currTemp <= 15)) {tempLabel = 4;} 
		else if ((15 < currTemp)&&(currTemp <= 20)) {tempLabel = 5;} 
		else if ((20 < currTemp)&&(currTemp <= 25)) {tempLabel = 6;} 
		else if ((25 < currTemp)&&(currTemp <= 30)) {tempLabel = 7;} 
		else if ((30 < currTemp)&&(currTemp <= 37)) {tempLabel = 8;} 
		else if ((37 < currTemp)&&(currTemp <= 50)) {tempLabel = 9;} 
		else if (50 < currTemp) {tempLabel = 10;} 
		
//		System.out.println("TempType "+tempType);
        
        for (int i=0; i<advertArray.size(); i++) {
//			System.out.println("OUT1 "+advertArray.get(i).adTemp);
			if (advertArray.get(i).adTemp.equals(tempType)) {
				path = advertArray.get(i).imageSrc;
//				System.out.println("OUT "+advertArray.get(i).imageSrc);
			}
		}
        
		return tempLabel;
	}

public static int getClass(String fileToParse) {
	 BufferedReader fileReader = null;
     boolean allSocEcGroups = false;
     boolean highEarners = false;
     boolean lowEarners = false;
     String path = "";
     
     double noAllSocEcGroups = 0;
     double noHighEarners = 0;
     double noLowEarners = 0;
     
     int propHighEarners = 0;
     int propLowEarners = 0;
     int classLabel = 0;
     
     String areaEarnerStatus ="";
      
     //Delimiter used in CSV file
     final String DELIMITER = ",";
     try
     {
         String line = "";
         //Create the file reader
         fileReader = new BufferedReader(new FileReader(fileToParse));
          
         //Read the file line by line
         while ((line = fileReader.readLine()) != null)
         {
             //Get all tokens available in line
             String[] tokens = line.split(DELIMITER);
             for(String token : tokens)
             {
                 //Print all tokens
//                 System.out.println(token);
             	if (allSocEcGroups) {
//             		System.out.println("TOKEN "+token);
             		noAllSocEcGroups = Integer.parseInt(token);
             		allSocEcGroups = false;
             	}
             	
                 if (token.contains("All social classes")) {
//                 	System.out.println("FOUND ALLSOC");
                 	allSocEcGroups = true;
                 }
             	if (highEarners) {
//             		System.out.println("highEarners "+token);
             		noHighEarners += Integer.parseInt(token); 
             		highEarners = false;
             	}
             	else if (lowEarners) {
//             		System.out.println("TOTALlowEarners "+token);
             		noLowEarners += Integer.parseInt(token); 
             		lowEarners = false;
             	}	                	
             	
                 if ((token.contains("Professional"))|| (token.contains("Managerial"))){
//                 	System.out.println("PROFMAN");
                 	highEarners = true;
                 }
                 else if (token.contains("Unskilled")) {
//                 	System.out.println("UNSKILLED");
                 	lowEarners = true;
                 }
                 
             }
             
         }		                
	        propHighEarners = (int) ((noHighEarners / noAllSocEcGroups)*100);
	        propLowEarners = (int) ((noLowEarners / noAllSocEcGroups)*100);
	        
	        int highEarnerHigherBound = 56;
	        int highEarnerLowerBound = 27;
	        int lowEarnerHigherBound = 5;
	        int lowEarnerLowerBound = 1;
	        
//	        int highEarnerRanking = (propHighEarners - highEarnerLowerBound) / (highEarnerHigherBound - highEarnerLowerBound);
	        double highEarnerRanking = (double)(propHighEarners - highEarnerLowerBound) / (highEarnerHigherBound - highEarnerLowerBound);
	        
	        double lowEarnerRanking = (double)(propLowEarners - lowEarnerLowerBound) / (lowEarnerHigherBound - lowEarnerLowerBound);
	        
//         System.out.println("propHighEarners "+propHighEarners);
//         System.out.println("propLowEarners "+propLowEarners);
//         System.out.println("highEarnerRanking "+highEarnerRanking);
//         System.out.println("lowEarnerRanking "+lowEarnerRanking);
         
         if (highEarnerRanking >= 0.75) {
         	areaEarnerStatus = "Very High Earning";
         	classLabel = 1;
         }
         else if ((highEarnerRanking <= 0.75)&&(highEarnerRanking >= 0.5)) {
         	areaEarnerStatus = "High Earning";
         	classLabel = 2;
         }
         else if ((lowEarnerRanking < 0.75)&&(lowEarnerRanking >= 0.5)) {
         	areaEarnerStatus ="Low Earning";
         	classLabel = 3;
         }
         else if (lowEarnerRanking >= 0.75) {
         	areaEarnerStatus ="Very Low Earning";
         	classLabel = 4;
         }
         
     }
     catch (Exception e) {
         e.printStackTrace();
     }
     finally
     {
         try {
             fileReader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     for (int i=0; i<advertArray.size(); i++) {
//			System.out.println("OUT "+advertArray.get(i).areaStatus);
//			System.out.println("OUTSTATUS "+areaEarnerStatus);
			if (advertArray.get(i).areaStatus.equals(areaEarnerStatus)) {
				path = advertArray.get(i).imageSrc;
			}
		}
//    System.out.println("OUTSTATUS "+areaEarnerStatus);
	return classLabel;
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
