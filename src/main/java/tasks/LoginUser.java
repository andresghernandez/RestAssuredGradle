package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class LoginUser implements Task {

  private final String body;

  public LoginUser(String body) {

    this.body = body;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("/login")
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(body)));
  }

  public static LoginUser loginuser(String body) {
    return Tasks.instrumented(LoginUser.class, body);
  }
}
