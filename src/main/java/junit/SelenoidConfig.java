package junit;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class SelenoidConfig {

    private static boolean configured = false;

    public static void setup() {
        if (configured) return;
        configured = true;


        Configuration.remote = System.getProperty(
                "selenide.remote",
                "http://selenoid:4444/wd/hub"
        );

        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        Configuration.browserVersion = System.getProperty("selenide.browserVersion", "128.0");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", false);
            put("enableLog", true);
        }});

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        Configuration.browserCapabilities = capabilities;
    }
}
