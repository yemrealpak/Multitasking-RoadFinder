package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import linkedList.cityOperationClass;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
			
			
			
			//Start Project
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						StartScreen frame = new StartScreen();
						frame.setVisible(false);
						
			
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			//cityOp.printList();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Dosya mevcut deðil");
		}
		
	
		
		
	}


	public StartScreen() {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(257, 261, 273, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(257, 226, 273, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ye_al\\Desktop\\Git\\ProjectOne\\img2\\4lturkiye-siyasi-haritasi.png"));
		lblNewLabel.setBounds(-10, 0, 1264, 681);
		contentPane.add(lblNewLabel);
	}
}
