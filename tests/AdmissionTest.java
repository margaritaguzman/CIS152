package tests;

import model.Admission;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdmissionTest {

	@Test
	public void testAdmissionConstructor() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		Admission admission = new Admission(patient, "2024-11-06", "Emergency Care");
		assertEquals("2024-11-06", admission.getAdmissionDate());
		assertEquals("Emergency Care", admission.getTreatmentType());
		assertEquals("Pending", admission.getAdmissionStatus());
	}

	@Test
	public void testSetAdmissionStatus() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		Admission admission = new Admission(patient, "2024-11-06", "Emergency Care");
		admission.setAdmissionStatus("Approved");
		assertEquals("Approved", admission.getAdmissionStatus());
	}
}
