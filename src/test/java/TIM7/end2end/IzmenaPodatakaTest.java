package TIM7.end2end;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import TIM7.end2end.Security.Token;

public class IzmenaPodatakaTest {

	private WebDriver browser;

	ProfilKorisnikPage korProf;
	IzmenaLicnihPodatakaPage izmenaStranica;

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
		izmenaStranica = PageFactory.initElements(browser, IzmenaLicnihPodatakaPage.class);

		browser.navigate().refresh();

	}

	
	 
	  @Test public void uspesnaIzmenaProfila() {
	  
	  korProf.profilUcitan(); korProf.getIzmenaPodatakaDugme().click();
	  assertEquals(browser.getCurrentUrl(),
	  "http://localhost:4200/uredjivanjeProfila");
	 
	 
	  izmenaStranica.stranicaUcitana();
	  
	  assertEquals( izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
	  assertEquals( izmenaStranica.getPrezimePolje().getAttribute("value"),
	  "PrezimeTest"); assertEquals(
	  izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
	
	 
	 
	 izmenaStranica.getImePolje().clear();
	 izmenaStranica.getImePolje().sendKeys("NovoIme");
	 
	 izmenaStranica.getPrezimePolje().clear();
	 izmenaStranica.getPrezimePolje().sendKeys("NovoPrezime");
	 
	 izmenaStranica.getEmailPolje().clear();
	 izmenaStranica.getEmailPolje().sendKeys("novaAdresa@gmail.com");
	 
	 izmenaStranica.getSacuvajDugme().click();
	 
	 korProf.profilUcitan(); assertEquals(browser.getCurrentUrl(),
	 "http://localhost:4200/profilKorisnik");
	 
	 (new WebDriverWait(browser,10)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/h1[text()='NovoIme NovoPrezime']"))));
	 (new WebDriverWait(browser,10)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/h3[2][text()='Email adresa: novaAdresa@gmail.com ']"))));
	 
	 
	 
	 }
	 
	 @Test public void izmenaPoodatakaOdustanak() {
	 
	 korProf.profilUcitan(); korProf.getIzmenaPodatakaDugme().click();
	 assertEquals(browser.getCurrentUrl(),
	 "http://localhost:4200/uredjivanjeProfila");
	 
	 izmenaStranica.stranicaUcitana();
	 
	 assertEquals( izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
	 assertEquals( izmenaStranica.getPrezimePolje().getAttribute("value"),
	 "PrezimeTest"); assertEquals(
	 izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
	 
	 
	 
	 izmenaStranica.getImePolje().clear();
	 izmenaStranica.getImePolje().sendKeys("NovoIme");
	 
	 izmenaStranica.getPrezimePolje().clear();
	 izmenaStranica.getPrezimePolje().sendKeys("NovoPrezime");
	 
	 izmenaStranica.getEmailPolje().clear();
	 izmenaStranica.getEmailPolje().sendKeys("novaAdresa@gmail.com");
	 
	 izmenaStranica.getOtkaziDugme().click();
	 
	 korProf.profilUcitan(); assertEquals(browser.getCurrentUrl(),
	 "http://localhost:4200/profilKorisnik");
	 
	 (new WebDriverWait(browser,
	 10)).until(ExpectedConditions.visibilityOfElementLocated((By.
	 xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/h1[text()='ImeTest PrezimeTest']"
	 )))); (new WebDriverWait(browser,
	 10)).until(ExpectedConditions.visibilityOfElementLocated((By.
	 xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/h3[2][text()='Email adresa: test@gmail.com ']"
	 ))));
	 
	 
	 
	 }
	 
	 
	
	
	@Test
	public void nepostojecaEmailAdresa() {

		korProf.profilUcitan();
		korProf.getIzmenaPodatakaDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

		izmenaStranica.stranicaUcitana();

		assertEquals(izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
		assertEquals(izmenaStranica.getPrezimePolje().getAttribute("value"), "PrezimeTest");
		assertEquals(izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
		
		
		izmenaStranica.getImePolje().clear();
		 izmenaStranica.getImePolje().sendKeys("NovoIme");
		  
		 izmenaStranica.getPrezimePolje().clear();
		 izmenaStranica.getPrezimePolje().sendKeys("NovoPrezime");
		  
		 izmenaStranica.getEmailPolje().clear();
		 izmenaStranica.getEmailPolje().sendKeys("bla");
		
		
		
		

		izmenaStranica.getSacuvajDugme().click();

		izmenaStranica.getNepostojeciMailPoruka().isDisplayed();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

	}

	
	
	@Test
	public void nepopunjenaImePolje() {

		korProf.profilUcitan();
		korProf.getIzmenaPodatakaDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

		izmenaStranica.stranicaUcitana();

		assertEquals(izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
		assertEquals(izmenaStranica.getPrezimePolje().getAttribute("value"), "PrezimeTest");
		assertEquals(izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
		
		izmenaStranica.getImePolje().clear();
		 izmenaStranica.getImePolje().sendKeys("NovoIme");
		  
		 izmenaStranica.getPrezimePolje().clear();
		 izmenaStranica.getPrezimePolje().sendKeys("NovoPrezime");
		  
		 izmenaStranica.getEmailPolje().clear();
		 izmenaStranica.getEmailPolje().sendKeys("novaAdresa@gmail.com");
		
		izmenaStranica.getImePolje().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	
		

		izmenaStranica.getSacuvajDugme().click();

		izmenaStranica.getImePoruka().isDisplayed();
	

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

	}
	
	@Test
	public void nepopunjenaPrezimePolje() {

		korProf.profilUcitan();
		korProf.getIzmenaPodatakaDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

		izmenaStranica.stranicaUcitana();

		assertEquals(izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
		assertEquals(izmenaStranica.getPrezimePolje().getAttribute("value"), "PrezimeTest");
		assertEquals(izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
		
		izmenaStranica.getImePolje().clear();
		 izmenaStranica.getImePolje().sendKeys("NovoIme");
		  
		 izmenaStranica.getPrezimePolje().clear();
		 izmenaStranica.getPrezimePolje().sendKeys("a");
		  
		 izmenaStranica.getEmailPolje().clear();
		 izmenaStranica.getEmailPolje().sendKeys("novaAdresa@gmail.com");
		
		izmenaStranica.getPrezimePolje().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	
		

		izmenaStranica.getSacuvajDugme().click();

		izmenaStranica.getPrezimePoruka().isDisplayed();
	

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

	}
	
	
	@Test
	public void nepopunjenaEmailPolje() {

		korProf.profilUcitan();
		korProf.getIzmenaPodatakaDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

		izmenaStranica.stranicaUcitana();

		assertEquals(izmenaStranica.getImePolje().getAttribute("value"), "ImeTest");
		assertEquals(izmenaStranica.getPrezimePolje().getAttribute("value"), "PrezimeTest");
		assertEquals(izmenaStranica.getEmailPolje().getAttribute("value"), "test@gmail.com");
		
		izmenaStranica.getImePolje().clear();
		 izmenaStranica.getImePolje().sendKeys("NovoIme");
		  
		 izmenaStranica.getPrezimePolje().clear();
		 izmenaStranica.getPrezimePolje().sendKeys("NovoPrezime");
		  
		 izmenaStranica.getEmailPolje().clear();
		 izmenaStranica.getEmailPolje().sendKeys("novaAdresa@gmail.com");
		
		izmenaStranica.getEmailPolje().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	
		

		izmenaStranica.getSacuvajDugme().click();

		izmenaStranica.getEmailPoruka().isDisplayed();
	

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/uredjivanjeProfila");

	}

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
	browser.quit();
	}

}
