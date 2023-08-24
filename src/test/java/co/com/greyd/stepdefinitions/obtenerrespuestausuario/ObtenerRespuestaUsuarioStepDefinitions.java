package co.com.greyd.stepdefinitions.obtenerrespuestausuario;



import co.com.greyd.models.Servicio;
import co.com.greyd.questions.CodigoDeEstado;
import co.com.greyd.tasks.EnviarPeticion;
import co.com.greyd.tasks.RecibirRespuesta;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ObtenerRespuestaUsuarioStepDefinitions {

    public final static String ACTOR = "actor";
    public final static Servicio service = new Servicio(0,"","");

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^yo cuando hago una peticion al servicio$")
    public void yoCuandoHagoUnaPeticionAlServicio() {
        theActorCalled(ACTOR).wasAbleTo(EnviarPeticion.alApi());
    }

    @When("^recibo una respuesta del servicio$")
    public void reciboUnaRespuestaDelServicio() {
        theActorInTheSpotlight().attemptsTo(RecibirRespuesta.de(service));
    }

    @Then("^puedo validar de que el estado es correcto$")
    public void puedoValidarDeQueElEstadoEsCorrecto() {
        OnStage.theActorInTheSpotlight().should(seeThat(CodigoDeEstado.esCorrectoCon(service)));
    }
}
