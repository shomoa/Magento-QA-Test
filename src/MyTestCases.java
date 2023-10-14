import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	String theWebsite ="https://magento.softwaretestingboard.com/";
	String SignInPage="https://magento.softwaretestingboard.com/customer/account/login";
	String LogOut="https://magento.softwaretestingboard.com/customer/account/logout";
	String CheckOut ="https://magento.softwaretestingboard.com/checkout";
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
    	Thread.sleep(1000); //1 second

	WebElement LoginEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	LoginEmail.sendKeys(TheLoginEmail);
	
	WebElement LoginPass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
	LoginPass.sendKeys(password);
	
	WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
	SignIn.click();
}

@Test(description = "Test # 3", priority = 3)
public void Add_To_Cart() throws InterruptedException {
   String [] itemspages = {"https://magento.softwaretestingboard.com/radiant-tee.html",
	"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
	"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
	"https://magento.softwaretestingboard.com/hero-hoodie.html",
	"https://magento.softwaretestingboard.com/fusion-backpack.html"};

   for(int i=0;i<itemspages.length;i++) {
	   driver.get(itemspages[i]);

      Thread.sleep(5000);
      
      if(driver.getCurrentUrl().contains("radiant")) {
    	  
      WebElement DivSizeBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
      List <WebElement> Sizes= DivSizeBox.findElements(By.tagName("div")); //each div size locate in one div box
	 int indexSize = rand.nextInt(0, Sizes.size());
	 Sizes.get(indexSize).click();	
	 
      
	 WebElement DivColorBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
     List <WebElement> Colors= DivColorBox.findElements(By.tagName("div")); //each div color locate in one div box
	 int indexColor = rand.nextInt(0, Colors.size());
	 Colors.get(indexColor).click();	
	 
	 WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
	 Quantity.clear();
	 Quantity.sendKeys("3");
	 

		WebElement Addbutton= driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Addbutton.click();
      }
	 
      else if(driver.getCurrentUrl().contains("breathe")) {
    	  
      WebElement DivSizeBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
      List <WebElement> Sizes= DivSizeBox.findElements(By.tagName("div")); //each div size locate in one div box
	 int indexSize = rand.nextInt(0, Sizes.size());
	 Sizes.get(indexSize).click();	
	 
      
	 WebElement DivColorBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
     List <WebElement> Colors= DivColorBox.findElements(By.tagName("div")); //each div color locate in one div box
	 int indexColor = rand.nextInt(0, Colors.size());
	 Colors.get(indexColor).click();	
	 
	 WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
	 Quantity.clear();
	 Quantity.sendKeys("2");
	 
	 WebElement Addbutton= driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Addbutton.click();
      }
      else if(driver.getCurrentUrl().contains("argus")) {
    	  
      WebElement DivSizeBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
      List <WebElement> Sizes= DivSizeBox.findElements(By.tagName("div")); //each div size locate in one div box
	 int indexSize = rand.nextInt(0, Sizes.size());
	 Sizes.get(indexSize).click();	
	 
      
	 WebElement DivColorBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
     List <WebElement> Colors= DivColorBox.findElements(By.tagName("div")); //each div color locate in one div box
	 int indexColor = rand.nextInt(0, Colors.size());
	 Colors.get(indexColor).click();	
	 
	 WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
	 Quantity.clear();
	 Quantity.sendKeys("4");
	 
	 WebElement Addbutton= driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Addbutton.click();
      }
      
      if(driver.getCurrentUrl().contains("hoodie")) {
    	  
      WebElement DivSizeBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
      List <WebElement> Sizes= DivSizeBox.findElements(By.tagName("div")); //each div size locate in one div box
	 int indexSize = rand.nextInt(0, Sizes.size());
	 Sizes.get(indexSize).click();	
	 
      
	 WebElement DivColorBox =driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
     List <WebElement> Colors= DivColorBox.findElements(By.tagName("div")); //each div color locate in one div box
	 int indexColor = rand.nextInt(0, Colors.size());
	 Colors.get(indexColor).click();	
	 
	 //Quantity 1 it's set to 1 by default
	 
	 WebElement Addbutton= driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Addbutton.click();
      }
      
      if(driver.getCurrentUrl().contains("backpack")) {
    	  WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
    		 Quantity.clear();
    		 Quantity.sendKeys("5");
    		 
    		 WebElement Addbutton= driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
    			Addbutton.click();
      }
	 
   }
   }
  @Test(description = "Test #4", priority=4)
  public void CheckOutToProceed() {
	  //First Way but u need to wait some time the further way go to link no much time needed
//	    WebElement Basket= driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
//		Basket.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		WebElement ProceedToCheckout= driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
//		ProceedToCheckout.click();
      driver.get(CheckOut);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      
      WebElement Company= driver.findElement(By.xpath("//*[@id=\"EI41767\"]"));
		Company.sendKeys("HS");	
		WebElement street_Address1= driver.findElement(By.xpath("//*[@id=\"GC335WA\"]"));
		street_Address1.sendKeys("JO");
		WebElement street_address2= driver.findElement(By.xpath("//*[@id=\"GIXKFX2\"]"));
		street_address2.sendKeys("Zarqa");
		
		WebElement street_add3= driver.findElement(By.xpath("//*[@id=\"J5CLJDF\"]"));
		street_add3.sendKeys("Hashmiah");
		
		WebElement City= driver.findElement(By.xpath("//*[@id=\"JRK1UUS\"]"));
		City.sendKeys("Az zarqa");
		
		Select Selector = new Select(driver.findElement(By.xpath("//*[@id=\"ADA2T1O\"]")));
		Selector.selectByIndex(i);
		
		WebElement postalCode= driver.findElement(By.xpath("//*[@id=\"O048580\"]"));
		postalCode.sendKeys("123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement PhoneNumber= driver.findElement(By.xpath("//*[@id=\"D8QYHTL\"]"));
		PhoneNumber.sendKeys("078014689");

		WebElement Next= driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		Next.click();
		}

}