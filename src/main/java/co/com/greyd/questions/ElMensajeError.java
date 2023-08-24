package co.com.greyd.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElMensajeError implements Question {
    private static String msjError;

    public ElMensajeError(String msjError) {
        this.msjError=msjError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return msjError.equals("Missing password");
    }
    public static ElMensajeError esVisible(String msjError){return new ElMensajeError(msjError);}
}
