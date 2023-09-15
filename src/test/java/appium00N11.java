import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class appium00N11 {


    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "GorkemDevice");
        capabilities.setCapability("appium:app", "D:\\TechProEducation\\Appium\\n11_15.2.0_Apkpure.apk");
        capabilities.setCapability("appium:appPackage", "com.dmall.mfandroid");
        capabilities.setCapability("appium:aapActivity", "com.dmall.mfandroid.activity.base.NHomeActivity");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app installed");
        Thread.sleep(4000);
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.dmall.mfandroid:id/tvHomeSearchBar']").click();
        driver.findElementById("com.dmall.mfandroid:id/etSearch").sendKeys("Telefon",Keys.ENTER);
        driver.findElementById("com.dmall.mfandroid:id/etSearch").sendKeys(Keys.ENTER);
        System.out.println("app started");
        Thread.sleep(4000);
        //  driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/text1' and @text='API Demos']").click();
        System.out.println("app entered");

        List<MobileElement> productList = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivImage']"));
productList.get(0).click();
    }
}