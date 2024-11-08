package tests;

import model.AuthorizationRequest;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationRequestTest {

	@Test
	public void testAuthorizationRequestConstructor() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		AuthorizationRequest request = new AuthorizationRequest(patient, 1);
		assertEquals("123", request.getPatient().getPatientId());
		assertEquals(1, request.getPriority());
	}

	@Test
	public void testSetPriority() {
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		AuthorizationRequest request = new AuthorizationRequest(patient, 1);
		request.setPriority(2);
		assertEquals(2, request.getPriority());
	}

	@Test
	public void testCompareTo() {
		Patient patient1 = new Patient("123", "John Doe", "1985-05-15");
		Patient patient2 = new Patient("456", "Jane Doe", "1990-02-20");
		AuthorizationRequest request1 = new AuthorizationRequest(patient1, 1);
		AuthorizationRequest request2 = new AuthorizationRequest(patient2, 2);
		assertTrue(request1.compareTo(request2) < 0);
	}
}
