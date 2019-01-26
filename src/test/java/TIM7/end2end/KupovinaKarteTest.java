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

public class KupovinaKarteTest {

	private WebDriver browser;

	ProfilKorisnikPage korProf;
	KupovinaKartePage kupovinaStranica;

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
		localStorage.setItem("X-Auth-Token", token);
		localStorage.setItem("ulogovan",
				" {\"korIme\":\"KorisnikTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":\"STUDENT\"}");

		korProf = PageFactory.initElements(browser, ProfilKorisnikPage.class);
		kupovinaStranica = PageFactory.initElements(browser, KupovinaKartePage.class);

		browser.navigate().refresh();

	}

	@Test(dependsOnMethods = { "pregledKupljenihKarataTest" })
	public void uspesnaKupovinaMesecne() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		int brojMesecnihPreKupovine = korProf.brojMesecnihkarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getMesecnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getTramvajOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Uspesno ste izvrsili kupovinu karte.");
		alert.accept();

		korProf.profilUcitan();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");

		assertEquals(korProf.brojRedovaUTabeliKarata(), brojKarataPreKupovine + 1);
		assertEquals(korProf.brojMesecnihkarata(), brojMesecnihPreKupovine + 1);

	}

	@Test(dependsOnMethods = { "pregledKupljenihKarataTest" })
	public void uspesnaKupovinaGodisnje() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		int brojGodisnjihPreKupovine = korProf.brojGodisnjihkarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getGodisnjaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getTramvajOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Uspesno ste izvrsili kupovinu karte.");
		alert.accept();

		korProf.profilUcitan();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");

		assertEquals(korProf.brojRedovaUTabeliKarata(), brojKarataPreKupovine + 1);
		assertEquals(korProf.brojGodisnjihkarata(), brojGodisnjihPreKupovine + 1);

	}

	@Test
	public void vecKupljenGodisnjaKojaCekaNaPotvrdu() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getGodisnjaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getMetroOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getVeternikOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Karta koju ste odabrali je vec kupljena.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void vecKupljenMesecnaKojaCekaNaPotvrdu() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getMesecnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getMetroOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getVeternikOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Karta koju ste odabrali je vec kupljena.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void kupovinaVecKupljeneGodisnje() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getGodisnjaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getPrigradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Karta koju ste odabrali je vec kupljena.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void kupovinaVecKupljeneMesecne() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getMesecnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getPrigradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Karta koju ste odabrali je vec kupljena.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void odustanakOdKupovine() throws InterruptedException {

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		korProf.getKupiKartuDugme().click();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getDnevnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getOtkaziDugme().click();

		korProf.profilUcitan();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");

		assertEquals(korProf.brojRedovaUTabeliKarata(), brojKarataPreKupovine);

	}

	@Test
	public void kupovinaNepopunjenaForma() throws InterruptedException {

		korProf.profilUcitan();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.getKupiDugme().click();
		kupovinaStranica.getTipKartePoruka().isDisplayed();
		kupovinaStranica.getTipPrevoza().isDisplayed();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void poljeZonaLinijaNijePopunjeno() throws InterruptedException {

		korProf.profilUcitan();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getDnevnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		kupovinaStranica.getLinijaZonaPoruka().isDisplayed();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void tipKarteNijePopunjen() throws InterruptedException {

		korProf.profilUcitan();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

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
		kupovinaStranica.getDnevnaOpcija().click();
		kupovinaStranica.getKupiDugme().click();

		kupovinaStranica.getTipPrevozaPoruka().isDisplayed();
		kupovinaStranica.getLinijaZonaPoruka().isDisplayed();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	// korisnik bez statusa ne moze da kupi mesecnu, niti godisnju kartu, ali moze
	// dnevnu(za jednu voznju)

	@Test
	public void kupovinaMesecneKorisnikBezStatusa() throws InterruptedException {

		String token = Token.generateToken("KorisnikBezStatusaTest");
		WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
		LocalStorage localStorage = (LocalStorage) webStorage.getLocalStorage();
		localStorage.setItem("X-Auth-Token", token);
		localStorage.setItem("ulogovan",
				"{\"korIme\":\"KorisnikBezStatusaTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":null}");
		browser.navigate().refresh();

		korProf.profilUcitan();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getMesecnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Nije potvrdjen vas status. Proverite da li ste prilozili potvrdu.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test
	public void kupovinaGodisnjeKorisnikBezStatusa() throws InterruptedException {

		String token = Token.generateToken("KorisnikBezStatusaTest");
		WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
		LocalStorage localStorage = (LocalStorage) webStorage.getLocalStorage();
		localStorage.setItem("X-Auth-Token", token);
		localStorage.setItem("ulogovan","{\"korIme\":\"KorisnikBezStatusaTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":null}");
		browser.navigate().refresh();

		korProf.profilUcitan();
		korProf.getKupiKartuDugme().click();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");
	

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getGodisnjaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		(new WebDriverWait(browser, 20)).until(ExpectedConditions.visibilityOf((kupovinaStranica.getGradskaOpcija())));
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 10)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Nije potvrdjen vas status. Proverite da li ste prilozili potvrdu.");
		alert.accept();

		kupovinaStranica.stranicaUcitana();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

	}

	@Test(dependsOnMethods = { "pregledKupljenihKarataTest" })
	public void uspesnaKupovinaDnevnaKarta() throws InterruptedException {

		String token = Token.generateToken("KorisnikBezStatusaTest");
		WebStorage webStorage = (WebStorage) new Augmenter().augment(browser);
		LocalStorage localStorage = (LocalStorage) webStorage.getLocalStorage();
		localStorage.setItem("X-Auth-Token", token);
		localStorage.setItem("ulogovan",
				"{\"korIme\":\"KorisnikBezStatusaTest\",\"uloga\":\"KORISNIK\",\"ime\":\"ImeTest\",\"prezime\":\"PrezimeTest\",\"email\":\"test@gmail.com\",\"status\":null}");
		browser.navigate().refresh();

		korProf.profilUcitan();
		int brojKarataPreKupovine = korProf.brojRedovaUTabeliKarata();
		int brojDnevnihKarata = korProf.brojDnevnihkarata();
		korProf.getKupiKartuDugme().click();

		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/kupovinaKarte");

		kupovinaStranica.stranicaUcitana();

		kupovinaStranica.getTipKarte().click();
		kupovinaStranica.getDnevnaOpcija().click();

		kupovinaStranica.getTipPrevoza().click();
		kupovinaStranica.getAutobusOpcija().click();

		kupovinaStranica.getLinijaZona().click();
		kupovinaStranica.getGradskaOpcija().click();

		kupovinaStranica.getKupiDugme().click();

		(new WebDriverWait(browser, 20)).until(ExpectedConditions.alertIsPresent());
		Alert alert = browser.switchTo().alert();
		assertEquals(alert.getText(), "Uspesno ste izvrsili kupovinu karte.");
		alert.accept();

		korProf.profilUcitan();
		assertEquals(browser.getCurrentUrl(), "http://localhost:4200/profilKorisnik");

		assertEquals(korProf.brojRedovaUTabeliKarata(), brojKarataPreKupovine + 1);
		assertEquals(korProf.brojDnevnihkarata(), brojDnevnihKarata + 1);

	}

	// Test dodat u ovu klasu zato sto izlistavanje kupljenih karata mora da se
	// izvrsi pre nego sto se kupi nova karta
	// inace se test ne poklapa sa stanjem u bazi.
	@Test
	public void pregledKupljenihKarataTest() {
		korProf.profilUcitan();
		assertEquals(korProf.brojRedovaUTabeliKarata(), 8);
		assertEquals(korProf.brojMesecnihkarata(), 3);
		assertEquals(korProf.brojGodisnjihkarata(), 3);
		assertEquals(korProf.brojDnevnihkarata(), 1);

	}

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}

}
