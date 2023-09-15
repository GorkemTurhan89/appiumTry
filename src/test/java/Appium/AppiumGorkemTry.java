package Appium;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumGorkemTry {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        capabilities.setCapability("chromedriverExecutable", "C:\\java\\javademos\\AppiumTechpro1\\src\\Apps\\chromedriver.exe");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        System.out.println("Chrome opened");
        Thread.sleep(2000);


driver.get("https://techproeducation.com/");

        Thread.sleep(5000);

        System.out.println("EDevlet yuklendi");


        int startX = driver.manage().window().getSize().width / 2;
        int startY = driver.manage().window().getSize().height *2/7;
        int endX = startX;
        int endY = driver.manage().window().getSize().height *6/7;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Wait for 1000 milliseconds (1 second)
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

        try {
            // Initialize the AndroidDriver


            // Perform the swipe action using TouchAction


            // Close the driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("swiped");
    }



    }







