package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class appium05 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\\\TechProEducation\\\\Appium\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("aapActivity", "com.google.android.calculator/com.android.calculator2.Calculator");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("app yuklendi");


        System.out.println("Permittion Granted Blo");
        Thread.sleep(5000);
        MobileElement number1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        System.out.println("Digital 1");
        MobileElement number2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        System.out.println("Digital 2");
        MobileElement number3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement number4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement number5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement number6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement number7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement number8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement number9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement number0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement point = driver.findElementById("com.google.android.calculator:id/dec_point");

        MobileElement delete = driver.findElementById("com.google.android.calculator:id/del");
        MobileElement plus = driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement sub = driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement multiply = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement divide = driver.findElementById("com.google.android.calculator:id/op_div");

        MobileElement percent = driver.findElementById("com.google.android.calculator:id/op_pct");
        MobileElement equals = driver.findElementById("com.google.android.calculator:id/eq");
        MobileElement result_preview = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("Point");

        MobileElement formula = driver.findElementById("com.google.android.calculator:id/formula");

        System.out.println("Permittion Granted Blo");
        number5.click();number5.click();
        System.out.println("Permittion Granted Blo");
        assertTrue(formula.getText().contains("55"));
        plus.click();number1.click();number5.click();
        assertTrue(formula.getText().contains("55+15"));
        assertTrue(result_preview.getText().contains("70"));

        equals.click();
        MobileElement result_final = driver.findElementById("com.google.android.calculator:id/result_final");
        assertTrue(result_final.getText().contains("70"));

        //
        //
    }
}
