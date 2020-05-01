package linkedList;

import java.util.ArrayList;

//import com.sun.tools.javac.code.Attribute.Array;

public class mainCityClass {

	int plate;
	int neigCityBuffer;
	//int[] neigDistances = new int[81];
	ArrayList<Integer> neigDistances = new ArrayList<Integer>();
	String cityName;
	//String[] neigCitys = new String[15];
	ArrayList<String> neigCitys = new ArrayList<String>();
	
	mainCityClass prev;
	mainCityClass next;
	
	public mainCityClass( int plate , int neigCityBuffer , String cityName , String[] neigCitys , int[] neigDistances ) {
		
		this.plate = plate ;
		this.neigCityBuffer = neigCityBuffer ;
		this.cityName = cityName ;
		
		//this.neigCitys = neigCitys;
		int i;
		for(i=0;i<neigCityBuffer;i++) {
			this.neigCitys.add(neigCitys[i]);
		}	
		//this.neigDistances = neigDistances ;
		for(i=0;i<neigDistances.length;i++) {
			this.neigDistances.add(neigDistances[i]);
		}
		
	}	

}
