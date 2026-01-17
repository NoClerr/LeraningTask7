package junit;

import auth.AuthService;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        SelenoidConfig.setup();
        AuthService.loginDefaultUser();
    }
}
