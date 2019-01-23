package TIM7.end2end;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TIM7.end2end.Security.Token;

public class IzmenaLozinkeTest {
	
	
	private WebDriver browser;

	ProfilKorisnikPage korProf;
	IzmenaLozinkePage izmenaStranica;
	PocetnaPage pocetna;
	PrijavaPage prijava;

	@BeforeMethod
	public void setupSelenium() {
		// instantiate browser
		System.setProperty("webdriver.chrome.driver", "C:/javatools/selenium-chrome-driver-2018/chromedriver.exe");
		browser = new ChromeDriver();
		// maximize window
		browser.manage().window().maximize();

		// navigate
		browser.navigate().to("http://localhost:4200/profilKorisnik");
		
		String token = Token.generateToken("KorisnikTest");
		
		WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
		LocalStorage localStorage = (LocalStorage) webStorage.getLocalStorage();
		localStorage.setItem("X-Auth-Token",token);
		localStorage.setItem("ulogovan"," {\"korIme\":\"KorisnikTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":\"STUDENT\"}");

		korProf = PageFactory.initElements(browser, ProfilKorisnikPage.class);
		izmenaStranica = PageFactory.initElements(browser, IzmenaLozinkePage.class);
		pocetna = PageFactory.initElements(browser, PocetnaPage.class);
		prijava=  PageFactory.initElements(browser, PrijavaPage.class);
		browser.navigate().refresh();

	}
	
	
	@Test
	public void netacnaTrenutnaLozinka() {
		
		  korProf.profilUcitan(); 
		  korProf.getIzmenaLozinkeDugme().click();
		  assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		  izmenaStranica.stranicaUcitana();
		  
		  izmenaStranica.getTrenutnaLozinka().clear();
		  izmenaStranica.getTrenutnaLozinka().sendKeys("blabla");
		  izmenaStranica.getNovaLozinka().clear();
		  izmenaStranica.getNovaLozinka().sendKeys("87654321");
		  izmenaStranica.getPonovljenaNovaLozinka().clear();
		  izmenaStranica.getPonovljenaNovaLozinka().sendKeys("87654321");
		  
		  izmenaStranica.getSacuvajDugme().click();
		  

			(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			assertEquals(alert.getText() , "Niste uneli ispravno trenutnu lozinku.");
			alert.accept();
			
			izmenaStranica.stranicaUcitana();
			
			 assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		
		
	} 
	
	@Test
	public void kratkaNovaLozinka() {
		
		  korProf.profilUcitan(); 
		  korProf.getIzmenaLozinkeDugme().click();
		  assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		  izmenaStranica.stranicaUcitana();
		  
		  izmenaStranica.getTrenutnaLozinka().clear();
		  izmenaStranica.getTrenutnaLozinka().sendKeys("12345678");
		  izmenaStranica.getNovaLozinka().clear();
		  izmenaStranica.getNovaLozinka().sendKeys("123");
		  izmenaStranica.getPonovljenaNovaLozinka().clear();
		  izmenaStranica.getPonovljenaNovaLozinka().sendKeys("123");

		izmenaStranica.getKratkaNovaLozinkaPoruka().isDisplayed();
	
			 assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		
		
	}
 
	@Test
	public void neispravnoPotvrdjenaNovaLozinka() {
		
		  korProf.profilUcitan(); 
		  korProf.getIzmenaLozinkeDugme().click();
		  assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		  izmenaStranica.stranicaUcitana();
		  
		  izmenaStranica.getTrenutnaLozinka().clear();
		  izmenaStranica.getTrenutnaLozinka().sendKeys("12345678");
		  izmenaStranica.getNovaLozinka().clear();
		  izmenaStranica.getNovaLozinka().sendKeys("87654321");
		  izmenaStranica.getPonovljenaNovaLozinka().clear();
		  izmenaStranica.getPonovljenaNovaLozinka().sendKeys("123");
		  
		  izmenaStranica.getSacuvajDugme().click();
		  

			(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			assertEquals(alert.getText() , "Niste ispravno potvrdili novu lozinku.");
			alert.accept();
			
			izmenaStranica.stranicaUcitana();
			 assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		
		
	}
	
	@Test
	public void nepopunjenaObaveznaPolja() {
		
		  korProf.profilUcitan(); 
		  korProf.getIzmenaLozinkeDugme().click();
		  assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		  izmenaStranica.stranicaUcitana();
		  
		  
		  izmenaStranica.getSacuvajDugme().click();
		  

		izmenaStranica.getTrenutnaLozinkaPoruka();
		izmenaStranica.getNovaLozinkaPoruka();
		izmenaStranica.getPonovljenaLoznikaPoruka();
		
			
			 assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		
		
	}
	
	
	
	@Test
	public void uspesnaIzmenaLozinke() {
		
		  korProf.profilUcitan(); 
		  korProf.getIzmenaLozinkeDugme().click();
		  assertEquals(browser.getCurrentUrl(),"http://localhost:4200/izmenaLozinke");
		  
		  izmenaStranica.stranicaUcitana();
		  
		  izmenaStranica.getTrenutnaLozinka().clear();
		  izmenaStranica.getTrenutnaLozinka().sendKeys("12345678");
		  izmenaStranica.getNovaLozinka().clear();
		  izmenaStranica.getNovaLozinka().sendKeys("87654321");
		  izmenaStranica.getPonovljenaNovaLozinka().clear();
		  izmenaStranica.getPonovljenaNovaLozinka().sendKeys("87654321");
		  
		  izmenaStranica.getSacuvajDugme().click();
		  

			(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			assertEquals(alert.getText() , "Uspesno ste promenili lozinku.");
			alert.accept();
			
			korProf.profilUcitan();
			assertEquals(browser.getCurrentUrl(),"http://localhost:4200/profilKorisnik");
			
			//provera da li se korisnik uspesno ulogova sa novom lozinkom
			korProf.getOdjavaDugme().click();
			pocetna.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(),"http://localhost:4200/");
			pocetna.getPrijavaDugme().click();
			prijava.stranicaUcitana();
			assertEquals(browser.getCurrentUrl(),"http://localhost:4200/prijava");
			
			prijava.getKorIme().clear();
			prijava.getKorIme().sendKeys("KorisnikTest");
			prijava.getLozinka().sendKeys("87654321");
			prijava.getDugmePrijava().click();
			
			korProf.profilUcitan();
			assertEquals(browser.getCurrentUrl(),"http://localhost:4200/profilKorisnik");
			
			
		  
		
		
	}
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
	browser.quit();
	}
}
