package driver;

import javax.swing.*;

import model.Admission;
import model.AuthorizationQueue;
import model.BST;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 */

public class MainGUI extends JFrame {

    // Declare components
    private JTextField patientNameField;
    private JTextField patientIdField;
    private JTextField admissionDateField;
    private JComboBox<String> treatmentTypeComboBox;
    private JButton submitButton;
    private JTextArea resultTextArea;

    private BST bst;

    public MainGUI() {
        // Initialize the binary search tree (BST)
        bst = new BST();

        // Set up the window (JFrame)
        setTitle("Admission and Authorization System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panels and components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel patientNameLabel = new JLabel("Patient Name:");
        JLabel patientIdLabel = new JLabel("Patient ID:");
        JLabel admissionDateLabel = new JLabel("Admission Date:");
        JLabel treatmentTypeLabel = new JLabel("Treatment Type:");

        patientNameField = new JTextField();
        patientIdField = new JTextField();
        admissionDateField = new JTextField();
        treatmentTypeComboBox = new JComboBox<>(new String[] {"Emergency Care", "Trauma","Cardiac", "Mental Health"});
        submitButton = new JButton("Submit Admission");
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // Add components to panel
        panel.add(patientNameLabel);
        panel.add(patientNameField);
        panel.add(patientIdLabel);
        panel.add(patientIdField);
        panel.add(admissionDateLabel);
        panel.add(admissionDateField);
        panel.add(treatmentTypeLabel);
        panel.add(treatmentTypeComboBox);
        panel.add(submitButton);
        panel.add(resultTextArea);

        // Add the panel to the JFrame
        add(panel);

        // Set up action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    // Method to handle form submission
    private void handleSubmit() {
        // Get user input
        String patientName = patientNameField.getText();
        String patientId = patientIdField.getText();
        String admissionDate = admissionDateField.getText();
        String treatmentType = (String) treatmentTypeComboBox.getSelectedItem();

        // Validate inputs
        if (patientName.isEmpty() || patientId.isEmpty() || admissionDate.isEmpty()) {
            resultTextArea.setText("Please fill in all fields.");
            return;
        }

        // Create patient and admission objects
        Patient patient = new Patient(patientId, patientName, "DOB");
        Admission admission = new Admission(patient, admissionDate, treatmentType);

        // Add admission
        bst.insert(admission);

        // Display success message
        resultTextArea.setText("Admission for " + patientName + " has been submitted.");
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
