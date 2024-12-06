package tests;

import model.Admission;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdmissionTest {

	@Test
	public void testAdmissionConstructor() {
		Patient patient = new Patient("123", "John Doe", "05-15-1985");
		Admission admission = new Admission(patient, "11-06-2024", "Emergency Care");
		assertEquals("11-06-2024", admission.getAdmissionDate());
		assertEquals("Emergency Care", admission.getTreatmentType());
		assertEquals(Admission.Status.PENDING, admission.getStatus());
	}

	@Test
	public void testSetAdmissionStatus() {
		Patient patient = new Patient("123", "John Doe", "05-15-1985");
		Admission admission = new Admission(patient, "11-06-2024" , "Emergency Care");
		admission.setStatus(Admission.Status.APPROVED);
		assertEquals(Admission.Status.APPROVED, admission.getStatus());
	}
}
