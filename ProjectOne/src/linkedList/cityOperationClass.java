package linkedList;

public class cityOperationClass {

	mainCityClass head;
	mainCityClass tail;
	
	public cityOperationClass() {
		head = null;
		tail = null;
	}
	
	public boolean isitEmpty () {
		
		if( head != null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void addTail( int plate , int neigCityBuffer , String cityName , String[] neigCitys , int[] neigDistances ) {
		
		mainCityClass newCity = new mainCityClass( plate , neigCityBuffer , cityName , neigCitys , neigDistances );
		
		if( isitEmpty() ) {
			
			tail.next = newCity; 
			tail = newCity;
			
		}
		else {
			
			head = newCity;
			tail = newCity;
		}
		
	}
	
	public void printList () {
		
		mainCityClass visitor = head;
		
		while(visitor != null) {
			System.out.println("Plaka:" + visitor.plate);
			System.out.println("City name:" + visitor.cityName);
			System.out.println("Neighbor buffer:" + visitor.neigCityBuffer);
			
			int iTest;
			
			for(iTest=0;iTest<visitor.neigCityBuffer;iTest++) {
				System.out.println( (iTest+1) + ".komsu:" +  visitor.neigCitys.get(iTest));
			}
			
			for(iTest=0;iTest<81;iTest++) {
				System.out.println( (iTest+1) +".komsu mesafe:" + visitor.neigDistances.get(iTest));	
			}
			
			visitor = visitor.next;
		}
		
	}
	
	public int findPlate (String tmp) {
		
		mainCityClass finder = head;
		
		//System.out.println(tmp);
		
		int ret = 0;
		
		while(finder != null) {
			
			if(tmp.equals(finder.cityName)) {
				//System.out.println("plaka=" + finder.plate);
				
				ret = finder.plate;
				
			}
			
			finder=finder.next;
			
		}
		
		return ret;
		
	}
	
	
	
	public int go(int tmpPlate , int in) {
		
		mainCityClass inCity = head;
		
		 
		
		while(in != inCity.plate) {
			inCity = inCity.next;
		}
		
		
		//System.out.println("Bulunduðum þehir:" + inCity.cityName);
		
		
		int ret = 0;
		
		//System.out.println(tmpPlate + "=" + inCity.neigDistances.get(tmpPlate-1));
		
		ret = inCity.neigDistances.get(tmpPlate-1);

		return ret;
	}
	
	public int neiGo(int in,int target) {
		
		mainCityClass inCity = head;
		
		mainCityClass inTarget = head;
		
		mainCityClass finder = head;
		
		while(in != inCity.plate) {
			inCity = inCity.next;
		}
		System.out.println("Bulunduðumm þehir:" + inCity.cityName);
		
		while(target != inTarget.plate) {
			inTarget = inTarget.next;
		}
		
		
		System.out.println("Gideceðim þehir:" + inTarget.cityName);
	
		int i = 0;
		
		int neigOk = 0;
		
		int goPlate = 0;
		
		int lowDist = 9999;
		
		int tmpDist = 0;
		
		String[] tmpCity = new String[inCity.neigCityBuffer];
		
		for(i=0 ; i<inCity.neigCityBuffer ; i++) {
			
			tmpCity[i] = inCity.neigCitys.get(i);
			
			//System.out.println(tmpCity[i]);
			
			if(tmpCity[i].equals(inTarget.cityName)) {
				//System.out.println("komþusu");
				neigOk++;
				break;
			}
			
		}
		
		
		if(neigOk == 1) {
			return 0;
		}
		
		else {
			
			int plate = 0;
			
			
			for(i=0; i<inCity.neigCityBuffer ; i++) {
				
					plate = findPlate(tmpCity[i]);
					
					//System.out.println(tmpCity[i] + "plakasý:" + plate);
				
					
					tmpDist = inTarget.neigDistances.get(plate-1);
					
					//System.out.println( inTarget.cityName + "-" + tmpCity[i] +"platesi:"+ plate +" uzaklýðý:" + tmpDist + "/" + lowDist);
					
					if(tmpDist < lowDist) {
						//System.out.println("girdi");
						lowDist = tmpDist;
						goPlate = plate;
						
					}
			}
			
			System.out.println("döndürdüðüm plaka:" + goPlate);
			
			return goPlate;
			
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
