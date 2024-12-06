package driver;

import javax.swing.*;

import model.Admission;
import model.AuthorizationQueue;
import model.AuthorizationRequest;
import model.BST;
import model.Patient;

import java.awt.*;
import java.awt.event.*;

/**
 * MainGUI provides a user interface for managing patient admissions and
 * authorization requests. It integrates with BST and AuthorizationQueue for
 * data storage and processing.
 * 
 * @author Margarita Guzman
 * @version 1.2
 * @since 2024-11-18
 */

public class MainGUI extends JFrame {

	// Declare components
	private JTextField patientIdField;
	private JTextField patientNameField;
	private JTextField patientDOBField;
	private JTextField admissionDateField;
	private JComboBox<String> treatmentTypeComboBox;
	private JComboBox<String> priorityComboBox;
	private JButton submitButton;
	private JButton displayQueueButton;
	private JButton processRequestButton;
	private JTextArea resultTextArea;

	// Data structures
	private BST bst; // Binary Search Tree for admissions
	private AuthorizationQueue authorizationQueue; // Priority queue for authorizations

	public MainGUI() {
		// Initialize data structures
		bst = new BST();
		authorizationQueue = new AuthorizationQueue();

		// Set up the window (JFrame)
		setTitle("Admission and Authorization System");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create panels and components
		JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		JPanel resultPanel = new JPanel(new BorderLayout());

		JLabel patientIdLabel = new JLabel("Patient ID:");
		JLabel patientNameLabel = new JLabel("Patient Name:");
		JLabel patientDOBLabel = new JLabel("Patient DOB: ");
		JLabel admissionDateLabel = new JLabel("Admission Date:");
		JLabel treatmentTypeLabel = new JLabel("Treatment Type:");
		JLabel priorityLabel = new JLabel("Priority:");

		patientIdField = new JTextField();
		patientNameField = new JTextField();
		patientDOBField = new JTextField();
		admissionDateField = new JTextField();
		treatmentTypeComboBox = new JComboBox<>(
				new String[] { "Emergency Care", "Trauma", "Cardiac", "Mental Health" });
		priorityComboBox = new JComboBox<>(new String[] { "High (1)", "Medium (2)", "Low (3)" });

		submitButton = new JButton("Submit Admission");
		displayQueueButton = new JButton("View Authorization Queue");
		processRequestButton = new JButton("Process Next Request");

		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);
		resultTextArea.setLineWrap(true);
		resultTextArea.setWrapStyleWord(true);
		JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
		resultScrollPane.setPreferredSize(new Dimension(300, 200));

		// Add components to panel
		inputPanel.add(patientIdLabel);
		inputPanel.add(patientIdField);
		inputPanel.add(patientNameLabel);
		inputPanel.add(patientNameField);
		inputPanel.add(patientDOBLabel);
		inputPanel.add(patientDOBField);
		inputPanel.add(admissionDateLabel);
		inputPanel.add(admissionDateField);
		inputPanel.add(treatmentTypeLabel);
		inputPanel.add(treatmentTypeComboBox);
		inputPanel.add(priorityLabel);
		inputPanel.add(priorityComboBox);
		inputPanel.add(submitButton);

		buttonPanel.add(displayQueueButton);
		buttonPanel.add(processRequestButton);

		resultPanel.add(new JLabel("Results:"), BorderLayout.NORTH);
		resultPanel.add(resultScrollPane, BorderLayout.CENTER);

		// Add panels to the JFrame
		setLayout(new BorderLayout(10, 10));
		add(inputPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);

		// Set up button actions
		setupActions();
	}

	private void setupActions() {
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSubmit();
			}
		});

		displayQueueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAuthorizationQueue();
			}
		});

		processRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNextAuthorizationRequest();
			}
		});
	}

	// Method to handle form submission
	private void handleSubmit() {
		// Get user input
		String patientId = patientIdField.getText();
		String patientName = patientNameField.getText();
		String patientDOB = patientDOBField.getText();
		String admissionDate = admissionDateField.getText();
		String treatmentType = (String) treatmentTypeComboBox.getSelectedItem();
		int priority = priorityComboBox.getSelectedIndex() + 1;

		// Validate inputs
		if (patientId.isEmpty() || patientName.isEmpty() || patientDOB.isEmpty() || admissionDate.isEmpty()) {
			resultTextArea.setText("Please fill in all fields.");
			return;
		}

		if (!patientDOB.matches("\\d{2}/\\d{2}/\\d{4}")) {
			resultTextArea.setText("Invalid Date of Birth format. Use MM/dd/yyyy.");
			return;
		}

		if (!admissionDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
			resultTextArea.setText("Invalid Date of admission format. Use MM/dd/yyyy.");
			return;
		}

		try {
			// Create Patient, Admission, and AuthorizationRequest objects
			Patient patient = new Patient(patientId, patientName, patientDOB);
			Admission admission = new Admission(patient, admissionDate, treatmentType);

			if (bst.insert(admission)) {
				AuthorizationRequest request = new AuthorizationRequest(patient, priority);
				authorizationQueue.addRequest(request);
				resultTextArea.setText(
						"Admission submitted for: " + patientName + " submitted with priority " + priority + ".");
			} else {
				resultTextArea.setText("Failed to insert admission. Duplicate patient");
			}
		} catch (Exception ex) {
			resultTextArea.setText("Error: " + ex.getMessage());
		}

	}

	private void displayAuthorizationQueue() {
		String queueDisplay = authorizationQueue.displayRequests();
		resultTextArea.setText(queueDisplay);
	}

	private void processNextAuthorizationRequest() {
		AuthorizationRequest request = authorizationQueue.processRequest();
		if (request != null) {
			request.approve(); // Simulate approval
			resultTextArea.setText("Processed request for " + request.getPatient().getPatientName() + " with status: "
					+ request.getStatus());
		} else {
			resultTextArea.setText("No requests to process.");
		}
	}

	public static void main(String[] args) {
		// Create and display the GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainGUI().setVisible(true);
			}
		});
	}
}
