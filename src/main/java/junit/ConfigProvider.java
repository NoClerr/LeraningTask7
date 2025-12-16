package junit;

import java.util.ResourceBundle;

public class ConfigProvider {

    private static final ResourceBundle config = ResourceBundle.getBundle("authconfig");

    public static String getUsername() {
        return config.getString("user.username");
    }
    public static String getUserPassword() {
        return config.getString("user.password");
    }
    public static String getBaseUrl() {
        return config.getString("base.url");
    }
    public static String getBrowser() {
        return config.getString("browser");
    }
    public static String getBrowserSize() {
        return config.getString("browser.size");
    }
    public static long getTimeout() {
        return Long.parseLong(config.getString("timeout"));
    }
    public static long getPageLoadTimeout() {
        return Long.parseLong(config.getString("page.load.timeout"));
    }
}
