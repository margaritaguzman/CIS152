package model;

import java.util.PriorityQueue;

/**
 * Priority Queue works with AuthorizationRequest class to ensure objects are ordered by their priority.
 * 
 * @author Margarita Guzman
 * @version 1.0
 * @since 2024-11-06
 */
public class AuthorizationQueue {

	private PriorityQueue<AuthorizationRequest> queue = new PriorityQueue<>(); 

	// Add an authorization request to the queue
	public void addRequest(AuthorizationRequest request) {
		queue.add(request); // Adds the request to the queue, sorted by priority
	}

	// Process the next authorization request, prioritizing based on urgency
	public AuthorizationRequest processRequest() {
		return queue.poll(); // Retrieves and removes the highest-priority request from the queue
	}

	// Display the current authorization requests in the queue
	public String displayRequests() {
		if (queue.isEmpty()) {
	        return "No requests in the queue.";
	    }
	    StringBuilder builder = new StringBuilder("Authorization Queue:\n");
	    for (AuthorizationRequest request : queue) {
	        builder.append(request.toString()).append("\n");
	    }
	    return builder.toString();
	}
}
