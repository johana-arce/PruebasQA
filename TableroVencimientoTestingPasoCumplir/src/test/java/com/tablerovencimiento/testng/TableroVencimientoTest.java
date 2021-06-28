package com.tablerovencimiento.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TableroVencimientoTest {
	
  private WebDriver driver;
  By usuarioLocator = By.id("username");
  By contraLocator = By.id("password");
  By iniciarSesionBtnLocator = By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/form/button");
  
  By nombreUsuario = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[1]/app-userblock/div/div[2]/p");
  By tablerosLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/a/span");
  By vencimientoLocator = By.xpath("/html/body/app-root/app-layout/div/app-sidebar/div/nav/ul/li[2]/ul/li[2]/a/span");
  
  By obligacionLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[1]/div[1]/div[10]/ngx-select/div/div[2]/div/span[1]/span");
  By opIVALocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[1]/div[1]/div[10]/ngx-select/div/ul/li[55]/a/span");
  
  By selectCheckbox = By.xpath("/descendant::*[@id=\"check[object Object]\"][32]");
  By accionesLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[2]/div[1]/button");
  By opcumplirLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[1]/div[2]/div[1]/div/a[5]");
  
  By cumplirBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[2]/div");
  By aceptarBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div[2]/button");
  By textoErrorLocator = By.xpath("/html/body/div[2]/div/div[2]");
  By okBtnLocator = By.xpath("/html/body/div[2]/div/div[4]/div/button");
  
  By subirBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[1]/div/div[1]/app-documentacion[3]/table/tr/td/app-documento/div/div/div/div[2]/div/a[1]/label/em");
  By eliminarDDJJBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[1]/div/div[1]/app-documentacion[1]/table/tr/td/app-documento/div/div/div[3]/div[1]/a");
  By eliminarAcuseBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[1]/div/div[1]/app-documentacion[3]/table/tr/td/app-documento/div/div/div[3]/div[1]/a");
  By eliminarVepBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[1]/div/div[1]/app-documentacion[2]/table/tr/td/app-documento/div/div/div[3]/div[1]/a");
  By eliminarAsientoBtnLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[7]/div/div/div[2]/div[1]/div/div[1]/app-documentacion[4]/table/tr/td/app-documento/div/div/div[3]/div[1]/a");
  
  By estadoLocator = By.xpath("/html/body/app-root/app-layout/div/section/div/app-tablero/div[1]/div/div/div[3]/table/tbody/tr[32]/td[5]/div");
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://app.tga.sige.development.s3-website.us-east-2.amazonaws.com/#/login");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  

  @Test
  public void testFlujo1() throws InterruptedException {
	  driver.findElement(usuarioLocator).sendKeys("0005");
	  driver.findElement(contraLocator).sendKeys("Merce1234");
	  driver.findElement(iniciarSesionBtnLocator).click();
	  //Una vez que inicio sesión
	  assertEquals(driver.findElement(nombreUsuario).getText(), "PELEGRINA, FEDERICO GABRIEL");
	  
	  WebDriverWait ewait = new WebDriverWait(driver, 10);
	  ewait.until(ExpectedConditions.presenceOfElementLocated(tablerosLocator));
	  driver.findElement(tablerosLocator).click();
	  driver.findElement(vencimientoLocator).click();
	  
	  ewait.until(ExpectedConditions.presenceOfElementLocated(obligacionLocator));
	  driver.findElement(obligacionLocator).click();
	  driver.findElement(opIVALocator).click();
	  
	  //Selecciona un elemento de la lista
	  driver.findElement(selectCheckbox).click();
	  ewait.until(ExpectedConditions.presenceOfElementLocated(accionesLocator));
	  driver.findElement(accionesLocator).click();
	  ewait.until(ExpectedConditions.presenceOfElementLocated(opcumplirLocator));
	  driver.findElement(opcumplirLocator).click();
	  
	  boolean ddjj, acuse, vep, asiento;
	  ddjj=visible(eliminarDDJJBtnLocator);
	  acuse=visible(eliminarAcuseBtnLocator);
	  vep=visible(eliminarVepBtnLocator);
	  asiento=visible(eliminarAsientoBtnLocator);
	  System.out.println(ddjj+" "+acuse+" "+vep+" "+asiento);
	  ewait.until(ExpectedConditions.presenceOfElementLocated(cumplirBtnLocator));
	  driver.findElement(cumplirBtnLocator).click();
	  ewait.until(ExpectedConditions.presenceOfElementLocated(aceptarBtnLocator));
	  driver.findElement(aceptarBtnLocator).click();
	  Thread.sleep(3000);
	  
	  if (ddjj||acuse||vep||asiento) {
		  System.out.print("El botón es visible");
		  driver.navigate().refresh();
		  ewait.until(ExpectedConditions.presenceOfElementLocated(estadoLocator));
		  assertEquals(driver.findElement(estadoLocator).getText(), "CUMPLIDO");
	  }
	  else {
		  System.out.print("El botón NO es visible");
		  assertEquals(driver.findElement(textoErrorLocator).getText(), "Lo sentimos");
		  driver.findElement(okBtnLocator).click();
		  assertEquals(driver.findElement(estadoLocator).getText(), "A VENCER");
	  }
  }
  
  public boolean visible(By a) {
	  try {
		  return driver.findElement(a).isDisplayed();
	  }
	  catch (Exception e){
		  return false;
	  }
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
}
