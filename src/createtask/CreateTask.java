package createtask;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import org.apache.xml.utils.StringBufferPool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.StringArray;

import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class CreateTask implements ActionListener {

	private JFrame frame;
	private JTextField userIdField;
	private JPasswordField passwordField;
	private JTextArea ticketLog;
	ButtonGroup shiftRadioButtons;
	String userid;
	String password;
	String[] tickets;
	String baseUrl;
	WebDriver driver;
	Actions action;
	static String requestedFor = "Runal Prakash Bhandakkar";
	static String requestType = "Business Intelligence & Reporting";
	static String serviceCategory = "Supply Chain";
	static String serviceSubcategory = "Order Management";
	static String service = "Order Management";
	static String serviceArea = "Allocation (ARUN)";
	static String assignmentGroup = "TAS-FL-OM-L1";
	static String shortDescription;
	static String detailDescription;

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
		frame.setBounds(100, 100, 522, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		shiftRadioButtons = new ButtonGroup();

		JPanel shiftSelect = new JPanel();
		shiftSelect.setBounds(10, 83, 486, 61);
		frame.getContentPane().add(shiftSelect);
		shiftSelect.setLayout(null);

		JRadioButton fisrtShift = new JRadioButton("First Shift");
		fisrtShift.setBounds(6, 0, 84, 61);
		fisrtShift.setActionCommand("First Shift");
		shiftSelect.add(fisrtShift);

		JRadioButton secondShift = new JRadioButton("Second Shift");
		secondShift.setBounds(120, 0, 100, 61);
		shiftSelect.add(secondShift);

		JRadioButton thirdShift = new JRadioButton("Third Shift");
		thirdShift.setBounds(240, 0, 94, 61);
		shiftSelect.add(thirdShift);

		shiftRadioButtons.add(fisrtShift);
		shiftRadioButtons.add(secondShift);
		shiftRadioButtons.add(thirdShift);

		fisrtShift.addActionListener(this);
		secondShift.addActionListener(this);
		thirdShift.addActionListener(this);

		JPanel credentials = new JPanel();
		credentials.setBounds(10, 11, 486, 61);
		frame.getContentPane().add(credentials);
		credentials.setLayout(null);

		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(74, 11, 73, 14);
		credentials.add(lblUserId);

		userIdField = new JTextField();
		userIdField.setBounds(181, 8, 172, 21);
		credentials.add(userIdField);
		userIdField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 36, 73, 14);
		credentials.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(181, 33, 172, 21);
		credentials.add(passwordField);

		/*
		 * JPanel log = new JPanel(); log.setBorder(new
		 * EtchedBorder(EtchedBorder.RAISED, null, null));
		 * log.setForeground(Color.BLACK); log.setBounds(10, 155, 414, 95);
		 * frame.getContentPane().add(log); log.setLayout(null);
		 */

		ticketLog = new JTextArea();
		ticketLog.setBounds(0, 0, 414, 95);
		ticketLog.setEditable(false);
		ticketLog.setLineWrap(true);

		JScrollPane logScroll = new JScrollPane(ticketLog);
		logScroll.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		logScroll.setForeground(Color.BLACK);
		logScroll.setBounds(10, 155, 486, 95);
		frame.getContentPane().add(logScroll);

		JButton createTickets = new JButton("Create Tickets");
		createTickets.setBounds(340, 0, 124, 61);
		shiftSelect.add(createTickets);
		createTickets.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "First Shift":
			tickets = new String[] { "PRD Negative Rebalancing ( EMEA)", "EMEA Over Allocation and SO Rebalancing",
					"PRD EMEA plant material rebalancing report", "PRD PO Rebalancing (US)",
					"PRD Negative Rebalancing (1080/90/99)", "PRD PO Rebalancing (Americas)" ,"EMEA Critical Jobs Monitoring" };
			break;
		case "Second Shift":
			tickets = new String[] { "PRD LA Plant material rebalancing",
					"LA Region Over allocation and SO Rebalancing", "PRD US/Canada plant material rebalancing report",
					"PRD Negative Rebalancing (1004/14/51)", "NA Over allocation and SO rebalancing" ,"EMEA Critical Jobs Monitoring" };
			break;
		case "Third Shift":
			tickets = new String[] { "PRA Negative Rebalancing (Others)",
					"PRA  plant material rebalancing report (Oceania)", "Oceania over allocation and SO Rebalancing",
					"PRA Negative Rebalancing (1083)", "PRA Negative Rebalancing (1025)", "PRD PO Rebalancing (EMEA)",
					"Asia Over allocation and SO Rebalancing", "PRA  plant material rebalancing report","EMEA Critical Jobs Monitoring" };

			break;
		case "Create Tickets":
			 openUrl();
			 try {
				authenticate();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(tickets!= null){
				for (int i = 0; i < tickets.length; i++) {
					ticketLog.append("Creating ticket for " + tickets[i] + "...");
					if(tickets[i]=="EMEA Critical Jobs Monitoring"){
						requestType="Monitoring and Awareness";
						serviceCategory = "Supply Chain";
						serviceSubcategory = "Deliver";
						service = "Deliver";
						serviceArea = "Deliver Outbound";
						assignmentGroup = "TAS-FL-DL-L1";
					}
					try {
						createTickets(tickets[i]);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(tickets[i]);
					ticketLog.append("Done \n");
				}	
				ticketLog.append("All tasks created successfully. Please assign them to respective team members. Thank you!");
			}else{
				ticketLog.append("Please select the shift to create tickets \n");
			}
			break;
		default:
			break;
		}
	}

	private void openUrl() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		baseUrl = "https://niketech.service-now.com/";
		driver.get(baseUrl);
	}
	@SuppressWarnings("deprecation")
	private void authenticate() throws InterruptedException {
		// TODO Auto-generated method stub
		userid = userIdField.getText().toString();
		password = passwordField.getText().toString();
		System.out.println(userid + " " + password);
		driver.findElement(By.xpath("//input[1]")).sendKeys(userid);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("a.button:nth-child(4)")).click();
		Thread.sleep(500);
	}

	protected void createTickets(String ticketName) throws InterruptedException {
		// TODO Auto-generated method stub
		baseUrl = "https://niketech.service-now.com/nav_to.do?uri=%2Fcom.glideapp.servicecatalog_cat_item_view.do%3Fv%3D1%26sysparm_id%3Da9f4f4ce4f3912000b86ecee0210c7fe%26sysparm_link_parent%3Da21b4e604fd94a000b86ecee0210c79b%26sysparm_catalog%3De0d08b13c3330100c8b837659bba8fb4%26sysparm_catalog_view%3Dcatalog_default";
		driver.get(baseUrl);
		Thread.sleep(500);
		shortDescription = ticketName;
		detailDescription = ticketName;

		driver.switchTo().frame("gsft_main");
		System.out.println("Entered the frame...");
		driver.findElement(By.xpath("//input[@id='sys_display.IO:f24104220f71b1003306e64be1050ea1']"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"), requestedFor);// updating
																		// requested
																		// For
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:f24104220f71b1003306e64be1050ea1']"))
				.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Select select = new Select(driver.findElement(By.id("IO:d175b4ce4f3912000b86ecee0210c785")));
		select.selectByValue(requestType);// entering Request Type
		driver.findElement(By.xpath("//input[@id='sys_display.IO:8e3fc1801378f2c4f8c2b53a6144b009']"))
				.sendKeys(serviceCategory);// entering Service Category
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:8e3fc1801378f2c4f8c2b53a6144b009']"))
				.sendKeys(Keys.ENTER);// confirming Service Category
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:cfd455881378f2c4f8c2b53a6144b0ea']"))
				.sendKeys(serviceSubcategory);// entering serviceSubcategory
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:d015e21c133476c4f8c2b53a6144b02a']"))
				.sendKeys(service);// entering service
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:d015e21c133476c4f8c2b53a6144b02a']"))
				.sendKeys(Keys.ENTER);// confirming service
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:ef70d5041378f2c4f8c2b53a6144b0ba']"))
				.sendKeys(serviceArea);// entering Service Area
		driver.findElement(By.xpath("//input[@id='sys_display.IO:7bd7b4024f7912000b86ecee0210c782']"))
				.sendKeys(assignmentGroup);// entering assignment group
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:7bd7b4024f7912000b86ecee0210c782']"))
				.sendKeys(Keys.ENTER);// confirming assignment group selection
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='IO:e0a774024f7912000b86ecee0210c764']")).sendKeys(shortDescription);// updating
																														// RITM
																														// short
																														// description
		driver.findElement(By.xpath("//textarea[@id='IO:8dc774024f7912000b86ecee0210c73c']"))
				.sendKeys(detailDescription);// Updating RITM detailed
												// description
		driver.findElement(By.xpath("//input[@id='impacted_locations_cmn_location']")).sendKeys("Nike");// Selecting
																										// Nike
																										// as
																										// location
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(By.xpath("//select[@id='impacted_locations_select_0']/option[1]")))
				.perform();// Double click on location to update
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();// Click
																					// Order
																					// Item
																					// button
		Thread.sleep(600);
		driver.findElement(By.xpath("//a[text()[contains(.,'RITM')]]")).click();// clicking
																				// on
																				// RITM
																				// to
																				// get
																				// to
																				// Task
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()[contains(.,'TASK')]]")).click();// Opening
																				// the
																				// Task
																				// to
																				// update
																				// description
																				// and
																				// change
																				// state
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='sc_task.short_description']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				shortDescription);// Update Short Description
		Thread.sleep(300);
		driver.findElement(By.xpath("//textarea[@id='sc_task.description']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),
				detailDescription);// Update RITM Description
		Thread.sleep(300);
		Select taskState = new Select(driver.findElement(By.id("sc_task.state")));
		taskState.selectByValue("2");// setting task state to WIP
		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
	}
}