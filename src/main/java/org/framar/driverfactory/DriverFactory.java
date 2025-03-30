package org.framar.driverfactory;

import org.framar.exceptions.UtilException;
import org.openqa.selenium.WebDriver;

import static org.framar.driverfactory.Constants.CHROME;
import static org.framar.driverfactory.Constants.IE;

public class DriverFactory {
    private DriverFactory() {
        throw new UtilException();
    }

    public static WebDriver selectDriver(String browser) {
        DriverSetup driverSetup;
        String browserLowerCase = browser.toLowerCase().strip();

        driverSetup = switch (browserLowerCase) {
            case IE -> new IEDriverSetup();
            case CHROME -> new ChromeDriverSetup();
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        };

        return driverSetup.createDriver();
    }
}
