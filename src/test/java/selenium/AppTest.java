package selenium;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

 

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void test_selenium_paga_impuesto() {
       
       System.out.println("//TEST-Paga-Impuesto salario $1.600.000 //");
        driver.get("http://104.198.16.132/");
        driver.manage().window().setSize(new Dimension(1216, 680));
      
        driver.findElement(By.id("mat-input-0")).sendKeys("20000000");
     
        {
          WebElement element = driver.findElement(By.cssSelector(".mat-focus-indicator"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("mat-input-1")).sendKeys("1600000");
        driver.findElement(By.xpath("//mat-icon")).click();
        //espera que aparezcan las etiquetas
        {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-2")));
          }
          {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-3")));
          }
          {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-4")));
          }
          {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-5")));
          }
          {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-6")));
          }
        
        {
          WebElement element = driver.findElement(By.xpath("//mat-icon"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        
          
         
        {
          String value = driver.findElement(By.id("mat-input-2")).getAttribute("value");
          assertThat(value, is("18000000"));
        }
       
        {
          String value = driver.findElement(By.id("mat-input-3")).getAttribute("value");
          assertThat(value, is("1600000"));
        }
       
        {
          String value = driver.findElement(By.id("mat-input-4")).getAttribute("value");
          assertThat(value, is("2000000"));
        }
       
        {
          String value = driver.findElement(By.id("mat-input-5")).getAttribute("value");
          assertThat(value, is("16000000"));
        }
        {
          String value = driver.findElement(By.id("mat-input-6")).getAttribute("value");
          assertThat(value, is("160000"));
        }

        //calculando si factor de impuesto esta entre 0,04 y 0,4
        String dxc=driver.findElement(By.id("mat-input-4")).getAttribute("value");
        String impuesto=driver.findElement(By.id("mat-input-6")).getAttribute("value");
        double factor=Double.parseDouble(impuesto)/Double.parseDouble(dxc);
        assertTrue("Evaluendo si factor es mayor 0.04", factor >= 0.04);
        assertTrue("Evaluendo si factor es menor o igual 0.04", factor<= 0.4);
        
       
        
        driver.close();
      }
     @Test
    public void test_selenium_sin_impuesto() {
       
        System.out.println("//TEST-sin-Impuesto salario $600.000 //");
         driver.get("http://104.198.16.132/");
         driver.manage().window().setSize(new Dimension(1216, 680));
      
         driver.findElement(By.id("mat-input-0")).sendKeys("10000000");
       
         {
           WebElement element = driver.findElement(By.cssSelector(".mat-focus-indicator"));
           Actions builder = new Actions(driver);
           builder.moveToElement(element).perform();
         }
         {
           WebElement element = driver.findElement(By.tagName("body"));
           Actions builder = new Actions(driver);
           builder.moveToElement(element, 0, 0).perform();
         }
         driver.findElement(By.id("mat-input-1")).sendKeys("600000");
         driver.findElement(By.xpath("//mat-icon")).click();
         //espera que aparezcan las etiquetas
         {
             WebDriverWait wait = new WebDriverWait(driver, 6);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-2")));
           }
           {
             WebDriverWait wait = new WebDriverWait(driver, 6);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-3")));
           }
           {
             WebDriverWait wait = new WebDriverWait(driver, 6);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-4")));
           }
           {
             WebDriverWait wait = new WebDriverWait(driver, 6);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-5")));
           }
           {
             WebDriverWait wait = new WebDriverWait(driver, 6);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-6")));
           }
         
         {
           WebElement element = driver.findElement(By.xpath("//mat-icon"));
           Actions builder = new Actions(driver);
           builder.moveToElement(element).perform();
         }
         {
           WebElement element = driver.findElement(By.tagName("body"));
           Actions builder = new Actions(driver);
           builder.moveToElement(element, 0, 0).perform();
         }
         
 
          
         {
           String value = driver.findElement(By.id("mat-input-2")).getAttribute("value");
           assertThat(value, is("9000000"));
         }
        
         {
           String value = driver.findElement(By.id("mat-input-3")).getAttribute("value");
           assertThat(value, is("600000"));
         }
        
         {
           String value = driver.findElement(By.id("mat-input-4")).getAttribute("value");
           assertThat(value, is("1000000"));
         }
        
         {
           String value = driver.findElement(By.id("mat-input-5")).getAttribute("value");
           assertThat(value, is("8000000"));
         }
      {
           String value = driver.findElement(By.id("mat-input-6")).getAttribute("value");
           //comprueba que no debe pagar impuesto en el retiro de su 10% ya que su igreso es por debajo de $1.500.000
           assertThat(value, is("0"));
         }
 
         driver.close();
       }
   
}


