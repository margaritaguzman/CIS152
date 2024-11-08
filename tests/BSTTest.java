package tests;

import model.BST;
import model.Admission;
import model.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

	@Test
	public void testInsertAndInOrder() {
		BST bst = new BST();
		Patient patient1 = new Patient("123", "John Doe", "1985-05-15");
		Patient patient2 = new Patient("456", "Jane Doe", "1990-02-20");
		Admission admission1 = new Admission(patient1, "2024-11-06", "Emergency Care");
		Admission admission2 = new Admission(patient2, "2024-11-07", "General Checkup");

		bst.insert(admission1);
		bst.insert(admission2);

		// The in-order traversal method prints the admissions, so we'll manually check
		// the printed output.
		bst.inOrder(); // Manual check required for output (or capture output in more complex tests)
	}

	@Test
	public void testInsertUniqueAdmissions() {
		BST bst = new BST();
		Patient patient1 = new Patient("123", "John Doe", "1985-05-15");
		Patient patient2 = new Patient("456", "Jane Doe", "1990-02-20");
		Admission admission1 = new Admission(patient1, "2024-11-06", "Emergency Care");
		Admission admission2 = new Admission(patient2, "2024-11-07", "General Checkup");

		bst.insert(admission1);
		bst.insert(admission2);

		// In a more comprehensive test, you'd validate the order of insertions or the
		// structure of the tree.
		assertNotNull(bst); // Placeholder assertion, should validate tree structure or specific result
	}
}
