package tests;

import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

	@Test
	public void testPatientConstructor() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		assertEquals("123", patient.getPatientId());
		assertEquals("John Doe", patient.getPatientName());
		assertEquals("1985-05-15", patient.getPatientDOB());
	}

	@Test
	public void testSetPatientName() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		patient.setPatientName("Jane Doe");
		assertEquals("Jane Doe", patient.getPatientName());
	}
}
