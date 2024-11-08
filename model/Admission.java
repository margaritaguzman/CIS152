package model;

/**
 * Represents each admission and contains details about the admission, like the
 * date and treatment type.
 * 
 * @author Margarita Guzman
 * @version 1.0
 * @since 2024-11-06
 */
public class Admission {
	private Patient patient; // Composition: An Admission has a Patient
	private String admissionDate;
	private String treatmentType;
	private String admissionStatus;

	// Constructor
	public Admission(Patient patient, String admissionDate, String treatmentType) {
		this.patient = patient; // Store the patient object
		this.admissionDate = admissionDate;
		this.treatmentType = treatmentType;
		this.admissionStatus = "Pending"; // Default status
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

	public String getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	// Display method for Admission details
	public void displayAdmissionDetails() {
		System.out.println("Admission Date: " + admissionDate);
		System.out.println("Treatment Type: " + treatmentType);
		System.out.println("Admission Status: " + admissionStatus);
		patient.displayPatientDetails(); // Display patient details as part of admission
	}

}
