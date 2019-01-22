package TIM7.end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KupovinaKartePage {
WebDriver driver;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[4]/button[1]")
	private WebElement kupiDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[1]/select/option[2]")
	private WebElement select1Opcija1;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/select/option[2]")
	private WebElement select2Opcija1;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/select/option[2]")
	private WebElement select3Opcija1;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[4]/button[2]")
	private WebElement otkaziDugme;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[1]/select")
	private WebElement tipKarte;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/select")
	private WebElement tipPrevoza;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/select")
	private WebElement linijaZona;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[1]/div/p[text()='Tip karte je obavezan.']")
	private WebElement tipKartePoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/div/p[text()='Vrsta prevoza obavezna.']")
	private WebElement tipPrevozaPoruka;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/div/p[text()='Linij/Zona su obavezni.']")
	private WebElement linijaZonaPoruka;
	
	
	 public KupovinaKartePage(WebDriver driver) {
		this.driver = driver;
	}


	public void stranicaUcitana() {
	
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable((kupiDugme)));
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable((otkaziDugme)));
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf((tipKarte)));
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf((tipPrevoza)));
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getKupiDugme() {
		return kupiDugme;
	}


	public WebElement getOtkaziDugme() {
		return otkaziDugme;
	}


	public WebElement getTipKarte() {
		return tipKarte;
	}


	public WebElement getTipPrevoza() {
		return tipPrevoza;
	}


	public WebElement getLinijaZona() {
		return linijaZona;
	}


	public WebElement getTipKartePoruka() {
		return tipKartePoruka;
	}


	public WebElement getTipPrevozaPoruka() {
		return tipPrevozaPoruka;
	}


	public WebElement getLinijaZonaPoruka() {
		return linijaZonaPoruka;
	}


	public WebElement getSelect1Opcija1() {
		return select1Opcija1;
	}


	public WebElement getSelect2Opcija1() {
		return select2Opcija1;
	}


	public WebElement getSelect3Opcija1() {
		return select3Opcija1;
	}





}
