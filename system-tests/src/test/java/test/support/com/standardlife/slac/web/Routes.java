package test.support.com.standardlife.slac.web;

import test.support.com.standardlife.slac.web.page.PoliciesPage;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static test.support.com.standardlife.slac.web.Environment.contextPath;
import static test.support.com.standardlife.slac.web.Environment.serverHost;
import static test.support.com.standardlife.slac.web.Environment.serverPort;

public final class Routes {

    private static Map<Class<?>, String> urlMappings = new HashMap<Class<?>, String>();

    static {
        urlMappings.put(PoliciesPage.class, "/policy");
    }

    private Routes() {
    }

    public static String urlFor(Class<?> pageClass) {
        return format("http://%s:%s%s%s", serverHost(), serverPort(), contextPath(), path(pageClass));
    }

    private static String path(Class<?> pageClass) {
        return urlMappings.get(pageClass);
    }
}
