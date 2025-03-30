package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.framar.tasks.Search;

public class SearchStepdefs {
    Actor actor;

    public SearchStepdefs() {
        this.actor = OnStage.theActorInTheSpotlight();
    }

    @Given("open search in internet explorer")
    public void openSearchInInternetExplorer() {
        actor.wasAbleTo(Open.url("https://www.google.com.pe"));
    }

    @And("busco resultados para {string}")
    public void buscoResultadosPara(String busqueda) {
        actor.attemptsTo(Search.of("SCREENPLAY"));
    }
}
