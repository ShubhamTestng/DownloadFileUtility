package fileDownload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadFile {

	@Test
	public void downloadfile() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://developer.android.com/studio");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='devsite-dialog-button button button-primary']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='agree_studio_win_notools_exe_download']")).click();
		
		//a[@id='agree-button__studio_linux_bundle_download']
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='https://redirector.gvt1.com/edgedl/android/studio/install/2024.1.1.12/android-studio-2024.1.1.12-windows.exe']")).click();
		
		driver.get("chrome://downloads/");
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement downloadButton = (WebElement) js.executeScript(
                "return document.querySelector('downloads-manager').shadowRoot.querySelector('iron-list > downloads-item').shadowRoot.querySelector('cr-icon-button');"
        );
        
        downloadButton.click();
        
        Thread.sleep(5000);
        
        WebElement saveDangerousButton = (WebElement) js.executeScript(
                "return document.querySelector('body > downloads-manager')" +
                ".shadowRoot.querySelector('#frb0').shadowRoot.querySelector('#save-dangerous');"
            );
        
        saveDangerousButton.click();
        
	}
}
