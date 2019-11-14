package br.ufrn.imd.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ufrn.imd.page.ApetrusVeiculosPage;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApetrusVeiculosPageTest {

		private static WebDriver driver;
		private static String DRIVER_PATH_WINDOWS = "drivers/windows/chromedriver.exe";	
		private static String DRIVER_PATH_LINUX = "/home/android.bti/git/DIM0512-TestApetrusWeb/drivers/linux/chromedriver";	
		
		private static String LOGIN_VALIDO = "luis.eduardo.225@gmail.com";	
		private static String SENHA_VALIDO = "123456789";	
		
		@BeforeClass 
		public static void setUp() {
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH_LINUX);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterClass 
		public static void tearDown() {
			driver.close(); 
		}	
		
		@Test(expected = NoSuchElementException.class)
		public void testAUsuarioInvalido(){
			ApetrusVeiculosPage veiculosPage = new ApetrusVeiculosPage(driver, LOGIN_VALIDO, SENHA_VALIDO);
			veiculosPage.cadastrarVeiculo("MZD5827");
			assertTrue(veiculosPage.ultimoVeiculo("MZD5827"));
		}
}

