
public class Advert {

	public String adSeason;
	public String imageSrc;
	public String adWeather;
	public String adTemp;
	public String eventType;
	public String areaStatus;
	public String label;

//	public Advert(String seasonIn, String weatherIn, String tempIn, String statusIn, String imagePath) {
		public Advert(String labelIn, String imagePath) {
//		if ((seasonIn.equals("spring"))||(seasonIn.equals("summer"))||(seasonIn.equals("autumn"))||(seasonIn.equals("winter"))) {
//			adSeason = seasonIn;
////		}
//		
//		adWeather = weatherIn;
		imageSrc = imagePath;
//		adTemp = tempIn;
//		areaStatus = statusIn;
		label = labelIn;
	}
	

}
