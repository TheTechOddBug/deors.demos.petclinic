package org.springframework.samples.petclinic.it;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumITBase {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumITBase.class);

    protected static boolean RUN_HTMLUNIT;

    protected static boolean RUN_IE;

    protected static boolean RUN_EDGE;

    protected static boolean RUN_FIREFOX;

    protected static boolean RUN_CHROME;

    protected static boolean RUN_OPERA;

    protected static String SELENIUM_HUB_URL;

    protected static String TARGET_SERVER_URL;

    public static long BASE_TIMEOUT_WAIT;

    @BeforeClass
    public static void initEnvironment() {

        logger.info("#########################################################################");
        logger.info("#########################################################################");

        RUN_HTMLUNIT = getConfigurationProperty("RUN_HTMLUNIT", "test.run.htmlunit", true);

        logger.info("running the tests in HtmlUnit: " + RUN_HTMLUNIT);

        RUN_IE = getConfigurationProperty("RUN_IE", "test.run.ie", false);

        logger.info("running the tests in Internet Explorer: " + RUN_IE);

        RUN_EDGE = getConfigurationProperty("RUN_EDGE", "test.run.edge", false);

        logger.info("running the tests in Edge: " + RUN_EDGE);


        RUN_FIREFOX = getConfigurationProperty("RUN_FIREFOX", "test.run.firefox", false);

        logger.info("running the tests in Firefox: " + RUN_FIREFOX);

        RUN_CHROME = getConfigurationProperty("RUN_CHROME", "test.run.chrome", false);

        logger.info("running the tests in Chrome: " + RUN_CHROME);

        RUN_OPERA = getConfigurationProperty("RUN_OPERA", "test.run.opera", false);

        logger.info("running the tests in Opera: " + RUN_OPERA);

        SELENIUM_HUB_URL = getConfigurationProperty(
            "SELENIUM_HUB_URL", "test.selenium.hub.url", "http://localhost:4444/wd/hub");

        logger.info("using Selenium hub at: " + SELENIUM_HUB_URL);

        TARGET_SERVER_URL = getConfigurationProperty(
            "TARGET_SERVER_URL", "test.target.server.url", "http://localhost:58080/petclinic");

        logger.info("using target server at: " + TARGET_SERVER_URL);

        BASE_TIMEOUT_WAIT = getConfigurationProperty(
                "BASE_TIMEOUT_WAIT", "test.wait.timeout.base",Long.parseLong("5"));

            logger.info("base timeout for driver wait: " + BASE_TIMEOUT_WAIT);

        logger.info("#########################################################################");
        logger.info("#########################################################################\n");

    }

    private static long getConfigurationProperty(String envKey, String sysKey, long defValue) {

        long retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if (sysValue != null) {
            retValue = Long.parseLong(sysValue);
        } else if (envValue != null) {
            retValue = Long.parseLong(envValue);
        }
        return retValue;
    }

    private static String getConfigurationProperty(String envKey, String sysKey, String defValue) {

        String retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if (sysValue != null) {
            retValue = sysValue;
        } else if (envValue != null) {
            retValue = envValue;
        }
        return retValue;
    }

    private static boolean getConfigurationProperty(String envKey, String sysKey, boolean defValue) {

        boolean retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if (sysValue != null) {
            retValue = Boolean.parseBoolean(sysValue);
            logger.debug("- return value for "+sysKey+"-"+sysValue);
        } else if (envValue != null) {
            retValue = Boolean.parseBoolean(envValue);
            logger.debug("- return value for "+envKey+"-"+envValue);
        }
        return retValue;
    }
}
