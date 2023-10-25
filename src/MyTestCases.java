import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	String theWebsite = "https://magento.softwaretestingboard.com/";
	String SignInPage = "https://magento.softwaretestingboard.com/customer/account/login";
	String LogOut = "https://magento.softwaretestingboard.com/customer/account/logout";
	String CheckOut = "https://magento.softwaretestingboard.com/checkout/";
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	String[] FName = { "Shomoa", "Abdullah", "Hussain", "Maysoon", "Rahhal" };
	String[] LName = { "Mohammad", "Abdullah", "Hussain", "Rashed", "Rahhal" };
	int i = rand.nextInt(0, 5);

	String password = "Sh123/*-";
	String BeginingOfEmail = "Userii";
	String EndOfEmail = "@gmail.com";

	int indexMiddleofEmail = rand.nextInt(0, 100);

	String TheLoginEmail;

	// numbers of items
	int radiant_tee = 3;
	int breathe_easy_tank = 2;
	int Hero_Hoodie = 1;
	int Argus = 4;

	// Price of each item in your cart
	String radiantteePrice;
	String breathe_easy_tankPrice;
	String Hero_HoodiePrice;
	String ArgusPrice;
	String backpackPrice;

	@BeforeTest
	public void MyBeforeTest() throws InterruptedException {
		driver.get(theWebsite);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		radiantteePrice = driver.findElement(By.xpath("//*[@id=\"old-price-1556-widget-product-grid\"]/span"))
				.getText();
		breathe_easy_tankPrice = driver.findElement(By.xpath("//*[@id=\"old-price-1812-widget-product-grid\"]/span"))
				.getText();
		Hero_HoodiePrice = driver.findElement(By.xpath("//*[@id=\"old-price-694-widget-product-grid\"]/span"))
				.getText();
		ArgusPrice = driver.findElement(By.xpath("//*[@id=\"old-price-158-widget-product-grid\"]/span")).getText();
		backpackPrice = driver.findElement(By.xpath("//*[@id=\"old-price-6-widget-product-grid\"]/span")).getText();

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
		Email.sendKeys(BeginingOfEmail + indexMiddleofEmail + EndOfEmail);
		TheLoginEmail = BeginingOfEmail + indexMiddleofEmail + EndOfEmail;
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
		Thread.sleep(2000);
		driver.get(SignInPage);
		Thread.sleep(2000); // 1 second
		// String TheLoginEmail = "Useri62@gmail.com";

		WebElement LoginEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		LoginEmail.sendKeys(TheLoginEmail);

		WebElement LoginPass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		LoginPass.sendKeys(password);

		WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		SignIn.click();
	}

	@Test(description = "Test # 3", priority = 3)
	public void Add_To_Cart() throws InterruptedException {
		String[] itemspages = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };

		for (int i = 0; i < itemspages.length; i++) {
			driver.get(itemspages[i]);

			Thread.sleep(8000);

			if (driver.getCurrentUrl().contains("radiant")) {

				WebElement DivSizeBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
				List<WebElement> Sizes = DivSizeBox.findElements(By.tagName("div")); // each div size locate in one div
																						// box
				int indexSize = rand.nextInt(0, Sizes.size());
				Sizes.get(indexSize).click();

				WebElement DivColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = DivColorBox.findElements(By.tagName("div")); // each div color locate in one
																						// div box
				int indexColor = rand.nextInt(0, Colors.size());
				Colors.get(indexColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("3");

				WebElement Addbutton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				Addbutton.click();
				Thread.sleep(3000);


			}
			

			else if (driver.getCurrentUrl().contains("breathe")) {

				WebElement DivSizeBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
				List<WebElement> Sizes = DivSizeBox.findElements(By.tagName("div")); // each div size locate in one div
																						// box
				int indexSize = rand.nextInt(0, Sizes.size());
				Sizes.get(indexSize).click();

				WebElement DivColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = DivColorBox.findElements(By.tagName("div")); // each div color locate in one
																						// div box
				int indexColor = rand.nextInt(0, Colors.size());
				Colors.get(indexColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("2");

				WebElement Addbutton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				Addbutton.click();
				
				Thread.sleep(3000);


			} else if (driver.getCurrentUrl().contains("argus")) {

				WebElement DivSizeBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
				List<WebElement> Sizes = DivSizeBox.findElements(By.tagName("div")); // each div size locate in one div
																						// box
				int indexSize = rand.nextInt(0, Sizes.size());
				Sizes.get(indexSize).click();

				WebElement DivColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = DivColorBox.findElements(By.tagName("div")); // each div color locate in one
																						// div box
				int indexColor = rand.nextInt(0, Colors.size());
				Colors.get(indexColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("4");

				WebElement Addbutton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				Addbutton.click();
				Thread.sleep(3000);


			}

			else if (driver.getCurrentUrl().contains("hoodie")) {

				WebElement DivSizeBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]"));
				List<WebElement> Sizes = DivSizeBox.findElements(By.tagName("div")); // each div size locate in one div
																						// box
				int indexSize = rand.nextInt(0, Sizes.size());
				Sizes.get(indexSize).click();

				WebElement DivColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = DivColorBox.findElements(By.tagName("div")); // each div color locate in one
																						// div box
				int indexColor = rand.nextInt(0, Colors.size());
				Colors.get(indexColor).click();

				// Quantity 1 it's set to 1 by default

				WebElement Addbutton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				Addbutton.click();
				Thread.sleep(3000);

			}

			else if (driver.getCurrentUrl().contains("backpack")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("5");

				WebElement Addbutton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				Addbutton.click();
				Thread.sleep(3000);


			}
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	@Test(description = "Test #4", priority = 4)
	public void CheckOutToProceed() throws InterruptedException {
		// First Way but u need to wait some time the further way go to link no much
		// time needed
//	    WebElement Basket= driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
//		Basket.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		WebElement ProceedToCheckout= driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
//		ProceedToCheckout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(10000);

		driver.get(CheckOut);
		Thread.sleep(10000);
		// optional
//      WebElement Company= driver.findElement(By.name("company"));
//		Company.sendKeys("HS");	

		WebElement street_Address1 = driver.findElement(By.name("street[0]"));
		street_Address1.sendKeys("JO");

		WebElement street_address2 = driver.findElement(By.name("street[1]"));
		street_address2.sendKeys("Zarqa");

		WebElement street_add3 = driver.findElement(By.name("street[2]"));
		street_add3.sendKeys("Hashmiah");

		WebElement City = driver.findElement(By.name("city"));
		City.sendKeys("Az zarqa");

		Select Selector = new Select(driver.findElement(By.name("region_id")));
		Selector.selectByIndex(i);

		WebElement postalCode = driver.findElement(By.name("postcode"));
		postalCode.sendKeys("12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(10000);
		Select Selector2 = new Select(driver.findElement(By.name("country_id")));
		Selector2.selectByIndex(i);

		WebElement PhoneNumber = driver.findElement(By.name("telephone"));
		PhoneNumber.sendKeys("078014689");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(3000);
		WebElement Next = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div"));
		Next.click();
	}

	@Test(description = "Test #5", priority = 5)
	public void invoice() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(1000);
		int Sum = 0;
		List<String> PricesList = new ArrayList<String>();
		PricesList.add(radiantteePrice);
		PricesList.add(breathe_easy_tankPrice);
		PricesList.add(ArgusPrice);
		PricesList.add(Hero_HoodiePrice);

//	  for(int i=0;i<PricesList.size();i++) {
//		  
//		  String a = PricesList.get(i);
//		 // So, in your regular expression \\$|\\.\\d+, you have two alternatives:
//
//			  //  \\$ matches a literal dollar sign.
//			  //   \.\\d+ matches a dot followed by one or more digits.
//			  
//		  String Output =a.replaceAll("\\$|\\.\\d+", "");
//		  int finalPrice = Integer.parseInt(Output);
//		  System.out.println(finalPrice);
//	  }

		///////////
		List<Integer> NumberOfItemsList = new ArrayList<Integer>();
		NumberOfItemsList.add(radiant_tee);
		NumberOfItemsList.add(breathe_easy_tank);
		NumberOfItemsList.add(Hero_Hoodie);
		NumberOfItemsList.add(Argus);

//	  for(int i=0;i<NumberOfItemsList.size();i++) {
//		 
//		  int NItems = NumberOfItemsList.get(i);
//		  System.out.println(NItems);
//	  }

		for (int i = 0; i < PricesList.size(); i++) {

			String a = PricesList.get(i);
			// So, in your regular expression \\$|\\.\\d+, you have two alternatives:
			// \\$ matches a literal dollar sign.
			// \.\\d+ matches a dot followed by one or more digits.
			String Output = a.replaceAll("\\$|\\.\\d+", "");
			int finalPrice = Integer.parseInt(Output);
			System.out.println(finalPrice);

			int NItems = NumberOfItemsList.get(i);
			System.out.println(NItems);

			Sum += finalPrice * NItems;

		}

		System.out.println("$" + Sum + ".00");
		String StringSum = "$" + Sum + ".00";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String CartSubtotal = driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[1]/td/span"))
				.getText();
		Assert.assertEquals(CartSubtotal, StringSum);

	}

}