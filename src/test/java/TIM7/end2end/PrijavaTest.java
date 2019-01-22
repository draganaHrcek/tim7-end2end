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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PrijavaTest {
	
	private WebDriver browser;
	PocetnaPage pocetna;
	PrijavaPage prijava;

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
				
				
	}
	
	
	@Test
	public void uspesnaPrijavaKorisnik() throws InterruptedException {
		
		
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("KorisnikTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table")));
		
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");
		
	}
	
	//testovi koji cekaju da se urede profili ovih korisnika, da bih mogla da odradim wait (da li je dobar profil zaista ucitan kad se uloguju)
	/*
	@Test
	public void uspesnaPrijavaKondukter() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("KondukterTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/button[3]")));
		
		
		
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKondukter");
		
	}
	
	@Test
	public void uspesnaPrijavaAdmin() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("AdminTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilAdmin");
		
	}
	@Test
	public void uspesnaPrijavaVerifikator() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("VerifikatorTest");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("12345678");
		prijava.getDugmePrijava().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilVerifikator");
		
	}
	
	*/
	
	@Test
	public void neispravniKredencijali() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("bla");
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("bla");
		prijava.getDugmePrijava().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
	
		assertEquals(alert.getText() , "Uneli ste neispravne kredencijale.");
		alert.accept();
		
		prijava.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
	}
	
	
	@Test
	public void praznoKoriImePolje() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		
		prijava.getLozinka().clear();
		prijava.getLozinka().sendKeys("11111111");
		prijava.getDugmePrijava().click();
		prijava.korImePoruka();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
	}

	
	@Test
	public void praznaLozinkaPolje() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.stranicaUcitana();
		
		prijava.getKorIme().clear();
		prijava.getKorIme().sendKeys("KorisnikTest");
		prijava.getDugmePrijava().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
	}

	@Test
	public void nepopunjenaPoljaPrijava() {
		
		pocetna.stranicaUcitana();
		pocetna.getPrijavaDugme().click();
		
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
		prijava.getDugmePrijava().click();
		prijava.praznaPoljaPoruke();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/prijava");
		
	}
	
	

}
