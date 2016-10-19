package com.zapcom.userreview.app.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zapcom.userreview.app.constants.AppConstants;

public class WebDriverIntgService {

	public static final Logger logger = LoggerFactory.getLogger(WebDriverIntgService.class);

	static {
		System.setProperty("webdriver.chrome.driver", AppConstants.CHROME_DRIVER_PATH);
	}

	public static void main(String[] args) {

		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			loginToTripAdvisor(driver);

			extractDataFromTripAdvisor(driver);

			// logoutFromTripAdvisor(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	public static synchronized void extractDataFromTripAdvisor(WebDriver driver) throws Exception {

		System.out.println("Started Extracting Data!\n");
		
		WebDriverWait wait0 = new WebDriverWait(driver, 15);
		wait0.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainSearch")));
		
		driver.findElement(By.id("mainSearch")).sendKeys("Vivanta by Taj - Holiday Village, Goa");
		waitForLoad(driver);

		driver.findElement(By.id("SEARCH_BUTTON")).click();
		waitForLoad(driver);

		Thread.sleep(10000);

	/*	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SEARCH_PAGE_HEAD")));*/

		
		WebElement resElement = driver
				.findElement(By.xpath("//*[@id='taplc_search_results_0']/div/div[1]/div[2]/div[2]"));
		String onClickScript = resElement.getAttribute("onClick");

		System.out.println("html path scraped is : "
				+ onClickScript.substring(onClickScript.lastIndexOf("'/") + 2, onClickScript.lastIndexOf("')")));

		driver.get(AppConstants.TRIP_ADVISOR_BASE_URL
				+ onClickScript.substring(onClickScript.lastIndexOf("'/") + 2, onClickScript.lastIndexOf("')")));

		waitForLoad(driver);

		Thread.sleep(5000);

		/*System.out.println("Rating is : " + driver
				.findElement(By.xpath("//*[@id='HEADING_GROUP']/div/div[2]/div[1]/div/span/img")).getAttribute("alt"));
		System.out.println("Number of reviews are : "
				+ driver.findElement(By.xpath("//*[@id='HEADING_GROUP']/div/div[2]/div[1]/div/a")).getText());
		System.out.println("Rank is : "
				+ driver.findElement(By.xpath("//*[@id='HEADING_GROUP']/div/div[2]/div[2]/div")).getText());
		System.out
				.println(
						"Contact nuumber is : " + driver
								.findElement(By
										.xpath("//*[@id='HEADING_GROUP']/div/div[3]/address/div/div[1]/div[1]/div[1]/div[2]"))
								.getText());
		System.out.println("Address is : " + driver
				.findElement(By.xpath("//*[@id='HEADING_GROUP']/div/div[3]/address/div/div[1]/div[2]")).getText());
		System.out.println("Expedia rating is : "
				+ driver.findElement(By.xpath("//*[@id='taplc_prodp13n_hr_tags_0']/div/div/span/span/span/img"))
						.getAttribute("alt"));

		List<WebElement> facilitiesLinks = driver
				.findElements(By.xpath("//*[@id='taplc_prodp13n_hr_tags_0']/div/div/div/a"));
		System.out.print("Facilities are : ");
		facilitiesLinks.forEach(link -> System.out.print(link.getText() + " "));

		System.out.println("Reviewer name is : "
				+ driver.findElement(By.xpath("//*[@id='UID_1360D920C33CFB09A5865FDB32DC5AF7-SRC_337502116']/div[2]"))
						.getText());
		System.out.println("Reviewer location is : "
				+ driver.findElement(By.xpath("//*[@id='review_337502116']/div/div[1]/div[1]/div[2]")).getText());
		System.out.println("Reviewer's total number of reviews are : " + driver
				.findElement(By.xpath("//*[@id='UID_1360D920C33CFB09A5865FDB32DC5AF7-CONT']/div[2]/span")).getText());*/

		/*System.out.println(
				"Review's heading is : " + driver.findElement(By.xpath("//*[@id='rn338069627']/span")).getText());
		System.out.println("Reviewer's rating is : "
				+ driver.findElement(By.xpath("//*[@id='review_338069627']/div/div[2]/div/div/div[2]/span[1]/img"))
						.getAttribute("alt"));
		System.out.println("Review's date is : "
				+ driver.findElement(By.xpath("//*[@id='review_338069627']/div/div[2]/div/div/div[2]/span[2]"))
						.getAttribute("title"));*/
		System.out.println("Complete review is : "
				+ driver.findElement(By.xpath("//*[@id='review_338069627']/div/div[2]/div/div/div[3]/p")).getText());

		//*[@id="review_337502116"]/div/div[2]/div/div/div[3]/p/span/span
		
		
		/*WebElement moreElement = driver.findElement(By.xpath("//*[@id='review_337502116']/div[1]/div[2]/div/div/div[3]/p/span/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(moreElement).click().perform();
		
		// driver.findElement(By.xpath("//*[@id='review_337502116']/div[1]/div[2]/div/div/div[3]/p/span/span")).click();
		waitForLoad(driver);

		Thread.sleep(10000);

		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("UR337502116")));*/

		/*System.out.println("Complete review is : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[3]")).getText());
		System.out.println("Duration of Stay is : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/span")).getText());
		System.out.println("Rated type1 : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[1]/li")).getText());
		System.out.println("Rating for type1 is : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[1]/li/span/img"))
						.getAttribute("alt"));
		System.out.println("Rated type2 : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[2]/li[1]")).getText());
		System.out.println("Rating for type2 is : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[2]/li[1]/span/img"))
						.getAttribute("alt"));
		System.out.println("Rated type3 : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[2]/li[2]")).getText());
		System.out.println("Rating for type3 is : "
				+ driver.findElement(By.xpath("//*[@id='UR337502116']/div[2]/div/div[4]/ul/li/ul[2]/li[2]/span/img"))
						.getAttribute("alt"));*/

		Thread.sleep(5000);

		System.out.println("\nCompleted Extraction of Data!");
	}

	private static synchronized void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	private static void loginToTripAdvisor(WebDriver driver) throws InterruptedException {
		driver.get(AppConstants.TRIP_ADVISOR_BASE_URL);
		waitForLoad(driver);

		WebDriverWait wait0 = new WebDriverWait(driver, 15);
		wait0.until(ExpectedConditions.visibilityOfElementLocated(By.id("USER_PREFS")));

		driver.findElement(By.xpath("//*[@id='USER_PREFS']/ul/li[2]")).click();
		waitForLoad(driver);

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		driver.findElement(By.id("email")).sendKeys("dheerajbhoomireddy@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("dheeraj@1");
		driver.findElement(By.xpath("//*[@id='MemberSignIn']/div[4]/div/input")).click();
		waitForLoad(driver);

		System.out.println("Successfully Logged In!");
	}

	private static void logoutFromTripAdvisor(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='USER_PREFS']/ul/li[1]/span[2]/img")).click();
		waitForLoad(driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("SIGNOUT_LINK")).click();
		waitForLoad(driver);

		System.out.println("Successfully Logged Out!");

	}

}
