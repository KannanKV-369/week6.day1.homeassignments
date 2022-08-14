package week6.day1.homeassignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	/*http://leaftaps.com/opentaps/control/main

	 * 1	Launch the browser
	 * 2	Enter the username
	 * 3	Enter the password
	 * 4	Click Login
	 * 5	Click crm/sfa link
	 * 6	Click Leads link
	 * 7	Click Find leads
	 * 8	Enter first name
	 * 9	Click Find leads button
	 * 10 Click on first resulting lead
	 * 11 Verify title of the page
	 * 12 Click Edit
	 * 13 Change the company name
	 * 14 Click Update
	 * 15 Confirm the changed name appears
	 * 16 Close the browser (Do not log out)
	 */

	@Test
	public void editLead() {
		//Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		// 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		// 8	Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-item x-tab-item']//input)[2]")).sendKeys("Kannan");
		// 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// 10 Click on first resulting lead
		driver.findElement(By.xpath("(//a[text()='Kannan'])[1]")).click();
		// 11 Verify title of the page
		String title = driver.getTitle();
		//String expectedtitle = "View Lead";
		if(title.contains("View Lead"))
		System.out.println("The page is verified");
		else
			System.out.println("Wrong Page");
		// 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Amazon");
		// 14 Click Update
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		// 15 Confirm the changed name appears
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text);
		if(text.contains("Amazon"))
			System.out.println("The changed name is correct: " +text);
		else
			System.out.println("Wrong");
	}
}
