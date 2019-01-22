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
	
	
	
	 public WebDriver getDriver() {
		return driver;
	}



	public WebElement getOdjavaDugme() {
		return odjavaDugme;
	}

	
	public void profilUcitan() {
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/app-root/div/div[2]/app-profil-korisnik/div/div/div[2]/table"))));
	}
	public int brojKolonaUTabeliKarata() {
		return driver.findElements(By.cssSelector("tr")).size();
	}

	public ProfilKorisnikPage(WebDriver driver) {
			this.driver = driver;
		}
	
	
}
