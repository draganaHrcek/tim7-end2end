package TIM7.end2end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IzmenaLozinkePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[4]/button[1]")
	private WebElement sacuvajDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[4]/button[2]")
	private WebElement otkaziDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[1]/input")
	private WebElement trenutnaLozinka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[2]/input")
	private WebElement novaLozinka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[3]/input")
	private WebElement ponovljenaNovaLozinka;
	

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[1]/div/p[text()='Unesite trenutnu lozinku.']")
	private WebElement trenutnaLozinkaPoruka;
	
	@FindBy(xpath ="/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[2]/div/p[text()='Niste uneli novu lozinku.']")
	private WebElement novaLozinkaPoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[3]/div/p[text()='Morate ponoviti novu lozinku.']")
	private WebElement ponovljenaLoznikaPoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-izmena-lozinke/div/div[2]/form/div[2]/div/p[text()='Lozinka mora imati minimalno 8 karaktera.']")
	private WebElement kratkaNovaLozinkaPoruka;
	
	
	
	 public IzmenaLozinkePage(WebDriver driver) {
		this.driver = driver;
	}


	public void stranicaUcitana() {
		
	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((sacuvajDugme)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((otkaziDugme)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((trenutnaLozinka)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((novaLozinka)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf((ponovljenaNovaLozinka)));
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getSacuvajDugme() {
		return sacuvajDugme;
	}


	public WebElement getOtkaziDugme() {
		return otkaziDugme;
	}


	public WebElement getTrenutnaLozinka() {
		return trenutnaLozinka;
	}


	public WebElement getNovaLozinka() {
		return novaLozinka;
	}


	public WebElement getPonovljenaNovaLozinka() {
		return ponovljenaNovaLozinka;
	}


	public WebElement getTrenutnaLozinkaPoruka() {
		return trenutnaLozinkaPoruka;
	}


	public WebElement getNovaLozinkaPoruka() {
		return novaLozinkaPoruka;
	}


	public WebElement getPonovljenaLoznikaPoruka() {
		return ponovljenaLoznikaPoruka;
	}


	public WebElement getKratkaNovaLozinkaPoruka() {
		return kratkaNovaLozinkaPoruka;
	}

	
	
	

}
