package TIM7.end2end;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class OdjavaTest {
	
	private WebDriver browser;
	PocetnaPage pocetna;
	PrijavaPage prijava;
	ProfilKorisnikPage korProf;
	ProfilAdminPage adminProf;
	ProfilVerifikatorPage verifikatorProf;
	ProfilKondukterPage kondukterProf;
	

	@BeforeMethod
	public void setupSelenium() {
		//instantiate browser
				System.setProperty("webdriver.chrome.driver", "C:/javatools/selenium-chrome-driver-2018/chromedriver.exe");
				browser = new ChromeDriver();
				//maximize window
				browser.manage().window().maximize();
				//navigate
				browser.navigate().to("http://localhost:4200");
				
				pocetna = PageFactory.initElements(browser, PocetnaPage.class);
				prijava=PageFactory.initElements(browser, PrijavaPage.class);
				korProf = PageFactory.initElements(browser, ProfilKorisnikPage.class);
				adminProf=PageFactory.initElements(browser, ProfilAdminPage.class);
				verifikatorProf = PageFactory.initElements(browser, ProfilVerifikatorPage.class);
				kondukterProf=PageFactory.initElements(browser, ProfilKondukterPage.class);
				
				
	}
	
	
	@Test
	public void odjavaKorisnik() throws InterruptedException {
		
		
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("KorisnikTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/button[1][text()='Odjava']")));
		
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");
			korProf.getOdjavaDugme().click();
			pocetna.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/");
	
	}
	
	
	@Test
	public void odjavaKondukter() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("KondukterTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
			(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/button[1][text()='Odjava']")));
		
		
		
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKondukter");
		
		kondukterProf.getOdjavaDugme().click();
		pocetna.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/");
		
	}
	
	@Test
	public void odjavaAdmin() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("AdminTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/button[1][text()='Odjava']")));
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilAdmin");
		
		adminProf.getOdjavaDugme().click();
		pocetna.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/");
		
	}
	@Test
	public void odjavaVerifikator() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("VerifikatorTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/button[1][text()='Odjava']")));
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilVerifikator");
		
		verifikatorProf.getOdjavaDugme().click();
		pocetna.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/");
		
		
		
	}
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
	browser.quit();
	}

	
	

}
