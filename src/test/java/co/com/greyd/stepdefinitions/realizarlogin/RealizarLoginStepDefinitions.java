package co.com.greyd.stepdefinitions.realizarlogin;

import co.com.greyd.models.Peticion;
import co.com.greyd.models.Servicio;
import co.com.greyd.questions.ElMensajeError;
import co.com.greyd.questions.ElToken;
import co.com.greyd.tasks.EnviarPeticionPOSTLogin;
import co.com.greyd.tasks.RecibirRespuesta;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RealizarLoginStepDefinitions {

    public final static String ACTOR = "actor";
    public final static Servicio service = new Servicio(0,"","");

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^Envio la peticion POST$")
    public void envioLaPeticionPOST(List<String> datos) {
        Peticion peticion = new Peticion(datos.get(0),datos.get(1));
        theActorCalled(ACTOR).wasAbleTo(EnviarPeticionPOSTLogin.conInfo(peticion));

    }

    @When("^recibo la respuesta del servicio$")
    public void reciboLaRespuestaDelServicio() {
        theActorInTheSpotlight().attemptsTo(RecibirRespuesta.de(service));
    }

    @Then("^podre validar el token$")
    public void podreValidarElToken() {
        String token = service.getBody().substring(16,33);
        System.out.println(token);
        theActorInTheSpotlight().should(seeThat(ElToken.esElMismo(token)));
    }

    @Then("^podre ver el mensaje de error$")
    public void podreVerElMensajeDeError() {
        String msjError = service.getBody().substring(16,32);
        System.out.println(msjError);
        theActorInTheSpotlight().should(seeThat(ElMensajeError.esVisible(msjError)));

    }
}
