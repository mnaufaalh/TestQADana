package global;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class BaseClass {
    public static AppiumDriver driver;

    public static DesiredCapabilities initDevice(){
        File filepath = new File(System.getProperty("user.dir"));
        File app = new File(filepath, "/apk/TODOApp (1).apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("app", app.getAbsolutePath());
        cap.setCapability("autoGrantPermissions","true");
        cap.setCapability("noReset","true");
        return cap;
    }

    public static void openApps() throws Exception {
        String appiumServerURL = "http://localhost:4723/wd/hub";
        driver = new AppiumDriver(new URL(appiumServerURL), initDevice());
    }

    public static void closeApps(){
        driver.closeApp();
    }
}
