package org.AITest.com.constants;

public class URLConstants {

    // Base application URL
    public static final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";

    // Specific page URLs
    public static final String LOGIN_PAGE_URL = BASE_URL + "/login";
    public static final String DASHBOARD_PAGE_URL = BASE_URL + "/dashboard";
    public static final String PROFILE_PAGE_URL = BASE_URL + "/profile";
    public static final String SETTINGS_PAGE_URL = BASE_URL + "/settings";

    // API Endpoints (if applicable)
    public static final String API_BASE_URL = BASE_URL + "/api";
    public static final String API_USER_ENDPOINT = API_BASE_URL + "/user";
    public static final String API_AUTH_ENDPOINT = API_BASE_URL + "/auth";

    // Private constructor to prevent instantiation
    private URLConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
