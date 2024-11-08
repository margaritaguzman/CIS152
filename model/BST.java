package model;

/**
 * Used to manage patient admission records by patient ID.
 * 
 * @author Margarita Guzman
 * @version 1.0
 * @since 2024-11-06
 */
public class BST {
	private Node root;

	// Inner Node class
	private class Node {
		Admission admission;
		Node left, right;

		public Node(Admission admission) {
			this.admission = admission;
			left = right = null;
		}
	}

	// Insert an Admission into the BST
	public void insert(Admission admission) {
		root = insertRec(root, admission);
	}

	private Node insertRec(Node root, Admission admission) {
		if (root == null) {
			root = new Node(admission);
			return root;
		}

		// Assume admissions are ordered by the patient's ID for simplicity
		if (admission.getPatient().getPatientId().compareTo(root.admission.getPatient().getPatientId()) < 0) {
			root.left = insertRec(root.left, admission);
		} else if (admission.getPatient().getPatientId().compareTo(root.admission.getPatient().getPatientId()) > 0) {
			root.right = insertRec(root.right, admission);
		}

		return root;
	}

	// Method to display all Admissions (In-order traversal)
	public void inOrder() {
		inOrderRec(root);
	}

	private void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			root.admission.displayAdmissionDetails();
			inOrderRec(root.right);
		}
	}
}