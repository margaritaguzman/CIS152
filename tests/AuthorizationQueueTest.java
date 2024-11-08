package tests;

import model.AuthorizationQueue;
import model.AuthorizationRequest;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationQueueTest {

	@Test
	public void testAddRequest() {
		AuthorizationQueue queue = new AuthorizationQueue();
		Patient patient = new Patient("123", "John Doe", "1985-05-15");
		AuthorizationRequest request = new AuthorizationRequest(patient, 1);
		queue.addRequest(request);
		AuthorizationRequest processedRequest = queue.processRequest();
		assertNotNull(processedRequest);
		assertEquals("John Doe", processedRequest.getPatient().getPatientName());
	}

	@Test
	public void testProcessRequest() {
		AuthorizationQueue queue = new AuthorizationQueue();
		Patient patient1 = new Patient("123", "John Doe", "1985-05-15");
		Patient patient2 = new Patient("456", "Jane Doe", "1990-02-20");
		AuthorizationRequest request1 = new AuthorizationRequest(patient1, 1);
		AuthorizationRequest request2 = new AuthorizationRequest(patient2, 2);

		queue.addRequest(request1);
		queue.addRequest(request2);

		AuthorizationRequest processedRequest = queue.processRequest();
		assertEquals("John Doe", processedRequest.getPatient().getPatientName());
	}

	@Test
	public void testDisplayRequests() {
		AuthorizationQueue queue = new AuthorizationQueue();
		Patient patient1 = new Patient("123", "John Doe", "1985-05-15");
		AuthorizationRequest request1 = new AuthorizationRequest(patient1, 1);
		queue.addRequest(request1);

		// In a real test, we would mock or capture the output of displayRequests
		queue.displayRequests(); // Just for manual check of output
	}
}
