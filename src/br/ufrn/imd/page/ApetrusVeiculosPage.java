package br.ufrn.imd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")	
public class ApetrusVeiculosPage {
	
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Passageiro'])[3]/following::td[1]")
	private WebElement primeiroVeiculo;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Editar dados do veículo'])[2]/following::input[1]")
	private WebElement inputPlaca;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Cor do veículo:'])[2]/following::input[2]")
	private WebElement inputModelo;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Meus Veículos'])[1]/following::i[1]")
	private WebElement botaoNovoVeiculo;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Voltar'])[2]/following::div[2]")
	private WebElement salvarNovoVeiculo;
	
	public ApetrusVeiculosPage(WebDriver driver, String login, String senha) {
		this.driver = driver;
		ApetrusLoginPage loginPage = new ApetrusLoginPage(driver);
		loginPage.fazerLogin(login, senha);
		PageFactory.initElements(driver, this);
	}
	
	public void cadastrarVeiculo(String placa) {
		botaoNovoVeiculo.click();
		inputPlaca.click();
		inputPlaca.clear();
		inputPlaca.sendKeys("MZD5827");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editar dados do veículo'])[2]/following::div[16]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gasolina Aditivada'])[2]/following::div[5]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cor do veículo:'])[2]/following::div[31]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cor do veículo:'])[2]/following::i[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmar'])[2]/following::div[14]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gasolina'])[2]/following::div[11]")).click();
	    inputModelo.click();
	    inputModelo.clear();
	    inputModelo.sendKeys("Gol");
	    salvarNovoVeiculo.click();
	}
	
	public boolean ultimoVeiculo(String placa) {
		return primeiroVeiculo.getText().contains(placa);
	}
}
