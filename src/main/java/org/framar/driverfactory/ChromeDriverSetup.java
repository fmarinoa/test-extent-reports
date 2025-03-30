package org.framar.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static org.framar.driverfactory.Constants.CHROME_DRIVER_PATH;

public class ChromeDriverSetup implements DriverSetup {
    @Override
    public WebDriver createDriver() {
        // Ruta del binario chromedriver.exe
        File chromeDriverPath = new File(CHROME_DRIVER_PATH);

        // Crear el servicio de IEDriver
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriverPath)
                .usingAnyFreePort() // Usa un puerto libre
                .build();

        // Configurar opciones para IE
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        return new ChromeDriver(service, options);
    }


}
