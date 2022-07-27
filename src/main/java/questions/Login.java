package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Login implements Question {

  @Override
  public Object answeredBy(Actor actor) {
    return SerenityRest.lastResponse().statusCode();
  }

  public static Question<Integer> was() {
    return new Login();
  }
}
