package TIM7.end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilKorisnikPage {

	WebDriver driver;
	
	@FindBy(xpath = "/html/body/app-root/div/div[1]/button[1][text()='Odjava']")
	private WebElement odjavaDugme;
	
	@FindBy(xpath = "	/html/body/app-root/div/div[1]/div/button[3]")
	private WebElement kupiKartuDugme;
	@FindBy(xpath = "/html/body/app-root/div/div[1]/div/button[4]")
	private WebElement izmenaPodatakaDugme;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[1]/button[2]")
	private WebElement izmenaLozinkeDugme;
	


	 public WebElement getKupiKartuDugme() {
		return kupiKartuDugme;
	}



	public WebElement getIzmenaPodatakaDugme() {
		return izmenaPodatakaDugme;
	}



	public WebDriver getDriver() {
		return driver;
	}




	public WebElement getIzmenaLozinkeDugme() {
		return izmenaLozinkeDugme;
	}



	public WebElement getOdjavaDugme() {
		return odjavaDugme;
	}

	
	public void profilUcitan() {
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table"))));
	}
	public int brojRedovaUTabeliKarata() {
		return driver.findElements(By.cssSelector("tr")).size();
	}
	
	public int brojDnevnihkarata() {
		return driver.findElements(By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table/tbody/tr/td[text()= 'DNEVNA']")).size();
	}
	
	public int brojMesecnihkarata() {
		return driver.findElements(By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table/tbody/tr/td[text()= 'MESECNA']")).size();
	}
	
	public int brojGodisnjihkarata() {
		return driver.findElements(By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table/tbody/tr/td[text()= 'GODISNJA']")).size();
	}
	
	public void kartaKupljenaProvera(int prethodniBrojKarata) {
	
		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.numberOfElementsToBe(
					By.cssSelector("tr"), prethodniBrojKarata + 1));
	}

	public ProfilKorisnikPage(WebDriver driver) {
			this.driver = driver;
		}
	
	
}
