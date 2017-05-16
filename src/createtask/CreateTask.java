package createtask;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButtonMenuItem;

public class CreateTask {

	private JFrame frame;
	private JTextField userIdField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTask window = new CreateTask();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateTask() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ButtonGroup shiftRadioButtons = new ButtonGroup();
		
		JPanel shiftSelect = new JPanel();
		shiftSelect.setBounds(10, 83, 414, 61);
		frame.getContentPane().add(shiftSelect);
		shiftSelect.setLayout(null);
		
		JRadioButton fisrtShift = new JRadioButton("First Shift");
		fisrtShift.setBounds(1, 0, 84, 61);
		shiftSelect.add(fisrtShift);
		
		JRadioButton secondShift = new JRadioButton("Second Shift");
		secondShift.setBounds(87, 0, 100, 61);
		shiftSelect.add(secondShift);
		
		JRadioButton thirdShift = new JRadioButton("Third Shift");
		thirdShift.setBounds(189, 0, 94, 61);
		shiftSelect.add(thirdShift);
		
		JButton createTickets = new JButton("Create Tickets");
		createTickets.setBounds(289, 0, 124, 61);
		shiftSelect.add(createTickets);
		
		shiftRadioButtons.add(fisrtShift);
		shiftRadioButtons.add(secondShift);
		shiftRadioButtons.add(thirdShift);
		
		JPanel credentials = new JPanel();
		credentials.setBounds(10, 11, 414, 61);
		frame.getContentPane().add(credentials);
		credentials.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(45, 11, 73, 14);
		credentials.add(lblUserId);
		
		userIdField = new JTextField();
		userIdField.setBounds(128, 8, 172, 21);
		credentials.add(userIdField);
		userIdField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 36, 73, 14);
		credentials.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 33, 172, 21);
		credentials.add(passwordField);
		
		JPanel log = new JPanel();
		log.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		log.setForeground(Color.BLACK);
		log.setBounds(10, 155, 414, 95);
		frame.getContentPane().add(log);
		log.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(397, 0, 17, 95);
		log.add(scrollBar);
		
		JTextArea ticketLog = new JTextArea();
		ticketLog.setBounds(0, 0, 414, 95);
		log.add(ticketLog);
	}
}
