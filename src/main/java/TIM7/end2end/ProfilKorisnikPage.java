package TIM7.end2end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



	public ProfilKorisnikPage(WebDriver driver) {
			this.driver = driver;
		}
}
