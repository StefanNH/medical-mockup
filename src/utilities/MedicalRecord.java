package utilities;

public class MedicalRecord {

	private int id;
	private int patient_id;
	private String diagnosis;
	private String treatment;
	private String location;
	private String time_details;

	public MedicalRecord() {
	}

	public MedicalRecord(int id, int patient_id, String diagnosis, String treatment, String location,
			String time_details) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.location = location;
		this.time_details = time_details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime_details() {
		return time_details;
	}

	public void setTime_details(String time_details) {
		this.time_details = time_details;
	}

	@Override
	public String toString() {
		return "id: " + id + ", patient_id: " + patient_id + ", diagnosis: " + diagnosis + ", treatment: "
				+ treatment + ", location: " + location + ", time_details: " + time_details;
	}

}
