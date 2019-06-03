import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Jama.Matrix;

public class Test {
	private static final String FILENAME="data/locationData.txt";
	private static List<LocationData> originalLocationData=new ArrayList<LocationData>();
	
	private static LinkedList<LocationData> filterLocationData=new LinkedList<LocationData>();
	private static int windowSize=21;
	public static void main(String[] args) {
		readLocationDatas();
		SavitzkyGolay savitzkyGolay=new SavitzkyGolay();
		for(int i=0;i<originalLocationData.size();i++) {
			double[][] data=new double[windowSize][2];
			if(i<windowSize/2) {
				int j=0;
				for(;j<=i;j++) {
					data[j][0]=originalLocationData.get(j).lat;
					data[j][1]=originalLocationData.get(j).lng;
				}
				for(;j<windowSize;j++) {
					data[j][0]=originalLocationData.get(i).lat;
					data[j][1]=originalLocationData.get(i).lng;
				}
			}else if(i<originalLocationData.size()-windowSize/2) {
				int j=i-windowSize/2;
				for(;j<i;j++) {
					data[windowSize/2+j-i][0]=originalLocationData.get(j).lat;
					data[windowSize/2+j-i][1]=originalLocationData.get(j).lng;
				}
				for(j=i;j<=i+windowSize/2;j++) {
					data[windowSize/2+j-i][0]=originalLocationData.get(j).lat;
					data[windowSize/2+j-i][1]=originalLocationData.get(j).lng;
				}
			}else {
				int j=0;
				for(;j<originalLocationData.size()-i;j++) {
					data[j][0]=originalLocationData.get(originalLocationData.size()-1).lat;
					data[j][1]=originalLocationData.get(originalLocationData.size()-1).lng;
				}
				for(;j<windowSize;j++) {
					data[j][0]=originalLocationData.get(originalLocationData.size()-j).lat;
					data[j][1]=originalLocationData.get(originalLocationData.size()-j).lng;
				}
			}
			
			savitzkyGolay.predict(data, windowSize, 1);
		}
	}
	
	private static void readLocationDatas() {
		File dataFile=new File(FILENAME);
	    InputStream inputStream = null;
	    BufferedReader bufferedReader = null;
	   
	    
	    try {
			inputStream=new FileInputStream(dataFile);
			bufferedReader=new BufferedReader( new InputStreamReader(inputStream, "UTF-8"));
			String dataLineString;
			while((dataLineString=bufferedReader.readLine())!=null) {
					String []locaitonInfos=dataLineString.split(",");
					if(locaitonInfos.length==2) {
						double lat=Double.parseDouble(locaitonInfos[0]);
						double lng=Double.parseDouble(locaitonInfos[1]);
						LocationData locationData=new LocationData(lat,lng);
						originalLocationData.add(locationData);
					}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally {
			try {
				inputStream.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    
		
		
	}
	
	
}
