package TIM7.end2end;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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



public class PregledKupljenihKarataTest {
	
	private WebDriver browser;
	
	ProfilKorisnikPage korProf;


	

	@BeforeMethod
	public void setupSelenium() {
		//instantiate browser
				System.setProperty("webdriver.chrome.driver", "C:/javatools/selenium-chrome-driver-2018/chromedriver.exe");
				browser = new ChromeDriver();
				//maximize window
				browser.manage().window().maximize();
				
				
				//navigate
				browser.navigate().to("http://localhost:4200/profilKorisnik");
				String token = Token.generateToken("KorisnikTest");
				WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
				LocalStorage localStorage= (LocalStorage) webStorage.getLocalStorage();
				localStorage.setItem("X-Auth-Token", token);
				localStorage.setItem("ulogovan"," {\"korIme\":\"KorisnikTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":\"STUDENT\"}");
				
				
				korProf = PageFactory.initElements(browser, ProfilKorisnikPage.class);
				browser.navigate().refresh();
			
				
	}
	
	@Test
	public void pregledKupljenihKaratTest() {
		
		
		//ulogovan korisnik ima 3 kupljene karte, provera da li na profilu u tabeli ima 4 reda karata(1 red je heder tabele)
		
		korProf.profilUcitan();
		assertEquals(korProf.brojKolonaUTabeliKarata(), 4);
			
	
	}
	

	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
	browser.quit();
	}

	
	

}
