package TIM7.end2end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrijavaPage {

	WebDriver driver;
	
	
	@FindBy(name = "korIme")
	private WebElement korIme;

	
	@FindBy(name = "lozinka1")
	private WebElement lozinka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-prijava/div/div/div[2]/form/button")
	private WebElement dugmePrijava;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-prijava/div/div/div[2]/form/div[1]/div/p[text()='Korisnicko ime je obavezno.']")
	private WebElement korImePoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-prijava/div/div/div[2]/form/div[2]/div/p[text()= 'Lozinka je obavezna.']")
	private WebElement lozinkaPoruka;
	
	 public PrijavaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void praznaPoljaPoruke() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((korImePoruka)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((lozinkaPoruka)));

	}
	public void korImePoruka() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((korImePoruka)));
		
	}
public void lozinkaPoruka() {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((lozinkaPoruka)));
		
	}
	
	public void stranicaUcitana() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((korIme)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((lozinka)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((dugmePrijava)));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getKorIme() {
		return korIme;
	}

	public WebElement getLozinka() {
		return lozinka;
	}

	public WebElement getDugmePrijava() {
		return dugmePrijava;
	}
	
	
	
}
