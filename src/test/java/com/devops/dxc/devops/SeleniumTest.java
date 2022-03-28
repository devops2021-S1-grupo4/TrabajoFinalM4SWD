package com.devops.dxc.devops;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/");
        driver.manage().window().maximize();

    }

    @Test
    public void dxc() {
        String mensajeRespuesta;

        driver.findElement(By.id("radioDxC")).click();
        driver.findElement(By.cssSelector("p:nth-child(1) > .form-control")).click();
        driver.findElement(By.id("sueldoInput")).sendKeys("1600000");
        driver.findElement(By.id("ahorroInput")).sendKeys("25000000");
        driver.findElement(By.cssSelector(".col:nth-child(1) > .btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("respuestaMensaje"))).click();

        mensajeRespuesta = driver.findElement(By.id("respuestaMensaje")).getText();
        assertEquals("El 10% que se obtendría es 2500000", mensajeRespuesta);
    }

    
    @Test
    public void testDiezxciento_menor() {
        String mensajeRespuesta;

        driver.findElement(By.id("radioDxC")).click();
        driver.findElement(By.cssSelector("p:nth-child(1) > .form-control")).click();
        driver.findElement(By.id("sueldoInput")).sendKeys("600000");
        driver.findElement(By.id("ahorroInput")).sendKeys("800000");
        driver.findElement(By.cssSelector(".col:nth-child(1) > .btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("respuestaMensaje"))).click();

        mensajeRespuesta = driver.findElement(By.id("respuestaMensaje")).getText();
        assertEquals("El 10% que se obtendría es 800000", mensajeRespuesta);
    }

    @Test
    public void saldo() {
        String mensajeRespuesta;

        driver.findElement(By.id("radioSaldo")).click();
        driver.findElement(By.cssSelector("p:nth-child(1) > .form-control")).click();
        driver.findElement(By.id("ahorroInput")).sendKeys("25000000");
        driver.findElement(By.cssSelector(".col:nth-child(1) > .btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("respuestaMensaje"))).click();

        mensajeRespuesta = driver.findElement(By.id("respuestaMensaje")).getText();
        assertEquals("El saldo restante que quedará luego de un posible retiro es 22500000", mensajeRespuesta);
    }


    @Test
    public void impuesto() {
        String mensajeRespuesta;

        driver.findElement(By.id("radioImpuesto")).click();
        driver.findElement(By.cssSelector("p:nth-child(1) > .form-control")).click();
        driver.findElement(By.id("sueldoInput")).sendKeys("1600000");
        driver.findElement(By.cssSelector(".col:nth-child(1) > .btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("respuestaMensaje"))).click();

        mensajeRespuesta = driver.findElement(By.id("respuestaMensaje")).getText();
        assertEquals("El impuesto asociado al retirar el monto máximo es 0.08", mensajeRespuesta);
    }

    @Test
    public void testImpuestoborde() {
        String mensajeRespuesta;

        driver.findElement(By.id("radioImpuesto")).click();
        driver.findElement(By.cssSelector("p:nth-child(1) > .form-control")).click();
        driver.findElement(By.id("sueldoInput")).sendKeys("16794000");
        driver.findElement(By.cssSelector(".col:nth-child(1) > .btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("respuestaMensaje"))).click();

        mensajeRespuesta = driver.findElement(By.id("respuestaMensaje")).getText();
        assertEquals("El impuesto asociado al retirar el monto máximo es 0.4", mensajeRespuesta);
    }

}
