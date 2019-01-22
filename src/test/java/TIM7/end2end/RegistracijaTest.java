package TIM7.end2end;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RegistracijaTest {
	
	private WebDriver browser;
	PocetnaPage pocetna;
	RegistracijaPage reg;

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
				reg=PageFactory.initElements(browser, RegistracijaPage.class);
				
	}
	
	@Test
	public void registracijaPostojecegKorisnika() {
		
		pocetna.stranicaUcitana();
		pocetna.getRegistracijaDugme().click();
		
		reg.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
		
		reg.getKorIme().clear();
		reg.getKorIme().sendKeys("KorisnikTest");
		
		reg.getLozinka1().clear();
		reg.getLozinka1().sendKeys("12345678");
		
		reg.getLozinka2().clear();
		reg.getLozinka2().sendKeys("12345678");
		
		reg.getIme().clear();
		reg.getIme().sendKeys("ime");
		
		reg.getPrezime().clear();
		reg.getPrezime().sendKeys("prezime");
		
		reg.getEmail().clear();
		reg.getEmail().sendKeys("test@gmail.com");
		
		reg.getRegistrujDugme().click();
		
		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText() , "Korisnik sa unetim korisnickim imenom vec postoji.");
		alert.accept();
		
		reg.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
		
		
	}
	
	
	@Test
	public void uspesnaRegistracija() {
		
		pocetna.stranicaUcitana();
		pocetna.getRegistracijaDugme().click();
		
		reg.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
		
		reg.getKorIme().clear();
		reg.getKorIme().sendKeys("NovKorisnik");
		
		reg.getLozinka1().clear();
		reg.getLozinka1().sendKeys("12345678");
		
		reg.getLozinka2().clear();
		reg.getLozinka2().sendKeys("12345678");
		
		reg.getIme().clear();
		reg.getIme().sendKeys("ime");
		
		reg.getPrezime().clear();
		reg.getPrezime().sendKeys("prezime");
		
		reg.getEmail().clear();
		reg.getEmail().sendKeys("test@gmail.com");
		
		reg.getRegistrujDugme().click();
		
(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText() , "Uspesno ste izvrsili registraciju.");
		alert.accept();
		
		pocetna.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/");
		
		
	}
	
	
	@Test
	public void neipravnoPotvrdjenaLozinka() {
		
		pocetna.stranicaUcitana();
		pocetna.getRegistracijaDugme().click();
		
		reg.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
		
		reg.getKorIme().clear();
		reg.getKorIme().sendKeys("TestKorisnik");
		
		reg.getLozinka1().clear();
		reg.getLozinka1().sendKeys("12345678");
		
		reg.getLozinka2().clear();
		reg.getLozinka2().sendKeys("87654321");
		
		reg.getIme().clear();
		reg.getIme().sendKeys("ime");
		
		reg.getPrezime().clear();
		reg.getPrezime().sendKeys("prezime");
		
		reg.getEmail().clear();
		reg.getEmail().sendKeys("test@gmail.com");
		
		reg.getRegistrujDugme().click();
		
(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText() , "Niste ispravno potvrdili lozinku.");
		alert.accept();
		
		reg.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
	}
	
	
		@Test
		public void nepostojecaEmailAdresa() {
			
			pocetna.stranicaUcitana();
			pocetna.getRegistracijaDugme().click();
			
			reg.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
			reg.getKorIme().clear();
			reg.getKorIme().sendKeys("NovKorisnik");
			
			reg.getLozinka1().clear();
			reg.getLozinka1().sendKeys("12345678");
			
			reg.getLozinka2().clear();
			reg.getLozinka2().sendKeys("12345678");
			
			reg.getIme().clear();
			reg.getIme().sendKeys("ime");
			
			reg.getPrezime().clear();
			reg.getPrezime().sendKeys("prezime");
			
			reg.getEmail().clear();
			reg.getEmail().sendKeys("t");
			reg.getRegistrujDugme().click();
			reg.nepostojeciMailPoruka();
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
			
		
	}
		
		
		@Test
		public void lozinkaKratna() {
			
			pocetna.stranicaUcitana();
			pocetna.getRegistracijaDugme().click();
			
			reg.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
			reg.getKorIme().clear();
			reg.getKorIme().sendKeys("NovKorisnik");
			
			reg.getLozinka1().clear();
			reg.getLozinka1().sendKeys("123");
			
			reg.getLozinka2().clear();
			reg.getLozinka2().sendKeys("123");
			
			reg.getIme().clear();
			reg.getIme().sendKeys("ime");
			
			reg.getPrezime().clear();
			reg.getPrezime().sendKeys("prezime");
			
			reg.getEmail().clear();
			reg.getEmail().sendKeys("test@gmail.com");
			
			reg.kratkaLozinkaPoruka();
			reg.getRegistrujDugme().click();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
		
	}
	
	
		@Test
		public void registracijaNepopunjenaPolja() {
			
			pocetna.stranicaUcitana();
			pocetna.getRegistracijaDugme().click();
			
			reg.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
			
			reg.getRegistrujDugme().click();
			
			reg.nepounjenaPoljaPoruke();
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/registracija");
			
		
	}
	
	
		@AfterMethod
		public void closeSelenium() {
			// Shutdown the browser
		//browser.quit();
		}
	
	
	

}
