package br.ufrn.imd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")	
public class ApetrusHomePage {
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Dependentes'])[1]/following::div[4]")
	private WebElement botaoVeiculos;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Ajuda'])[1]/following::i[2]")
	private WebElement menuLateral; 
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Ativar Notificações push'])[1]/following::span[2]")
	private WebElement usuarioLogado;
	
	public ApetrusHomePage(WebDriver driver, String login, String senha) {
		this.driver = driver;
		ApetrusLoginPage loginPage = new ApetrusLoginPage(driver);
		loginPage.fazerLogin(login, senha);
		PageFactory.initElements(driver, this);
	}
	
	public ApetrusVeiculosPage abrirPaginaVeiculos() {
		menuLateral.click();
		return new ApetrusVeiculosPage(driver, null, null);
	}
	
	public boolean usuarioLogado(String login) {
		menuLateral.click();
		return usuarioLogado.getText().contains(login);
	}

}
