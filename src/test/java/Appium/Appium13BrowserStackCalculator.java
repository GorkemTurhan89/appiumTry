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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Appium13BrowserStackCalculator {
    @Test
    public void browserStackAndroid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //Set your acces credentials
        caps.setCapability("browserstack.user", "gorkemturhan_10v4qN");
        caps.setCapability("browserstack.key", "54QywyEYxyjhMYp4Y7Ms");

        //Set url of the application under test "bs://sample.app"  "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c"
        caps.setCapability("app", "bs://a87894b0e9db051282c2d7b9e577216d91dd251e");

        //Specify the device and os_version for testing

        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");

        caps.setCapability("project", "BrowserStack Samples");
        caps.setCapability("build", "browserstack build");
        caps.setCapability("name", "second_test");

        //Initialise the remote Webdriver using browserstack remote url
        //and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);


       driver.findElementById("com.google.android.calculator:id/digit_5").click();
       Thread.sleep(5000);
       driver.findElementById("com.google.android.calculator:id/op_add");
       driver.findElementById("com.google.android.calculator:id/digit_5").click();
       Thread.sleep(4000);

       driver.findElementById("com.google.android.calculator:id/eq").click();
       Thread.sleep(4000);

        Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result_final").getText(),10);
        driver.quit();
    }
}