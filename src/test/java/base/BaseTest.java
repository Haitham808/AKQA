package base;

import org.testng.annotations.AfterSuite;

import com.bunnings.base.Page;

public class BaseTest {
	
	@AfterSuite
	public void tearDwon() {
		Page.quit();
	}

}
