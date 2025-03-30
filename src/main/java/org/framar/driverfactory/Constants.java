package org.framar.driverfactory;

import org.framar.exceptions.ConstantException;

public class Constants {
    private Constants() {
        throw new ConstantException();
    }

    protected static final String IE_DRIVER_PATH = "src/main/resources/drivers/IEDriverServer.exe";
    protected static final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver.exe";
    protected static final String CHROME = "chrome";
    protected static final String IE = "internet explorer";
}
