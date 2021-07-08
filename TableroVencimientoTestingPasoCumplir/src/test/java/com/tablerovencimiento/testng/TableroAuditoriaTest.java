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

public class TableroAuditoriaTest {
	private WebDriver driver;
	By usuarioLocator = By.id("username");
	By contraLocator = By.id("password");
	By iniciarSesionBtnLocator = By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/form/button");

	By nombreUsuario = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[1]/app-userblock/div/div[2]/p");
	By tablerosLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/a/span");
	By auditoriaLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/ul/li[5]/a");

	By cerradoBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div/div[2]/label[3]");
	By selectObligacionLocator = By.xpath("//*[@id=\"radios[object Object]\"]");
	By clienteLocator = By.xpath("//*[@id=\"table-ext-1\"]/tbody/tr[1]/td[3]/div");
	
	By accionesBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div/div[1]/button[4]");
	By eliminarCorteLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div/div[1]/div/a[7]");
	
	By eliminarBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div[2]/button");
	
	By msgErrorLocator = By.xpath("//div[@class='swal-title']");
	By okBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div/button");
	
	By abiertoBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div/div[2]/label[2]");
	
	By cierreDesdeBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/form/div/div[1]/div[12]/div[1]/div/div/button");
	By diciembreLoactor = By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-month-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[4]/td[3]/span");
	By cierreHastaBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/form/div/div[1]/div[12]/div[2]/div/div/button");
	By siguienteAñoLocator = By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-month-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]");
	By diciembre2022Locator = By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-month-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[4]/td[3]/span");
	By selectAbiertoLocator = By.xpath("//*[@id=\"radios[object Object]\"]");
	By eliminarCorteAbiertoLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div/div[1]/div/a[8]");
	
	
	@Test
	public void testFlujo3() throws InterruptedException {
		String cliente;
		// Inicia sesión
		driver.findElement(usuarioLocator).sendKeys("0004");
		driver.findElement(contraLocator).sendKeys("Maxi8817");
		driver.findElement(iniciarSesionBtnLocator).click();
		// Una vez que inicio sesión verifica el usuario
		assertEquals(driver.findElement(nombreUsuario).getText(), "MATEU, SILVIA NOEMÍ");

		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(tablerosLocator));
		driver.findElement(tablerosLocator).click();
		ewait.until(ExpectedConditions.presenceOfElementLocated(auditoriaLocator));
		driver.findElement(auditoriaLocator).click();
		
		//Filtrar por cerrado
		Thread.sleep(2000);
		ewait.until(ExpectedConditions.presenceOfElementLocated(cerradoBtnLocator));
		driver.findElement(cerradoBtnLocator).click();
		Thread.sleep(2000);
		ewait.until(ExpectedConditions.presenceOfElementLocated(selectObligacionLocator));
		driver.findElement(selectObligacionLocator).click();
		
		//Eliminar
		driver.findElement(accionesBtnLocator).click();
		driver.findElement(eliminarCorteLocator).click();
		ewait.until(ExpectedConditions.presenceOfElementLocated(eliminarBtnLocator));
		driver.findElement(eliminarBtnLocator).click();
		Thread.sleep(4000);
		ewait.until(ExpectedConditions.presenceOfElementLocated(okBtnLocator));
		System.out.println(driver.findElement(msgErrorLocator).getText());
		assertEquals(driver.findElement(msgErrorLocator).getText(), "¡Lo sentimos!");
		driver.findElement(okBtnLocator).click();
		
		//Filtrar por Abierto
		driver.findElement(abiertoBtnLocator).click();
		
		//Seleccionar entre fechas
		driver.findElement(cierreDesdeBtnLocator).click();
		driver.findElement(diciembreLoactor).click();
		driver.findElement(cierreHastaBtnLocator).click();
		driver.findElement(cierreHastaBtnLocator).click();
		ewait.until(ExpectedConditions.presenceOfElementLocated(siguienteAñoLocator));
		driver.findElement(siguienteAñoLocator).click();
		driver.findElement(diciembre2022Locator).click();
		Thread.sleep(2000);
		ewait.until(ExpectedConditions.presenceOfElementLocated(selectObligacionLocator));
		driver.findElement(selectObligacionLocator).click();
		cliente=driver.findElement(clienteLocator).getText();
		
		//Eliminar
		driver.findElement(accionesBtnLocator).click();
		
		driver.findElement(eliminarCorteAbiertoLocator).click();
		ewait.until(ExpectedConditions.presenceOfElementLocated(eliminarBtnLocator));
		driver.findElement(eliminarBtnLocator).click();
		Thread.sleep(4000);
		ewait.until(ExpectedConditions.presenceOfElementLocated(okBtnLocator));
		assertEquals(driver.findElement(clienteLocator).getText(), cliente);
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
	}

}
