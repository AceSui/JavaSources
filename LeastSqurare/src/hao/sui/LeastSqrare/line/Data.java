package hao.sui.LeastSqrare.line;


public class Data {
	double x,y;
	
	public Data(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public Data(Data locationData) {
		this.x=locationData.x;
		this.y=locationData.y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + "]";
	}
	
	
}
