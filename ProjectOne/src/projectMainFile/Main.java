package projectMainFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import linkedList.cityOperationClass;
import map.ScScreen;




public class Main {

	public static void main(String[] args) {
		
		
		
		File file = new File("Sehirler.txt");
		try {
			
			Scanner sc = new Scanner(file);
			
			cityOperationClass cityOp = new cityOperationClass();
			
			int plate;
			String intPlate;
			int neigCityBuffer;
			int[] neigDistances = new int[81];
			int tmpDistance;
			String intNneigDistances;
			String cityName;
			String[] neigCitys = new String[15];
			
			int i;
			int j;
			
			while(sc.hasNextLine()) {
					
				String[] lineSplit = null;
				
				String str = sc.nextLine();
				
				//System.out.println(str);
				
				lineSplit = str.split(",");
				
				//System.out.println("plakalar:" + lineSplit[0]);//read test
				intPlate = lineSplit[0];
				plate = Integer.parseInt(intPlate);
				//System.out.println("plakalar:" + plate);//LL test
				
				//System.out.println("adi:" + lineSplit[1]);
				cityName = lineSplit[1];
				//System.out.println("adi:" + cityName);
				
				neigCityBuffer = 0;
				for(i=2;i<(lineSplit.length-81);i++) {
					
					//System.out.println( (neigCityBuffer+1) + ".komsu:" + lineSplit[i] );
					neigCitys[neigCityBuffer] = lineSplit[i];
					neigCityBuffer++;
					//System.out.println( neigCityBuffer + ".komsu:" + neigCitys[neigCityBuffer-1] );
				}
				//System.out.println("komsu sayisi:" + neigCityBuffer);
				
				
				j=0;
				int tmpi;
				tmpi = i;
				for(i=tmpi;i<lineSplit.length;i++) {
					//System.out.println( (j+1) +".komsu mesafe:" + lineSplit[i]);
					intNneigDistances = lineSplit[i];
					tmpDistance = Integer.parseInt(intNneigDistances);
					//System.out.println( (j+1) +".komsu mesafe:" + intNneigDistances);
					//System.out.println( (j+1) +".komsu mesafe:" + tmpDistance);
					neigDistances[j] = tmpDistance;
					//System.out.println( (j+1) +".komsu mesafe:" + neigDistances[j]);
					j++;
				}
				
				/*int iTest;
				
				System.out.println("plakalar:" + plate);
				
				System.out.println("adi:" + cityName);
				
				for(iTest=0;iTest<neigCityBuffer;iTest++) {
					System.out.println( (iTest+1) + ".komsu:" + neigCitys[iTest] );
				}
				
				System.out.println("komsu sayisi:" + neigCityBuffer);
				
				for(iTest=0;iTest<neigDistances.length;iTest++) {
				System.out.println( (iTest+1) +".komsu mesafe:" + neigDistances[iTest]);	
				}*/
				
				cityOp.addTail(plate, neigCityBuffer, cityName, neigCitys, neigDistances);
				
				//cityOp.printList();
				
				
				
				
				
			}
			
			sc.close();
			
			Scanner oku = new Scanner(System.in);
			
			System.out.println("Sehirleri Gir=!");
			
			String[] tmpC = new String[10];
			
			int tmpclen = 0;
			
			String userInput ;
			
			System.out.println("çýkmak için e ye basýn");
			
			for(i=0;i<10;i++) {
				
				userInput = oku.next();
				
				if(userInput.equals("e")) {
					System.out.println("exit");
					break;
				}
				
				tmpC[i] = userInput;
				tmpclen++;
				
			}
			
			System.out.println("Start");
			
			System.out.println(tmpclen);
			
			int i99 = 0;
			
			int i9 = tmpclen;
			
			String[] goCity = new String[i9+1];
			
			ArrayList<Integer> goNeigs = new ArrayList<Integer>();
			
			int in = 41;
			
			int goNeig = 0;
			
			int whStop = 0;
			
			for(i99=0 ; i99<i9 ; i99++ ) {
				
				int tmpDist = 0;
				
				int lowDist = 999999;
				
				int hedefPlate = 0;
				
				int tmpP = 0;
				
				int Deletei = 0;
				
				for(i=0;i<tmpclen;i++) {
					//System.out.println((i+1) + ".=" + tmpC[i]);
				}
				
				for(i=0;i<tmpclen;i++) {
					
					tmpP = cityOp.findPlate(tmpC[i]);
					//System.out.println( tmpC[i] + " = " + tmpP);
					tmpDist = cityOp.go(tmpP , in);
					
					if(tmpDist<lowDist) {
						lowDist = tmpDist;
						
						hedefPlate = tmpP;
						
						Deletei = i;
						
						goCity[i99] = tmpC[i];
					}
					
					//System.out.println(tmpC[i] + " Uzaklýðý =" + tmpDist);
					
				}
				
				for(i=Deletei ; i<tmpclen ; i++) {
					tmpC[i] = tmpC[i+1];
				}
				
				tmpclen--;
				
				//System.out.println("Gidilecek þehir" + lowDist +"="+ hedefPlate);
				
				
				
				while(whStop == 0) {
					
					//System.out.println(in + "----------" + hedefPlate);
					goNeig = cityOp.neiGo(in, hedefPlate);
					
					System.out.println("girio");
					
					System.out.println("Gideceði komþu: " + goNeig);
					
					
					
					if(goNeig == 0) {
						break;
					}
					
					goNeigs.add(goNeig);
					
					in = goNeig;
					
				}
				
				
				in = hedefPlate;
				
				
				
				
				System.out.println("Kalan þehirler");
				
				if(tmpclen == 0) {
					System.out.println("--yok--");
				}
				
				//System.out.println("Sil=" + Deletei);
				
				for(i=0;i<tmpclen;i++) {
					//System.out.println((i+1) + ".=" + tmpC[i]);
				}
				
			}
			
			System.out.println("---------------");
			
			int hedefPlate = 41;
			
			while(whStop == 0) {
				
				System.out.println(in + "----------" + hedefPlate);
				goNeig = cityOp.neiGo(in, hedefPlate);
				
				System.out.println("girio");
				
				System.out.println("Gideceði komþu: " + goNeig);
				
				
				
				if(goNeig == 0) {
					break;
				}
				
				goNeigs.add(goNeig);
				
				in = goNeig;
				
			}
			
			goCity[i9] = "Kocaeli";
			int putPlate = 0;
			System.out.println("Sýrayla:");
			for(i=0 ; i<i9+1 ;i++) {
				System.out.println(" " + goCity[i]);
				putPlate = cityOp.findPlate(goCity[i]) ;
				goNeigs.add(putPlate);
				
			}
			
			System.out.println("komþular");
			
			for(i = 0 ; i<goNeigs.size() ; i++) {
				System.out.println(goNeigs.get(i));
			}
			
			ScScreen gg = new ScScreen();
			
			int tmpNPlate = 0;
			
			//KKAAAANN
			
			/*for( i=0 ; i<goNeigs.size() ; i++) {
				
				tmpNPlate == goNeigs.get(i);
				
				if(tmpNPlate == 1) {
					gg.btn1.setvisi
				}
				else if(tmpNPlate == 2) {
					gg.btn2.setvisi
				}
				
			}
			*/
			//System.out.println(tmpP);
			 
			//cityOp.go(tmpP);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Dosya mevcut deðil");
		}
		
		
	
	}
	
	public void readFile() {
		
	}
	
}

