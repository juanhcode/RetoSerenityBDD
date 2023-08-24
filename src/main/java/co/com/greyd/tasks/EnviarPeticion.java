package co.com.greyd.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnviarPeticion implements Task {

    String url ="https://reqres.in";
    String resourceName="/api/users/2";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(url));
        actor.attemptsTo(Get.resource(resourceName));
        System.out.println(SerenityRest.lastResponse().getStatusCode());
        System.out.println(SerenityRest.lastResponse().getBody().prettyPeek());
    }

    public static final EnviarPeticion alApi()
    {return instrumented(EnviarPeticion.class);}
}
