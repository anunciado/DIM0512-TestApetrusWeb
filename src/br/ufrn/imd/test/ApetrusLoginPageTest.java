package br.ufrn.imd.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ufrn.imd.page.ApetrusHomePage;

@SuppressWarnings("unused")
public class ApetrusLoginPageTest {

		private static WebDriver driver;
		private static String driverPathWindows = "drivers/windows/chromedriver.exe";	
		private static String driverPathLinux = "drivers/linux/chromedriver";	  
		
		@BeforeClass 
		public static void setUp() {
			System.setProperty("webdriver.chrome.driver", driverPathWindows);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterClass 
		public static void tearDown() {
			driver.close(); 
		}	
		
		@Test 
		public void testUsuarioLogado(){
			ApetrusHomePage homePage = new ApetrusHomePage(driver);
			assertTrue(homePage.getUsuarioLogado("luis.eduardo.225@gmail.com"));
		}
}

