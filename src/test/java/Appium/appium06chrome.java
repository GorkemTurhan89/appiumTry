package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class appium06chrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        //https://chormedriver.storage.googleapis.com/index.html
        //buradan driver versiyonunuzu indirebiirsiniz
        capabilities.setCapability("chromedriverExecutable", "C:\\java\\javademos\\AppiumTechpro1\\src\\Apps\\chromedriver.exe");
        //   capabilities.setCapability("appPackage", "com.android.chrome");
        //   capabilities.setCapability("aapActivity", "com.android.chrome/com.google.android.apps.chrome.Main");

        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }
        System.out.println("app yuklendi");


        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        System.out.println(driver.getContext()+"<=== app content type");
        Set<String>allContents = driver.getContextHandles();
        for (String type : allContents){
            System.out.println(type);
            if(type.contains("WEBVIEW_chrome")){
                driver.context(type);
            }
        }
        System.out.println(driver.getContext());

        MobileElement amazonButton = driver.findElementByXPath("//a[@id='nav-logo-sprites']");

        assertTrue(amazonButton.isEnabled());
        System.out.println("Anasayfadayiz");
        Thread.sleep(6000);
        //
        //

        MobileElement signInButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        signInButton.click();
      Thread.sleep(6000);

        MobileElement greetingMessage = driver.findElementByXPath("//div[@id='outer-accordion-signin-signup-page']//h2");
        assertTrue(greetingMessage.isDisplayed());

        //nasıl locate alabiliriz orneklendirmedir

       // driver.findElementByAndroidUIAutomator("UiSelector().resourseId(\"com.android.chrome:id/nav-logobar-greeting\")").click();
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"\"")
    }
}
