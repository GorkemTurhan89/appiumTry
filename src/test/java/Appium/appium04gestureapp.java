package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class appium04gestureapp {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\java\\javademos\\AppiumTechpro1\\src\\Apps\\Gesture Tool_1.3_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("aapActivity", "com.davemac327.gesture.tool/com.devamac327.gesture.tool.GestureBuilderActivity");
capabilities.setCapability("noReset","true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("app yuklendi");



        System.out.println("Permittion Granted Blo");
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        assertTrue(homeScreenTitle.isDisplayed());

        System.out.println("Home pagee openned");

        MobileElement addButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addButton.click();
        Thread.sleep(2000);

        MobileElement gestureName = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        gestureName.click();

        driver.closeApp();
    }
}
