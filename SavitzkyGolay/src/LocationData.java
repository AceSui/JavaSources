

public class LocationData {
	double lat,lng;
	
	public LocationData(double lat,double lng) {
		this.lat=lat;
		this.lng=lng;
	}
	
	public LocationData(LocationData locationData) {
		this.lat=locationData.lat;
		this.lng=locationData.lng;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public double getLat() {
		return lat;
	}
	public double getLng() {
		return lng;
	}
	

	@Override
	public String toString() {
		return "LocationData [lat=" + lat + ", lng=" + lng+"]";
	}
	
	
}
