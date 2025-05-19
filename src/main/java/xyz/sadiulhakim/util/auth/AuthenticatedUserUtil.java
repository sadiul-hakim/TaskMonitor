package xyz.sadiulhakim.util.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class AuthenticatedUserUtil {
    private AuthenticatedUserUtil() {
    }

    public final static String NAME = "name";
    public final static String VERIFIED = "email_verified";
    public final static String ISS = "iss";
    public final static String SUB = "sub";
    public final static String NONCE = "nonce";
    public final static String PICTURE = "picture";
    public final static String EMAIL = "email";
    public final static String FAMILY_NAME = "family_name";

    public static String get(String key) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof OAuth2User user) {
            return user.getAttribute(key);
        }
        return "";
    }
}
