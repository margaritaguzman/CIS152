package tests;

import model.BST;
import model.Admission;
import model.Patient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BSTTest {

	@Test
	public void testInsertAndInOrder() {
		BST bst = new BST();
		Patient patient1 = new Patient("123", "John Doe", "05-15-1985");
		Patient patient2 = new Patient("456", "Jane Doe", "02-20-1990");
		Admission admission1 = new Admission(patient1, "11-06-2024", "Emergency Care");
		Admission admission2 = new Admission(patient2, "11-07-2024", "General Checkup");

		bst.insert(admission1);
		bst.insert(admission2);
		
		assertTrue(bst.search("123"));
        assertTrue(bst.search("456"));

		bst.inOrder(); 
	}

	@Test
	public void testInsertUniqueAdmissions() {
		BST bst = new BST();
		Patient patient1 = new Patient("123", "John Doe", "05-15-1985");
		Patient patient2 = new Patient("456", "Jane Doe", "02-20-1990");
		Admission admission1 = new Admission(patient1, "11-06-2024", "Emergency Care");
		Admission admission2 = new Admission(patient2, "11-07-2024", "General Checkup");

		assertTrue(bst.insert(admission1));
        assertTrue(bst.insert(admission2));
        
        assertTrue(bst.search("123"));
        assertTrue(bst.search("456"));
	}
	
	@Test
	public void testInsertDuplicateAdmissions() {
		BST bst = new BST();
		Patient patient1 = new Patient("123", "John Doe", "05-15-1985");
		Patient patient2 = new Patient("123", "John Doe", "05-15-1985");
		Admission admission1 = new Admission(patient1, "11-06-2024", "Emergency Care");
		Admission admission2 = new Admission(patient2, "11-07-2024", "General Checkup");

		assertTrue(bst.insert(admission1)); // First insertion should succeed
        assertFalse(bst.insert(admission2)); // Second insertion should fail because it's a duplicate

        assertTrue(bst.search("123"));
	}
}
