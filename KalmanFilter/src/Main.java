import java.util.ArrayList;

public class Main {
	private static KalmanFilter kalmanFilter= new KalmanFilter();

	public static void main(String[] args) {
		kalmanFilter.initial();
		kalmanFilter.setTimes(1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(0.0);
		list.add(3.1);
		list.add(6.0);
		list.add(7.0);
		list.add(3.0);
		list.add(2.0);
		list.add(0.0);
		list.add(0.0);
		list.add(5.0);
		list.add(0.0);
		double oldvalue = list.get(0);
		ArrayList<Double> alist = new ArrayList<Double>();
		for(int i = 0; i < list.size(); i++){
			double value = list.get(i);
			oldvalue = kalmanFilter.predic(oldvalue,value);
			alist.add(oldvalue);
		}
		
		System.out.println(list);
		System.out.println(alist);

	}
}
