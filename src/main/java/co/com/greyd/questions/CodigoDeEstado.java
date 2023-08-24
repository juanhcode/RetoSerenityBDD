package co.com.greyd.questions;

import co.com.greyd.models.Servicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoDeEstado implements Question<Boolean> {
    private static Servicio servicio;

    public CodigoDeEstado(Servicio servicio) {
        this.servicio=servicio;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return servicio.getStatusCode() == 200;
    }

    public static CodigoDeEstado esCorrectoCon(Servicio servicio){
        return new CodigoDeEstado(servicio);
    }
}
