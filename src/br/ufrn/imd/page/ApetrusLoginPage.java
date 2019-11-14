package br.ufrn.imd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")	
public class ApetrusLoginPage {
	
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Atenção!'])[1]/following::input[1]")
	private WebElement inputLogin;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Atenção!'])[1]/following::input[2]")
	private WebElement inputSenha;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Alterar'])[1]/following::div[3]")
	private WebElement botaoEntrar;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Seguir como:'])[1]/following::div[4]")
	private WebElement botaoContinuar;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='A chave deve ter 6 dígitos, contendo letras e/ou números'])[1]/following::div[2]")
	private WebElement botaoChaveAbastecimento;

	private String urlBase = "https://teste-app.apetrus.com.br/";

	public ApetrusLoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(urlBase);
		PageFactory.initElements(driver, this);
	}

	public void fazerLogin(String login, String senha){
		inputLogin.clear();
		inputLogin.sendKeys(login);
		inputSenha.clear();
		inputSenha.sendKeys(senha);
		botaoEntrar.click();
		botaoContinuar.click();
		botaoChaveAbastecimento.click();
	}
}
