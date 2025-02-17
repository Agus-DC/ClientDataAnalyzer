package com.challenge.client;

import lombok.experimental.UtilityClass;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@UtilityClass
public class AppConfig {

    private static final String LOCAL_SCOPE = "local";
    private static final String PROFILES_ACTIVE_KEY = "spring.profiles.active";

    public static void configureProfile() {
        String scope = getEnvVar("SCOPE");
        scope = scope == null ? LOCAL_SCOPE : scope.toLowerCase(Locale.ROOT);
        List<String> scopes = Arrays.asList(scope.split("-"));
        scope = scopes.get(scopes.size() - 1);

        setProperty(PROFILES_ACTIVE_KEY, switch (scope) {
            case "prod" -> scope;
            default -> LOCAL_SCOPE;
        });
    }

    public static String getEnvVar(String name) {
        return System.getenv(name);
    }

    public static void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    public String getProperty(String key) {
        return System.getProperty(key);
    }

    public String getActualScope() {
        return getProperty(PROFILES_ACTIVE_KEY);
    }
}
