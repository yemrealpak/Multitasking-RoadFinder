package linkedList;

public class mainCityClass {

	int plate;
	int neigCityBuffer;
	int[] neigDistances = new int[81];
	String cityName;
	String[] neigCitys = new String[15];
	
	mainCityClass prev;
	mainCityClass next;
	
	public mainCityClass( int plate , int neigCityBuffer , String cityName , String[] neigCitys , int[] neigDistances ) {
		
		this.plate = plate ;
		this.neigCityBuffer = neigCityBuffer ;
		this.cityName = cityName ;
		this.neigCitys = neigCitys;
		this.neigDistances = neigDistances ;
		
	}	

}
