package runner;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunnerSite {

	static WebDriver driver;
	
	@Before
	public void AbrirNavegador(){
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void test() throws InterruptedException{
		//teste 1 Acessar o Site: www.automationpractice.com
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		JavascriptExecutor rolatela = (JavascriptExecutor)driver;
		rolatela.executeScript("window.scrollBy(0,750)");
		Thread.sleep(1000);
		//Teste2 Escolha um produto qualquer na loja
		driver.findElement(By.xpath("//img[@title='Blouse']")).click();
		//Teste3 Adicione o produto escolhido ao carrinho
		rolatela.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);		
		driver.findElement(By.id("add_to_cart")).click();
		//Teste4 Prossiga para o checkout
		rolatela.executeScript("window.scrollBy(0,250)");	
		Thread.sleep(5000);
		//Teste5 Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo
		rolatela.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();		
		rolatela.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();		
		//Teste6 Realizar o cadastro do cliente preenchendo todos os campos obrigatórios dos formulários
		Thread.sleep(5000);
		rolatela.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.id("email_create")).click();
		driver.findElement(By.id("email_create")).sendKeys("teste2042@teste.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Saulo");
		driver.findElement(By.id("customer_lastname")).sendKeys("Pascoalino");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.xpath("//select[@id='days']/option[4]")).click();
		driver.findElement(By.xpath("//select[@id='months']/option[5]")).click();
		driver.findElement(By.id("years")).click();
		driver.findElement(By.xpath("//select[@id='years']/option[34]")).click();		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("address1")).sendKeys("218 W Centre St, 49 apartment, Baltimore, MD");
		driver.findElement(By.id("address2")).sendKeys("49 apartment");
		driver.findElement(By.id("city")).sendKeys("Baltimore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='id_state']/option[21]")).click();
		driver.findElement(By.id("postcode")).sendKeys("10001");
		Thread.sleep(2000);
		driver.findElement(By.id("other")).sendKeys("Presente");	
		driver.findElement(By.id("phone")).sendKeys("1123452345");
		driver.findElement(By.id("phone_mobile")).sendKeys("1123452345");
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		rolatela.executeScript("window.scrollBy(0,450)");
		//Teste7 Valide se o endereço está correto e prossiga
		Thread.sleep(5000);
		rolatela.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button")).click();		
		Thread.sleep(2000);
		rolatela.executeScript("window.scrollBy(0,500)");
		//Teste8 Aceite os termos de serviço e prossiga.
		driver.findElement(By.id("cgv")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='form']/p/button")).click();		
		//Teste9 Valide o valor total da compra.
		rolatela.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		//Teste10 Selecione um método de pagamento e prossiga.
		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();		
		rolatela.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);				
		driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
		//teste11 Confirme a compra e valide se foi finalizada com sucesso.
		rolatela.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(20000);
		
		}
	
	@After
	public void teardown() throws Exception{
		driver.quit();
	}
}
