package TIM7.end2end;




import static org.testng.Assert.assertEquals;

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



public class KupovinaKarteTest {
	
	private WebDriver browser;
	
	ProfilKorisnikPage korProf;
	KupovinaKartePage kupovinaStranica;


	

	@BeforeMethod
	public void setupSelenium() {
		//instantiate browser
				System.setProperty("webdriver.chrome.driver", "C:/javatools/selenium-chrome-driver-2018/chromedriver.exe");
				browser = new ChromeDriver();
				//maximize window
				browser.manage().window().maximize();
				
				
				//navigate
				browser.navigate().to("http://localhost:4200/profilKorisnik");

				WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
				LocalStorage localStorage= (LocalStorage) webStorage.getLocalStorage();
				localStorage.setItem("X-Auth-Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJLb3Jpc25pa1Rlc3QiLCJjcmVhdGVkIjoxNTQ4MTg0ODE0ODY0LCJleHAiOjE1NDgyMDI4MTR9.lFR3Je-wC9G_IVLb-96_bda0H4Y4W6LqlWxTeAg5gUuWHb9Wc4pZg9ThbVHcd25YFsUqaljR78RwbsrYtwyuHA");
				localStorage.setItem("ulogovan"," {\"korIme\":\"KorisnikTest\",\"uloga\":\"KORISNIK\",\"ime\":\"KorisnikTest\",\"prezime\":\"KorisnikTest\",\"email\":\"e@gmail.com\",\"status\":\"STUDENT\"}");
				
				
				korProf = PageFactory.initElements(browser, ProfilKorisnikPage.class);
				kupovinaStranica=PageFactory.initElements(browser, KupovinaKartePage.class);
				
				browser.navigate().refresh();
			
				
	}
	
	@Test
	public void uspesnaKupovina() throws InterruptedException {
			
		
		
			korProf.profilUcitan();
			int brojKarataPreKupovine = korProf.brojKolonaUTabeliKarata();
			korProf.getKupiKartuDugme().click();
			
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			kupovinaStranica.stranicaUcitana();
			
			kupovinaStranica.getTipKarte().click();
			kupovinaStranica.getSelect1Opcija1().click();
			
			kupovinaStranica.getTipPrevoza().click();
			kupovinaStranica.getSelect2Opcija1().click();
			
			kupovinaStranica.getLinijaZona().click();
			kupovinaStranica.getSelect3Opcija1().click();
			
			kupovinaStranica.getKupiDugme().click();
			
			
			
			(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			assertEquals(alert.getText() , "Uspesno ste izvrsili kupovinu karte.");
			alert.accept();
			
			
			
			korProf.profilUcitan();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");
			
			assertEquals(korProf.brojKolonaUTabeliKarata(), brojKarataPreKupovine+1);
			
			
			
			
			
	
	}
	
	
	@Test
	public void odustanakOdKupovine() throws InterruptedException {
	
		
		
			korProf.profilUcitan();
			int brojKarataPreKupovine = korProf.brojKolonaUTabeliKarata();
			korProf.getKupiKartuDugme().click();
			
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			kupovinaStranica.stranicaUcitana();
			
			kupovinaStranica.getTipKarte().click();
			kupovinaStranica.getSelect1Opcija1().click();
			
			kupovinaStranica.getTipPrevoza().click();
			kupovinaStranica.getSelect2Opcija1().click();
			
			kupovinaStranica.getLinijaZona().click();
			kupovinaStranica.getSelect3Opcija1().click();
			
			kupovinaStranica.getOtkaziDugme().click();
			
			
		
			
			korProf.profilUcitan();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");
			
			assertEquals(korProf.brojKolonaUTabeliKarata(), brojKarataPreKupovine);
			
			
			
			
			
	
	}
	
	@Test
	public void kupovinaBezPounjavanjaPolja() throws InterruptedException {
			
		
		
			korProf.profilUcitan();
			korProf.getKupiKartuDugme().click();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			
			kupovinaStranica.getKupiDugme().click();
			kupovinaStranica.getTipKartePoruka().isDisplayed();
			kupovinaStranica.getTipPrevoza().isDisplayed();
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
					
	
	}
	
	@Test
	public void poljeZonaLinijaNijeOdabrano() throws InterruptedException {
		
		
		
			korProf.profilUcitan();
			korProf.getKupiKartuDugme().click();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			kupovinaStranica.stranicaUcitana();
			
			kupovinaStranica.getTipKarte().click();
			kupovinaStranica.getSelect1Opcija1().click();
			
			kupovinaStranica.getTipPrevoza().click();
			kupovinaStranica.getSelect2Opcija1().click();
		
			kupovinaStranica.getKupiDugme().click();
			
			
			
			kupovinaStranica.getLinijaZonaPoruka().isDisplayed();
		
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			
			
			
			
			
	
	}
	@Test
	public void tipKarteNijeOdabran() throws InterruptedException {
			
		
			korProf.profilUcitan();
			korProf.getKupiKartuDugme().click();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
		
			kupovinaStranica.getTipPrevoza().click();
			kupovinaStranica.getSelect2Opcija1().click();
			
			kupovinaStranica.getKupiDugme().click();
			
			kupovinaStranica.getTipKartePoruka().isDisplayed();
	
		
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
				
	
	}
	
	
	
	@Test
	public void popunjenSamoPoljeTipKarte() throws InterruptedException {
		
			korProf.profilUcitan();
			korProf.getKupiKartuDugme().click();
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			
			kupovinaStranica.getTipKarte().click();
			kupovinaStranica.getSelect1Opcija1().click();
			kupovinaStranica.getKupiDugme().click();
			
			kupovinaStranica.getTipPrevozaPoruka().isDisplayed();
			kupovinaStranica.getLinijaZonaPoruka().isDisplayed();
			
			assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
			
			
	}
			
			
		
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
	//browser.quit();
	}

	
	

}
