package junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import pages.LoginPage;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
         new LoginPage()
           .open()
                .setUsername("pozitiv971@gmail.com")
                .setPassword("U6r-F7X-knS-AbS")
                .clickLogin();


    }
}