package stepDefinitions;

import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.Login;
import tasks.LoginUser;

public class LoginStepDefinitions {

  private static final String resApiUrl = "https://reqres.in/api";
  Actor park = Actor.named("Park");

  @Given("^Park necesita loguearse en la pagina$")
  public void parkNecesitaLoguearseEnLaPagina() {
    park.whoCan(CallAnApi.at(resApiUrl));
  }

  @When("^el envia los datos para loguearse$")
  public void elEnviaLosDatosParaLoguearse() {
    String body =
        "{\n"
            + "    \"email\": \"eve.holt@reqres.in\",\n"
            + "    \"password\": \"cityslicka\"\n"
            + "}";
    park.attemptsTo(LoginUser.loginuser(body));
  }

  @Then("^el obtiene una respuesta exitosa$")
  public void elObtieneUnaRespuestaExitosa() {
    park.should(GivenWhenThen.seeThat("Codigo de respuesta", Login.was(), equalTo(200)));
  }
}
