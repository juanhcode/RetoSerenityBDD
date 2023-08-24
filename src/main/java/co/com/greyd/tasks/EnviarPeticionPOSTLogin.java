package co.com.greyd.tasks;

import co.com.greyd.models.Peticion;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnviarPeticionPOSTLogin implements Task {

    String url = "https://reqres.in";
    String resourceName="/api/login";

    private Peticion peticion;

    public EnviarPeticionPOSTLogin(Peticion peticion) {
        this.peticion = peticion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String bodyRequest = "{\"email\": \""+peticion.getEmail()+"\",\"password\": \""+peticion.getPassword()+"\"}";
        actor.whoCan(CallAnApi.at(url));
        actor.attemptsTo(
                Post.to(resourceName).with(
                        requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(bodyRequest)
                )
        );

    }
    public static EnviarPeticionPOSTLogin conInfo(Peticion peticion){return instrumented(EnviarPeticionPOSTLogin.class,peticion);}

}
