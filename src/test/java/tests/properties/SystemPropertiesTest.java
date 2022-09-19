package tests.properties;

import org.junit.jupiter.api.Tag;
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
    @Tag("properties")
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

    gradle clean properties_test
                101
                1920x1080
                firefox

    gradle clean properties_test -Dbrowser_name=safari
                101
                1920x1080
                safari
     gradle clean properties_test -Dbrowser_name=safari -Dbrowser_version=99.0 -Dbrowser_size=300x300
                99
                300x300
                safari
     */

    @Test
    @Tag("hello")
    void simplePropertiesTest5() {
        System.out.println("Hello, " + System.getProperty("some_text", "qa.guru"));
        System.out.println("This is remote URL " + System.getProperty("remote", "qa.guru"));
        String browserVersion = System.getProperty("browser_version", "101");
    }

    /*
        gradle clean hello_test
            Hello, qa.guru

        gradle clean hello_test -Dsome_text=students
            Hello, students

        gradle clean hello_test -Dsome_text=students of qa.guru
                FAILURE: Build failed with an exception.
                * What went wrong:
                Task 'of' not found in root project 'qa_guru_14_11_jenkins'.

        gradle clean hello_test -Dsome_text="students of qa.guru"
            Hello, students of qa.guru

        gradle clean hello_test "-Dsome_text=students of qa.guru"
            Hello, students of qa.guru
         */
}
