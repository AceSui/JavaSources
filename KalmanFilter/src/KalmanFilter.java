
public class KalmanFilter {
	private double predicError = 4, measureError = 3;

	private int times = 1;

	public void initial() {
		predicError = 4;
		measureError = 3;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}

	public double predic(double oldValue, double currentValue) {
		double result = oldValue;
		for (int i = 0; i < times; i++) {
			double gauss = Math.sqrt(predicError * predicError + measureError * measureError);
			double delta = currentValue - oldValue;
			double gain = Math.sqrt((gauss * gauss) / (gauss * gauss + predicError * predicError));
			result = oldValue + gain * delta;
			measureError =currentValue-result;

			currentValue = result;
		}
		return result;
	}
}