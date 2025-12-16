package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext context)  {
        Configuration.baseUrl = ConfigProvider.getBaseUrl();
        Configuration.browser = ConfigProvider.getBrowser();
        Configuration.browserSize = ConfigProvider.getBrowserSize();
        Configuration.timeout = ConfigProvider.getTimeout();
        Configuration.pageLoadTimeout = ConfigProvider.getPageLoadTimeout();
    }

        @Override
    public void afterEach(ExtensionContext context)  {
        Selenide.closeWebDriver();
    }
}