package org.framar.tasks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static org.framar.userinterface.LoginPage.BTN_SEARCH;
import static org.framar.userinterface.LoginPage.INPUT_SEARCH;

public class Search implements Task {

    private final String string;

    public Search(String string) {
        this.string = string;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(string).into(INPUT_SEARCH),
                Click.on(BTN_SEARCH)
        );

        ExtentTest currentStep = ExtentCucumberAdapter.getCurrentStep();
        if (currentStep != null) {
            currentStep.info("Texto adicional en el reporte: Hola Mundo!");
        }
    }

    public static Search of(String string) {
        return Tasks.instrumented(Search.class, string);
    }


}
