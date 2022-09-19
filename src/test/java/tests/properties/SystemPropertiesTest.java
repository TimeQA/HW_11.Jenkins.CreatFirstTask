package tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    void simplePropertiesTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertiesTest1() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera
    }

    @Test
    void simplePropertiesTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // firefox
    }

    @Test
    void simplePropertiesTest3() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // opera
    }
    @Test
    void simplePropertiesTest4() {
        String browserVersion = System.getProperty("browser_version", "101");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        String browserName = System.getProperty("browser_name", "firefox");

        System.out.println(browserVersion); //
        System.out.println(browserSize); //
        System.out.println(browserName); //
    }
    /*
    From IDEA
                101
                1920x1080
                firefox


     */
}
