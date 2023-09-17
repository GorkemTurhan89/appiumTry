package Appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Appium12BrowserStackAndroid {
    @Test
    public void browserStackAndroid () throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //Set your acces credentials
        caps.setCapability("browserstack.user","gorkemturhan_10v4qN");
        caps.setCapability("browserstack.key","54QywyEYxyjhMYp4Y7Ms");

        //Set url of the application under test "bs://sample.app"
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Specify the device and os_version for testing

        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability("project","BrowserStack Samples");
        caps.setCapability("build","browserstack build");
        caps.setCapability("name","first_test");

        //Initialise the remote Webdriver using browserstack remote url
        //and desired capabilities defined above
        AndroidDriver<AndroidElement>driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"),caps);


        //Test Case for the BrowserStack sample Android app
        //if you have uploaded your app, update the test case here
        AndroidElement searchElement = (AndroidElement)   new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement)new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(MobileBy.
                AccessibilityId("org.wikipedia.alpha:id/search_src_text")));
insertTextElement.sendKeys("BrowserStack");
Thread.sleep(5000);
List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
assert(allProductsName.size()>0);














//invoke driver.quit after test is done to indicate that test is completed
        driver.quit();
    }
}
