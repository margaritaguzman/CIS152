package model;

/**
 * Handles patient-specific details
 * 
 * @author Margarita Guzman
 * @version 1.0
 * @since 2024-11-06
 */
public class Patient {

	private String patientId;
    private String patientName;
    private String patientDOB;

    public Patient(String patientId, String patientName, String patientDOB) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientDOB = patientDOB;
    }

 // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient DOB: " + patientDOB);
    }

}
