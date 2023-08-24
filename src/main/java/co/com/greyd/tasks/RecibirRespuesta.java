package co.com.greyd.tasks;

import co.com.greyd.models.Servicio;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RecibirRespuesta implements Task {

    private static Servicio service;

    public RecibirRespuesta(Servicio service) {
        this.service =service;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        service.setStatusCode(SerenityRest.lastResponse().getStatusCode());
        service.setBody(SerenityRest.lastResponse().getBody().prettyPrint());
        service.setSessionID(SerenityRest.lastResponse().getSessionId());
    }
    public static final RecibirRespuesta de(Servicio service) {return instrumented(RecibirRespuesta.class, service);}

}
