import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class PatientTest {

	@Test
	void testPatientCreation() {
		Patient patient = new Patient(1, "John Doe", "2024-10-30");
		assertEquals(1, patient.getId());
		assertEquals("John Doe", patient.getName());
	}

}

class BSTTest {
    @Test
    void testInsertAndSearch() {
        BST bst = new BST();
        Patient patient = new Patient(1, "Alice Smith", "2024-10-30");
        bst.insert(patient);
        assertNotNull(bst.search(1));
    }
}
