package model;

/**
 * Represents each admission and contains details about the admission, like the
 * date and treatment type.
 * 
 * @author Margarita Guzman
 * @version 1.2
 * @since 2024-11-18
 */
public class Admission {
	private Patient patient;
	private String admissionDate;
	private String treatmentType;
	private Status status;

	public enum Status {
		PENDING, APPROVED
	}

	// Constructor
	public Admission(Patient patient, String admissionDate, String treatmentType) {
		this.patient = patient; // Store the patient object
		this.admissionDate = admissionDate;
		this.treatmentType = treatmentType;
		this.status = Status.PENDING; // Default status
	}

	// Getters and Setters
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// Display method for Admission details
	public void displayAdmissionDetails() {
		System.out.println("Admission Date: " + admissionDate);
		System.out.println("Treatment Type: " + treatmentType);
		System.out.println("Admission Status: " + status);
		patient.displayPatientDetails();
	}

}
