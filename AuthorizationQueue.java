import java.util.PriorityQueue;

/**
 *
 */
public class AuthorizationQueue {
	
	private PriorityQueue<AuthorizationRequest> queue = new PriorityQueue<>();

	public void addRequest(AuthorizationRequest request) {
		queue.add(request);
	}

	public AuthorizationRequest processRequest() {
		return queue.poll();
	}
}
