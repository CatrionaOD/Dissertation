
public class Advert {

	public String adSeason;
	public String imageSrc;
	public String adWeather;

	public Advert(String seasonIn, String weatherIn, String imagePath) {
//		if ((seasonIn.equals("spring"))||(seasonIn.equals("summer"))||(seasonIn.equals("autumn"))||(seasonIn.equals("winter"))) {
			adSeason = seasonIn;
//		}
		
		adWeather = weatherIn;
		imageSrc = imagePath;
	}
	

}
