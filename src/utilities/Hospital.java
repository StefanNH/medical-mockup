package utilities;

public class Hospital {

	private int id;
	private String name;
	private double lat;
	private double lon;

	public Hospital(int id, String name, double lat, double lon) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", lat=" + lat + ", lon=" + lon + "]";
	}
}
