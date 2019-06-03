package hao.sui.LeastSqrare.line;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
	private static LinkedList<Data> predicDatas=new LinkedList<Data>();
	public static void main(String[] args) {
		predicDatas.add(new Data(1.2,1.5));
		predicDatas.add(new Data(2.4,2.2));
		predicDatas.add(new Data(6.4,8.7));
		predicDatas.add(new Data(3.2,4.3));
		predicDatas.add(new Data(5.9,7));
		double[] params=getLine();
		if(params[1]>=0) {
			System.out.println("y="+params[0]+"*x"+"+"+params[1]);

		}else {
			System.out.println("y="+params[0]+"*x"+params[1]);
		}
	}
	
	private static double[] getLine() {
		double k=0;
		double b=0;
		if(predicDatas.size()>=2) {
			double sumLat=0;
			double sumLng=0;
			double aveLat=0,aveLng=0;
			for(int i=0;i<predicDatas.size();i++) {
				sumLat+=predicDatas.get(i).x;
				sumLng+=predicDatas.get(i).y;
			}
			aveLat=sumLat/predicDatas.size();
			aveLng=sumLng/predicDatas.size();
			
			for(int i=0;i<predicDatas.size();i++) {
				k+=(predicDatas.get(i).x*predicDatas.get(i).y);
			}
			k/=predicDatas.size();
			k-=aveLat*aveLng;
			double denominator=0;
			for(int i=0;i<predicDatas.size();i++) {
				denominator+=(predicDatas.get(i).x*predicDatas.get(i).x);
			}
			denominator/=predicDatas.size();

			denominator-=(aveLat*aveLat);
			k=k/denominator;
			b=aveLng-k*aveLat;
//			System.out.println(k+" "+b);
			if(Double.isInfinite(k)) {
				k=Double.MAX_VALUE;
			}
			
		}
		
		return new double[] {k,b};
	}
}
