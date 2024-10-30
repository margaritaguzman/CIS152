
/**
 * 
 */
public class Patient {

	private int id;
	private String name;
	private String admissionDate;

	public Patient(int id, String name, String admissionDate) {
		this.id = id;
		this.name = name;
		this.admissionDate = admissionDate;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Patient ID: " + id + ", Name: " + name + ", Admission Date: " + admissionDate;
	}

}
