
/**
 * 
 */
public class AuthorizationRequest implements Comparable<AuthorizationRequest> {

	private Patient patient;
	private int priority; // 1 = high priority, 2 = medium, 3 = low

	public AuthorizationRequest(Patient patient, int priority) {
		this.patient = patient;
		this.priority = priority;
	}

	@Override
	public int compareTo(AuthorizationRequest other) {
		return Integer.compare(this.priority, other.priority);
	}

}
