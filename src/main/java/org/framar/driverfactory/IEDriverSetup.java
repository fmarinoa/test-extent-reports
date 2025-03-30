package org.framar.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;

import static org.framar.driverfactory.Constants.IE_DRIVER_PATH;

public class IEDriverSetup implements DriverSetup {
    @Override
    public WebDriver createDriver() {
        // Ruta del binario IEDriverServer.exe
        File ieDriverPath = new File(IE_DRIVER_PATH);

        // Crear el servicio de IEDriver
        InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
                .usingDriverExecutable(ieDriverPath)
                .usingAnyFreePort() // Usa un puerto libre
                .build();

        // Configurar opciones para IE
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.ignoreZoomSettings();
        options.introduceFlakinessByIgnoringSecurityDomains();

        return new InternetExplorerDriver(service, options);
    }


}
