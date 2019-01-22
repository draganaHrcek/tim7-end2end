package TIM7.end2end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistracijaPage {
WebDriver driver;
	
	
	@FindBy(name = "korIme")
	private WebElement korIme;
	
	@FindBy(name = "lozinka1")
	private WebElement lozinka1;

	@FindBy(name = "lozinka2")
	private WebElement lozinka2;
	
	@FindBy(name = "ime")
	private WebElement ime;
	
	@FindBy(name = "prezime")
	private WebElement prezime;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/button")
	private WebElement registrujDugme;
	
	//poruke zastite
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[1]/div/p[text()='Korisnicko ime je obavezno.']")
	private WebElement korImePor;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[2]/div/p[text()='Lozinka je obavezna.']")
	private WebElement lozinka1Por1;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[2]/div/p[text()= 'Lozinka mora imati minimalno 8 karaktera.']")
	private WebElement lozinka1Por2;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[3]/div/p[text()= 'Potvrdite unesenu lozinku.']")
	private WebElement lozinka2Por;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[4]/div/p[text()= 'Ime je obavezno.']")
	private WebElement imePor;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[5]/div/p[text()= 'Prezime je obavezno.']")
	private WebElement prezimePor;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[6]/div/p[text()= 'Email je obavezan.']")
	private WebElement emailPor1;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-registracija/div/div[2]/form/div[6]/div/p[text()='Uneli ste nepostojecu email adresu.']")
	private WebElement emailPor2;
	
	 public RegistracijaPage(WebDriver driver) {
		this.driver = driver;
	}

	public void stranicaUcitana() {
	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(korIme));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(ime));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(prezime));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lozinka1));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lozinka2));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((registrujDugme)));
		
	}
	public void kratkaLozinkaPoruka() {
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lozinka1Por2));
		
		
	}
	
public void nepounjenaPoljaPoruke() {
		
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(korImePor));
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lozinka1Por1));
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lozinka2Por));
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(imePor));
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(prezimePor));
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(emailPor1));
		
		
	}
	public void nepostojeciMailPoruka() {
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(emailPor2));
		
		
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getKorIme() {
		return korIme;
	}

	public WebElement getLozinka1() {
		return lozinka1;
	}

	public WebElement getLozinka2() {
		return lozinka2;
	}

	public WebElement getIme() {
		return ime;
	}

	public WebElement getPrezime() {
		return prezime;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getRegistrujDugme() {
		return registrujDugme;
	}

	public WebElement getKorImePor() {
		return korImePor;
	}

	public WebElement getLozinka1Por1() {
		return lozinka1Por1;
	}

	public WebElement getLozinka1Por2() {
		return lozinka1Por2;
	}

	public WebElement getLozinka2Por() {
		return lozinka2Por;
	}

	public WebElement getImePor() {
		return imePor;
	}

	public WebElement getPrezimePor() {
		return prezimePor;
	}

	public WebElement getEmailPor1() {
		return emailPor1;
	}

	public WebElement getEmailPor2() {
		return emailPor2;
	}
	
	
	

}
