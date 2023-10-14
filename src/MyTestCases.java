import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	String theWebsite ="https://magento.softwaretestingboard.com/";
	String SignInPage="https://magento.softwaretestingboard.com/customer/account/login";
	String LogOut="https://magento.softwaretestingboard.com/customer/account/logout";
	WebDriver driver= new ChromeDriver();
    Random rand = new Random();

	String[] FName= {"Shomoa","Abdullah","Hussain","Maysoon","Rahhal"};
	String[] LName= {"Mohammad","Abdullah","Hussain","Rashed","Rahhal"};
	int i =rand.nextInt(0,5);
	
	String password="Sh123/*-";
    String BeginingOfEmail="Useri";
    String EndOfEmail="@gmail.com";
    
	int indexMiddleofEmail = rand.nextInt(0, 100);
	
	String TheLoginEmail;
	
@BeforeTest
public void MyBeforeTest() {
	 driver.get(theWebsite);
	   driver.manage().window().maximize();
}

@Test(description = "Test # 1", priority = 1)
public void SignUpWithRandomlyEmails() {
	WebElement CreatAccountButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
	CreatAccountButton.click();
	
	WebElement FNameInput = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
	FNameInput.sendKeys(FName[i]);
	
	WebElement LNameInput = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
	LNameInput.sendKeys(LName[i]);
//because u can't sign up with the same email so u must enter random different email
	WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
	Email.sendKeys(BeginingOfEmail+indexMiddleofEmail+EndOfEmail);
	TheLoginEmail = BeginingOfEmail+indexMiddleofEmail+EndOfEmail;
	WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	Password1.sendKeys(password);

	WebElement ConfirmPassword1 = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
	ConfirmPassword1.sendKeys(password);
	
	WebElement Submit = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
	Submit.click();
	
	driver.get(LogOut);

}

@Test(description = "Test # 2", priority = 2)
public void SignIn() throws InterruptedException {
    driver.get(SignInPage);
    	Thread.sleep(100);

	WebElement LoginEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	LoginEmail.sendKeys(TheLoginEmail);
	
	WebElement LoginPass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
	LoginPass.sendKeys(password);
	
	WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
	SignIn.click();
}



}
