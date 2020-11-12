package utilities;

public class Patient {

	private int id;
	private String name;
	private String address;
	private String diagnosis;

	// default constructor
	public Patient() {
	}

	// consturctor with fields
	public Patient(int id, String name, String address, String diagnosis) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.diagnosis = diagnosis;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", diagnosis=" + diagnosis + "]";
	}

}
