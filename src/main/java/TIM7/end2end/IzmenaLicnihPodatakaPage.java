package TIM7.end2end;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IzmenaLicnihPodatakaPage {
	
WebDriver driver;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[4]/button[1]")
	private WebElement sacuvajDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[4]/button[2]")
	private WebElement otkaziDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[1]/input")
	private WebElement imePolje;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[2]/input")
	private WebElement prezimePolje;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[3]/input")
	private WebElement emailPolje;
	

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[1]/div/p[text()='Ime je obavezno.']")
	private WebElement imePoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[2]/div/p[text()='Prezime je obavezno.']")
	private WebElement prezimePoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[3]/div/p[text()='Email je obavezan.']")
	private WebElement emailPoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-uredjivanje-profila/div/div[2]/form/div[3]/div/p[text()='Uneli ste nepostojecu email adresu.']")
	private WebElement nepostojeciMailPoruka;
	
	
	
	 public IzmenaLicnihPodatakaPage(WebDriver driver) {
		this.driver = driver;
	}


	public void stranicaUcitana() {
		
	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((sacuvajDugme)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((otkaziDugme)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((imePolje)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((prezimePolje)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((emailPolje)));
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getNepostojeciMailPoruka() {
		return nepostojeciMailPoruka;
	}


	public WebElement getSacuvajDugme() {
		return sacuvajDugme;
	}


	public WebElement getOtkaziDugme() {
		return otkaziDugme;
	}


	public WebElement getImePolje() {
		return imePolje;
	}


	public WebElement getPrezimePolje() {
		return prezimePolje;
	}


	public WebElement getEmailPolje() {
		return emailPolje;
	}


	public WebElement getImePoruka() {
		return imePoruka;
	}


	public WebElement getPrezimePoruka() {
		return prezimePoruka;
	}


	public WebElement getEmailPoruka() {
		return emailPoruka;
	}




}
