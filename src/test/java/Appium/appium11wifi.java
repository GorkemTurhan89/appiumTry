package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class appium11wifi {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\java\\javademos\\AppiumTechpro1\\src\\Apps\\API Demos for Android_1.9.0_Apkpure.apk");
        //  capabilities.setCapability("appPackage", "io.appium.android.apis");
        // capabilities.setCapability("aapActivity", "io.appium.android.apis/io.appium.android.apis.ApiDemos");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app installed");
        Thread.sleep(4000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos'][1]").click();
        System.out.println("app started");
        Thread.sleep(4000);
        //  driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/text1' and @text='API Demos']").click();
        System.out.println("app entered");

        Thread.sleep(4000);
        MobileElement preferences = driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Preference']");
        preferences.click();
        System.out.println("pref clicked");

        Thread.sleep(4000);
        MobileElement preferences3 = driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/text1' and @text='3. Preference dependencies']");
        preferences3.click();
        System.out.println("prep3 clicked");


        MobileElement  wifiCheckBox = driver.findElementByXPath("//android.widget.CheckBox[@resource-id='android:id/checkbox']");
        String isItTrue = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        if(isItTrue.contains("true")){
            System.out.println("Already checked");
        }else if(isItTrue.contains("false")){
            wifiCheckBox.click();
            System.out.println("Wifi checkbox checked");

        }


        System.out.println("Wifi checkbox checked");

        Thread.sleep(3000);
        MobileElement wifiSettings = driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']");
        wifiSettings.click();
        System.out.println("wifisetting clicked");

        Thread.sleep(4000);
        MobileElement wifiSendText = driver.findElementByXPath("//android.widget.EditText[@resource-id='android:id/edit']");
        wifiSendText.sendKeys("Text");
        System.out.println("text had sent");

        Thread.sleep(4000);
        MobileElement okButton = driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']");
        okButton.click();
        System.out.println("OK BUtton clicked");

        Thread.sleep(2000);
        wifiCheckBox.click();//checkbox closed

        driver.closeApp();
    }
}
