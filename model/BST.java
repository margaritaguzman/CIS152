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

	// Search for a patient ID in the BST
	public boolean search(String patientId) {
		return searchRec(root, patientId) != null;
	}
	

	private Node searchRec(Node root, String patientId) {
		if (root == null) {
			return null;
		}

		if (root.admission.getPatient().getPatientId().equals(patientId)) {
			return root; // Found the patient ID
		}

		if (patientId.compareTo(root.admission.getPatient().getPatientId()) < 0) {
			return searchRec(root.left, patientId);
		} else {
			return searchRec(root.right, patientId);
		}
	}

	// Insert an Admission into the BST
	public boolean insert(Admission admission) {
		if (search(admission.getPatient().getPatientId())) {
            return false; // Prevent insertion if patient ID already exists
        }

        root = insertRec(root, admission);
        return true;
    }

	private Node insertRec(Node root, Admission admission) {
		if (root == null) {
			root = new Node(admission);
			return root;
		}

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
