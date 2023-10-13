import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
@BeforeTest
public void MyBeforeTest() {
	System.out.println("Hello");
}

@Test()
public void MyTest() {
	System.out.println("Hey there");

}


@AfterTest
public void MyAfterTest() {
	
	System.out.println("Candles");

}

}
