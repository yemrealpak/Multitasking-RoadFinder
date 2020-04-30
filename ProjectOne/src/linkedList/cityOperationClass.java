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
				System.out.println( (iTest+1) + ".komsu:" +  visitor.neigCitys[iTest]);
			}
			
			for(iTest=0;iTest<visitor.neigDistances.length;iTest++) {
				System.out.println( (iTest+1) +".komsu mesafe:" + visitor.neigDistances[iTest]);	
			}
			
			visitor = visitor.next;
		}
		
	}
	
}
