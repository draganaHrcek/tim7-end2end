package TIM7.end2end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PocetnaPage {
	

	WebDriver driver;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[1]/button[2]")
	private WebElement prijavaDugme;

	@FindBy(xpath = "/html/body/app-root/div/div[1]/button[1]")
	private WebElement registracijaDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[1]/button[3]")
	private WebElement cenovnikDugme;
	
	 public PocetnaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getRegistracijaDugme() {
		return registracijaDugme;
	}





	public WebElement getCenovnikDugme() {
		return cenovnikDugme;
	}





	public void stranicaUcitana() {
	
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf((prijavaDugme)));
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf((registracijaDugme)));
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf((cenovnikDugme)));
	}





	public WebDriver getDriver() {
		return driver;
	}





	public WebElement getPrijavaDugme() {
		return prijavaDugme;
	}

}
