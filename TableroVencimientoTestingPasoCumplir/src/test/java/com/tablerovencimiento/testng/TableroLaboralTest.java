package com.tablerovencimiento.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TableroLaboralTest {
	private WebDriver driver;
	By usuarioLocator = By.id("username");
	By contraLocator = By.id("password");
	By iniciarSesionBtnLocator = By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/form/button");

	By nombreUsuario = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[1]/app-userblock/div/div[2]/p");
	By tablerosLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/a/span");
	By laboralLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/ul/li[3]/a");

	By calendarioBtnLocator = By.id("inputGroupPrepend3");
	By retrocederBtnLocator = By.xpath("/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[1]");
	By dia1Locator = By.xpath("/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[2]/table/tbody/tr[1]/td[3]/span");
	By dia30Locator = By.xpath("/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[2]/table/tbody/tr[5]/td[4]/span");
	By consultarBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[1]/div[2]/button");
	
	By selectCheckbox = By.id("check4");
	By novedadesLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[5]/td[6]");
	By novedadesEscLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[3]/td[6]/div/app-date-inline-editable/div/input");
	By fechaLocator = By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[2]/td[6]/span");
	By preLiquidacionLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[3]/td[7]");
	
	By aceptarBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div[2]/button");
	
	By accionesLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[2]/div[1]/button");
	By opLiquidarLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[2]/div[1]/div/a[1]");
	By liquidarBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[2]/div/div/div[2]/div[3]/div/button");
	
	By errorTxtMsgLocator = By.xpath("/html/body/div[2]/div/div[2]");
	By okBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div/button");
    
	By envioPreLiqLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[3]/td[8]/div/app-date-inline-editable/div/input");
	By op2ObsLocator = By.xpath("//*[@id=\"plantilla1\"]");
	By comentarBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[5]/div/div/div[2]/app-observaciones/div[2]/div/button");
	
	By confirmacionLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[3]/td[9]/div/app-date-inline-editable/div/input");
	By liqDefLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[3]/td[10]/em");
	
	@Test
	public void testFlujo2Error() throws InterruptedException {
		  //Inicia sesión
		  driver.findElement(usuarioLocator).sendKeys("0055");
		  driver.findElement(contraLocator).sendKeys("Victo0810");
		  driver.findElement(iniciarSesionBtnLocator).click();
		  //Una vez que inicio sesión verifica el usuario
		  assertEquals(driver.findElement(nombreUsuario).getText(), "REINOSO VICTORIA");
		  
		  WebDriverWait ewait = new WebDriverWait(driver, 10);
		  ewait.until(ExpectedConditions.presenceOfElementLocated(tablerosLocator));
		  driver.findElement(tablerosLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(laboralLocator));
		  driver.findElement(laboralLocator).click();
		  
		  //Filtra el tablero Laboral por todo el mes de junio
		  ewait.until(ExpectedConditions.presenceOfElementLocated(calendarioBtnLocator));
		  driver.findElement(calendarioBtnLocator).click();
		  driver.findElement(retrocederBtnLocator).click();
		  driver.findElement(dia1Locator).click();
		  driver.findElement(dia30Locator).click();
		  driver.findElement(consultarBtnLocator).click();
		  
		  //Seleccionar una
		  ewait.until(ExpectedConditions.presenceOfElementLocated(selectCheckbox));
		  driver.findElement(selectCheckbox).click();
		  //driver.findElement(novedadesLocator).click();
		  driver.findElement(novedadesLocator).click();
		  driver.findElement(novedadesEscLocator).click();
		  driver.findElement(fechaLocator).click(); //Poner la fecha desde el calendario me da error
		  ewait.until(ExpectedConditions.presenceOfElementLocated(aceptarBtnLocator));
		  driver.findElement(aceptarBtnLocator).click();
		  System.out.println("Antes de Asserts");
		  Thread.sleep(2000);
		  //assertEquals(driver.findElement(novedadesLocator).getText(), "11/06/2021");
		  System.out.println("Entre los Asserts");
		  assertEquals(driver.findElement(preLiquidacionLocator).getText(), "15/06/2021");
		  System.out.println("Despues de los Asserts");
		  
		  //Liquidar, este intento va a fallar
		  driver.findElement(accionesLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(opLiquidarLocator));
		  driver.findElement(opLiquidarLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(liquidarBtnLocator));
		  driver.findElement(liquidarBtnLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(errorTxtMsgLocator));
		  assertEquals(driver.findElement(errorTxtMsgLocator).getText(), "Error");
		  
		//Agregar una observación
		  driver.findElement(envioPreLiqLocator).sendKeys("25/06/2021");
		  ewait.until(ExpectedConditions.presenceOfElementLocated(op2ObsLocator));
		  driver.findElement(op2ObsLocator).click();
		  driver.findElement(comentarBtnLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(aceptarBtnLocator));
		  driver.findElement(aceptarBtnLocator).click();		  
		  driver.findElement(confirmacionLocator).sendKeys("28/06/2021");
		  ewait.until(ExpectedConditions.presenceOfElementLocated(aceptarBtnLocator));
		  driver.findElement(aceptarBtnLocator).click();
		  
		  //Liquidar
		  driver.findElement(accionesLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(opLiquidarLocator));
		  driver.findElement(opLiquidarLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(liquidarBtnLocator));
		  driver.findElement(liquidarBtnLocator).click();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(aceptarBtnLocator));
		  driver.findElement(aceptarBtnLocator).click();
		  System.out.println(""+driver.findElement(liqDefLocator).isSelected());
	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://app.tga.sige.development.s3-website.us-east-2.amazonaws.com/#/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		//Vuelve todo a como estaba antes de la ejecución del test
		driver.findElement(okBtnLocator).click();
		driver.findElement(novedadesLocator).clear();
		driver.findElement(preLiquidacionLocator).clear();
		//driver.quit();
	}

}
