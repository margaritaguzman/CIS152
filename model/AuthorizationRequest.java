package model;

/**
 * Represents each admission and contains details about the admission, like the
 * date and treatment type.
 * 
 * @author Margarita Guzman
 * @version 1.2
 * @since 2024-11-18
 */
public class AuthorizationRequest implements Comparable<AuthorizationRequest> {

	private Patient patient;
	private int priority; // 1 = high priority, 2 = medium, 3 = low
	private Status status; // Status of the authorization request

	// Enum for status
	public enum Status {
		PENDING, APPROVED
	}

	public AuthorizationRequest(Patient patient, int priority) {
		this.patient = patient;
		this.priority = priority;
		this.status = Status.PENDING; // Default status is PENDING
	}

	// Getters and Setters
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// Overriding compareTo to compare based on priority
	@Override
	public int compareTo(AuthorizationRequest other) {
		return Integer.compare(this.priority, other.priority);
	}

	// Overriding toString to provide meaningful string representation
	@Override
	public String toString() {
		return "Patient Name: " + patient.getPatientName() + ", Patient ID: " + patient.getPatientId() + ", Priority: "
				+ priority + ", Status: " + status;
	}

	// Display Authorization Request details
	public void displayAuthorizationDetails() {
		System.out.println("Patient: " + patient.getPatientName() + " (ID: " + patient.getPatientId() + ")");
		System.out.println("Priority: " + priority + ", Status: " + status);
	}

	// Method to change status to approval
	public void approve() {
		this.status = Status.APPROVED;
	}


}
