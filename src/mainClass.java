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


import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

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
	     	
	     URL url = new URL("api.openweathermap.org/data/2.5/weather?q=London");
	     HttpURLConnection con = (HttpURLConnection) url.openConnection();
	     con.setRequestMethod("GET");

	}


}
