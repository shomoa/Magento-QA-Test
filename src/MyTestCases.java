import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
@BeforeTest
public void MyBeforeTest() {}

@Test()
public void MyTest() {}

@AfterTest
public void MyAfterTest() {}
}
