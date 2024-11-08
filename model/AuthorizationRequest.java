package model;

/**
 * Represents each admission and contains details about the admission, like the
 * date and treatment type.
 * 
 * @author Margarita Guzman
 * @version 1.0
 * @since 2024-11-06
 */
public class AuthorizationRequest implements Comparable<AuthorizationRequest> {

	private Patient patient;
	private int priority; // 1 = high priority, 2 = medium, 3 = low

	public AuthorizationRequest(Patient patient, int priority) {
		this.patient = patient;
		this.priority = priority;
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

	// Overriding compareTo to compare based on priority
	@Override
	public int compareTo(AuthorizationRequest other) {
		return Integer.compare(this.priority, other.priority);
	}

	// Display Authorization Request details
	public void displayAuthorizationDetails() {
		System.out.println("Patient: " + patient.getPatientName() + " (ID: " + patient.getPatientId() + ")");
		System.out.println("Priority: " + priority);
	}

}
