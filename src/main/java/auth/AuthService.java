package auth;

import junit.ConfigProvider;
import pages.LoginPage;

public class AuthService {

    public static void loginDefaultUser() {
        new LoginPage()
                .loginAs(
                        ConfigProvider.getUsername(),
                        ConfigProvider.getUserPassword()
                );
    }
}
