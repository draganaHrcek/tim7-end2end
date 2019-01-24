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
	private WebElement dnevnaOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[1]/select/option[3]")
	private WebElement mesecnaOpcija;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[1]/select/option[4]")
	private WebElement godisnjaOpcija;
	
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/select/option[2]")
	private WebElement autobusOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/select/option[3]")
	private WebElement tramvajOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[2]/select/option[4]")
	private WebElement metroOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/select/option[2]")
	private WebElement gradskaOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/select/option[3]")
	private WebElement prigradskaOpcija;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-kupovina-karte/div/div/div[2]/div/form/div[3]/select/option[4]")
	private WebElement veternikOpcija;
	
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


	public WebElement getDnevnaOpcija() {
		return dnevnaOpcija;
	}


	public WebElement getMesecnaOpcija() {
		return mesecnaOpcija;
	}


	public WebElement getGodisnjaOpcija() {
		return godisnjaOpcija;
	}


	public WebElement getAutobusOpcija() {
		return autobusOpcija;
	}


	public WebElement getTramvajOpcija() {
		return tramvajOpcija;
	}


	public WebElement getMetroOpcija() {
		return metroOpcija;
	}


	public WebElement getGradskaOpcija() {
		return gradskaOpcija;
	}


	public WebElement getPrigradskaOpcija() {
		return prigradskaOpcija;
	}


	public WebElement getVeternikOpcija() {
		return veternikOpcija;
	}








}
