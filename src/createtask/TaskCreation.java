package createtask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TaskCreation {
	static String baseUrl;
	static String shortDescription = "Dummy Task updated by vijay";
	static String detailDescription = "Dummy Task deatial description updated by vijay";
	static String assignmentGroup = "TAS-FL-OM-L1";
	static String serviceArea = "Allocation (ARUN)";
	static String service = "Order Management";
	static String serviceSubcategory = "Order Management";
	static String serviceCategory = "Supply Chain";
	static String requestType = "Business Intelligence & Reporting";
	static String requestedFor = "Runal Prakash Bhandakkar";
	static String userName = "msai";
	static String password = "Nexus@1234";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		// baseUrl =
		// "https://niketech.service-now.com/com.glideapp.servicecatalog_cat_item_view.do?v=1&sysparm_id=a9f4f4ce4f3912000b86ecee0210c7fe&sysparm_link_parent=a21b4e604fd94a000b86ecee0210c79b&sysparm_catalog=e0d08b13c3330100c8b837659bba8fb4&sysparm_catalog_view=catalog_default";
		baseUrl = "https://niketech.service-now.com/nav_to.do?uri=%2Fcom.glideapp.servicecatalog_cat_item_view.do%3Fv%3D1%26sysparm_id%3Da9f4f4ce4f3912000b86ecee0210c7fe%26sysparm_link_parent%3Da21b4e604fd94a000b86ecee0210c79b%26sysparm_catalog%3De0d08b13c3330100c8b837659bba8fb4%26sysparm_catalog_view%3Dcatalog_default";
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[1]")).sendKeys("msai");
		driver.findElement(By.cssSelector("#password")).sendKeys("Nexus@1234");
		driver.findElement(By.cssSelector("a.button:nth-child(4)")).click();
		Thread.sleep(500);
		driver.switchTo().frame("gsft_main");
		System.out.println("Entered the frame...");
		driver.findElement(By.xpath("//input[@id='sys_display.IO:f24104220f71b1003306e64be1050ea1']"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"), requestedFor);// updating
																		// requested
																		// For
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:d015e21c133476c4f8c2b53a6144b02a']"))
				.sendKeys(service);// entering service
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:d015e21c133476c4f8c2b53a6144b02a']"))
				.sendKeys(Keys.ENTER);// confirming service
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:ef70d5041378f2c4f8c2b53a6144b0ba']"))
				.sendKeys(serviceArea);// entering Service Area
		driver.findElement(By.xpath("//input[@id='sys_display.IO:7bd7b4024f7912000b86ecee0210c782']"))
				.sendKeys(assignmentGroup);// entering assignment group
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='sys_display.IO:7bd7b4024f7912000b86ecee0210c782']"))
				.sendKeys(Keys.ENTER);// confirming assignement group selection
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

