package org.framar.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_SEARCH = Target.the("campo de busqueda")
            .located(By.name("q"));
    public static final Target BTN_SEARCH = Target.the("botón de busqueda")
            .located(By.name("btnK"));
}
